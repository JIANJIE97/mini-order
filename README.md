# 1、商品分类模块：

##### (1)获取所有商品分类信息(get)：https://jianjie.fun:7000/category/all

# 2、登录令牌token模块：

##### (1)根据请求体中的code码生成token令牌(post):  https://jianjie.fun:7000/token/user

##### (2)根据请求体中的token令牌查看缓存是否登录(post):  https://jianjie.fun:7000/token/verify

# 3、地址信息模块：

##### (1)获取当前用户的地址信息(get请求,但是请求头中必须包含token令牌)：https://jianjie.fun:7000/address

##### (2)更新当前用户的地址信息(post请求,请求头中必须包含token令牌)：https://jianjie.fun:7000/address

# 4、订单模块：

##### (1)根据当前用户来分页查询历史订单(get请求,但是请求头中必须包含token令牌)https://jianjie.fun:7000/order/by_user?page=1&pageSize=5

##### (2)根据订单id查询订单详情信息(get请求,但是请求头中必须包含token令牌):https://jianjie.fun:7000/order/1

##### (3)根据购物车数据生成订单(post请求,但是请求头中必须包含token令牌):https://jianjie.fun:7000/order

# 5、商品模块：

##### (1)根据商品分类id查询商品信息(get请求):https://jianjie.fun:7000/product/by_category?id=3

##### (2)根据商品id查询商品详情信息(get请求)：https://jianjie.fun:7000/product/1

# 6、微信小程序体验版

![](https://github.com/JIANJIE97/mini-order/blob/master/QRcode.jpg)



