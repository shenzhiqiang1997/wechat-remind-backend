package priv.shen.wechat.remind.backend.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  Message {
    SYSTEM_FAILURE("系统错误"),
    AGREE_SUCCESS("同意成功"),
    AGREE_FAILURE("同意失败，该提醒不存在"),
    DELETE_SUCCESS("删除成功"),
    DELETE_FAILURE("删除失败"),
    DETAIL_FAILURE("查看详细失败，没有权限或提醒不存在"),
    SAVE_SUCCESS("保存成功");
    private String content;
}
