package priv.shen.wechat.remind.backend.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T>{
    private Integer flag;
    private T data;
}
