package priv.shen.wechat.remind.backend.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.shen.wechat.remind.backend.exception.GlobalException;
import priv.shen.wechat.remind.backend.result.Message;
import priv.shen.wechat.remind.backend.result.Flag;
import priv.shen.wechat.remind.backend.result.MessageResult;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public MessageResult globalExceptionHandler(Exception e){
        e.printStackTrace();
        if (e instanceof GlobalException)
            return new MessageResult(Flag.SUCCESS.getCode(),e.getMessage());
        else
            return new MessageResult(Flag.FAILURE.getCode(), Message.SYSTEM_FAILURE.getContent());
    }
}
