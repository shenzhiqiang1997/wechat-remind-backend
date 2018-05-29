package priv.shen.wechat.remind.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.shen.wechat.remind.backend.dto.CodeView;
import priv.shen.wechat.remind.backend.result.OpenidResult;
import priv.shen.wechat.remind.backend.service.OpenidService;

@Api(value = "openid相关接口")
@RestController
@RequestMapping("/openid")
public class OpenidController {
    @Autowired
    private OpenidService openidService;

    @ApiOperation(value = "获取openid",response = OpenidResult.class)
    @PostMapping("/get")
    public OpenidResult get(@RequestBody CodeView codeView) throws Exception {
        return openidService.getOpenid(codeView);
    }
}
