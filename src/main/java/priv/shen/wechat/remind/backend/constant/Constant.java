package priv.shen.wechat.remind.backend.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Constant {
    ACCESS_TOKEN("ACCESS_TOKEN"),
    TEMPLATE_ID("JdDz4Pvz4u9AoTsFjuZi4IAVdsIPsygFimhHKnzd3rk"),
    RECEIVER_OPENID("receiverOpenid"),
    SENDER_OPENID("senderOpenid"),
    REMIND_TEMPLATE_MESSAGE("remindTemplateMessage"),
    TEMPLATE_MESSAGE_SERVICE("templateMessageService"),
    TIME_PATTERN("yyyy/MM/dd HH:mm:ss");
    private String value;
}
