package fun.jianjie.miniorder.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import fun.jianjie.miniorder.exception.CartParameterException;
import fun.jianjie.miniorder.service.OrderService;
import fun.jianjie.miniorder.service.TokenService;
import fun.jianjie.miniorder.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private TokenService tokenService;

    /**
     * 根据用户查询历史订单数据
     * @param token
     * @param page
     * @param pageSize
     * @return
     * @throws Exception
     */
    @GetMapping("order/by_user")
    public ResponseEntity<?> findSummaryOrderByUser(@RequestHeader("token") String token, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int pageSize) throws Exception {
        if(token == null){
            throw new Exception("请求头中需要token信息");
        }
        Integer uid = Integer.parseInt(tokenService.getCurrentUid(token, "uid").toString());

        PageHelper.startPage(page,pageSize);
        SummaryOrderVo summaryOrder = orderService.findSummaryOrder(uid,page,pageSize);

        return ResponseEntity.ok(summaryOrder);
    }

    /**
     * 根据订单id查询历史订单详情数据
     * @param token
     * @param oid
     * @return
     * @throws Exception
     */
    @GetMapping("order/{id}")
    public ResponseEntity<?> findSummaryOrderByUser(@RequestHeader("token") String token, @PathVariable("id") int oid) throws Exception {
        if(token == null){
            throw new Exception("请求头中需要token信息");
        }
        Integer uid = Integer.parseInt(tokenService.getCurrentUid(token, "uid").toString());
        //System.out.println("uid:"+uid+"oid:"+oid);
        OrderVo orderVo = orderService.findOrderByOid(uid,oid);
        if(orderVo == null){
            throw new Exception("没有该订单信息");
        }
        return ResponseEntity.ok(orderVo);
    }
    @PostMapping("order")
    @Transactional(rollbackFor=Exception.class)
    public ResponseEntity<?> placeOrder(@RequestHeader("token") String token, @RequestBody String cartProducts) throws Exception {


        //数据校验
        ObjectMapper objectMapper = new ObjectMapper();
        CartVo cartVo = null;
        try {
            cartVo = objectMapper.readValue(cartProducts, CartVo.class);
        }catch (Exception e){
            throw new CartParameterException("参数格式错误，请修改参数的名称符合规范");
        }
        System.out.println(cartVo);
        if(cartVo == null){
            throw new CartParameterException("购物车数据不能为空");
        }
        for (CartProductVo cartProductVo : cartVo.getProducts()) {

            if(cartProductVo.getCount() == null || cartProductVo.getCount() <= 0){
                throw new CartParameterException("参数错误，商品数量不能为空或者小于0");
            }
            if(cartProductVo.getProduct_id() == null || cartProductVo.getProduct_id() <= 0){
                throw new CartParameterException("参数错误，商品id不能为空或者小于0");
            }
        }



        //获取用户的uid
        Integer uid = Integer.parseInt(tokenService.getCurrentUid(token, "uid").toString());

        Object object = orderService.place(uid,cartVo);
        return ResponseEntity.ok(object);
    }
}
