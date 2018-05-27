package priv.shen.wechat.remind.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemindDetail {
    private String title;
    private String content;
    private String name;
}
