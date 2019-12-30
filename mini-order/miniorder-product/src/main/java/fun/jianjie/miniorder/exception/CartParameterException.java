package fun.jianjie.miniorder.exception;

public class CartParameterException extends BaseException {
    private static final Integer code = 400;
    private static final String msg = "购物车参数格式错误";
    private static final String url = "";


    public CartParameterException() {
        super(code, msg, url);
    }

    public CartParameterException(String message) {
        super(code,message,url);
    }
}
