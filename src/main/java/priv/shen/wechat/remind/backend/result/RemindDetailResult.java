package priv.shen.wechat.remind.backend.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemindDetailResult {
    private String title;
    private String content;
    private String name;
}


