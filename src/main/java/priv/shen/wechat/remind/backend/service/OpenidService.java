package priv.shen.wechat.remind.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import priv.shen.wechat.remind.backend.constant.RequestParameter;
import priv.shen.wechat.remind.backend.constant.RequestURL;
import priv.shen.wechat.remind.backend.dto.CodeView;
import priv.shen.wechat.remind.backend.dto.OpenidJson;
import priv.shen.wechat.remind.backend.result.Flag;
import priv.shen.wechat.remind.backend.result.Result;

@Service
public class OpenidService {
    @Autowired
    private RestTemplate restTemplate;

    public Result<String> getOpenid(CodeView codeView) throws Exception {
        String code = codeView.getCode();

        String openidUrl = RequestURL.OPENID_URL.getPath()
                .replace(RequestParameter.APP_ID.getKey(),RequestParameter.APP_ID.getValue())
                .replace(RequestParameter.SECRET.getKey(),RequestParameter.SECRET.getValue())
                .replace(RequestParameter.JSCODE.getKey(),code);

        String openidJsonString = restTemplate.getForObject(openidUrl,String.class);
        ObjectMapper mapper = new ObjectMapper();
        OpenidJson openidJson = mapper.readValue(openidJsonString,OpenidJson.class);

        return new Result<>(Flag.SUCCESS.getCode(),openidJson.getOpenid());
    }
}
