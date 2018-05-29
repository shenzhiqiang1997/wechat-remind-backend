package priv.shen.wechat.remind.backend.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestURL {
    OPENID_URL("https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code"),
    ACCESS_TOKEN_URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET"),
    TEMPLATE_MESSAGE_URL("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=");
    private String path;
}
