# mini-order
需要启动redis服务器

提供的接口服务url：

商品分类模块：
获取所有商品分类信息(get)：http://localhost:8080/category/all

登录令牌token模块：
根据请求体中的code码生成token令牌(post):  http://localhost:8080/token/user
根据请求体中的token令牌查看缓存是否登录(post):  http://localhost:8080/token/verify

地址信息模块：
获取当前用户的地址信息(get请求,但是请求头中必须包含token令牌)：http://localhost:8080/address
更新当前用户的地址信息(post请求,请求头中必须包含token令牌)：http://localhost:8080/address

订单模块：
根据当前用户来分页查询历史订单(get请求,但是请求头中必须包含token令牌):http://localhost:8080/order/by_user?page=1&pageSize=5
根据订单id查询订单详情信息(get请求,但是请求头中必须包含token令牌):http://localhost:8080/order/1
根据购物车数据生成订单(post请求,但是请求头中必须包含token令牌):http://localhost:8080/order

商品模块：
根据商品分类id查询商品信息(get请求):http://localhost:8080/product/by_category?id=3
根据商品id查询商品详情信息(get请求)：http://localhost:8080/product/1
