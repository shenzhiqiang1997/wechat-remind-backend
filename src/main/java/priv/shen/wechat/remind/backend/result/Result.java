package priv.shen.wechat.remind.backend.result;

import lombok.Data;

@Data
public class Result<T>{
    private Integer flag;
    private T data;
}
