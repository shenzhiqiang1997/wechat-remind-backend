package priv.shen.wechat.remind.backend.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestParameter {
    APP_ID("APPID","wx2c0fb732c49f16ef"),
    SECRET("SECRET","ba0a20794e753a28e54de2c5d2c2f00a"),
    JSCODE("JSCODE","");
    private String key;
    private String value;
}
