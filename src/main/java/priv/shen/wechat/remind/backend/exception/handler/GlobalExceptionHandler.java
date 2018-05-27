package priv.shen.wechat.remind.backend.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import priv.shen.wechat.remind.backend.exception.GlobalException;
import priv.shen.wechat.remind.backend.result.Message;
import priv.shen.wechat.remind.backend.result.Flag;
import priv.shen.wechat.remind.backend.result.Result;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result<String> globalExceptionHandler(Exception e){
        e.printStackTrace();
        if (e instanceof GlobalException)
            return new Result<>(Flag.SUCCESS.getCode(),e.getMessage());
        else
            return new Result<>(Flag.FAILURE.getCode(), Message.SYSTEM_FAILURE.getContent());
    }
}
