package priv.shen.wechat.remind.backend.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResult {
    private Integer flag;
    private String message;
}
