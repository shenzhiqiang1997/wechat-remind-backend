package priv.shen.wechat.remind.backend.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  Flag {
    SUCCESS(1),FAILURE(0);
    private int code;
}
