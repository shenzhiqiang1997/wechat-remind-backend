package priv.shen.wechat.remind.backend.dto;

import lombok.Data;

@Data
public class AgreeView {
    private String receiverOpenId;
    private Long clockId;
    private Integer check;
}
