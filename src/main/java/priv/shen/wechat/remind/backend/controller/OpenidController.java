package priv.shen.wechat.remind.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.shen.wechat.remind.backend.dto.CodeView;
import priv.shen.wechat.remind.backend.result.OpenidResult;
import priv.shen.wechat.remind.backend.service.OpenidService;

@RestController
@RequestMapping("/openid")
public class OpenidController {
    @Autowired
    private OpenidService openidService;
    @PostMapping("/get")
    public OpenidResult get(@RequestBody CodeView codeView) throws Exception {
        return openidService.getOpenid(codeView);
    }
}
