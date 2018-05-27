package priv.shen.wechat.remind.backend.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  Message {
    SYSTEM_FAILURE("系统错误");
    private String content;

}
