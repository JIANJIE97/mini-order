package fun.jianjie.miniorder.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "wx-config")       //属性读取类接收application.yml中的wxConfig下面的属性
public class WxProperties {
    private String img_url_prefix;
    private String wx_app_id;
    private String wx_app_secret;
    private String wx_login_url;
    private String token_salt;
    private long token_expire;

    public String getImg_url_prefix() {
        return img_url_prefix;
    }

    public void setImg_url_prefix(String img_url_prefix) {
        this.img_url_prefix = img_url_prefix;
    }

    public String getWx_app_id() {
        return wx_app_id;
    }

    public void setWx_app_id(String wx_app_id) {
        this.wx_app_id = wx_app_id;
    }

    public String getWx_app_secret() {
        return wx_app_secret;
    }

    public void setWx_app_secret(String wx_app_secret) {
        this.wx_app_secret = wx_app_secret;
    }

    public String getWx_login_url() {
        return wx_login_url;
    }

    public void setWx_login_url(String wx_login_url) {
        this.wx_login_url = wx_login_url;
    }

    public String getToken_salt() {
        return token_salt;
    }

    public void setToken_salt(String token_salt) {
        this.token_salt = token_salt;
    }

    public long getToken_expire() {
        return token_expire;
    }

    public void setToken_expire(long token_expire) {
        this.token_expire = token_expire;
    }
}
