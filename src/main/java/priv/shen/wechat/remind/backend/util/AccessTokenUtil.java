package priv.shen.wechat.remind.backend.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import priv.shen.wechat.remind.backend.constant.RequestParameter;
import priv.shen.wechat.remind.backend.constant.RequestURL;
import priv.shen.wechat.remind.backend.dto.AccessTokenJson;

public class AccessTokenUtil {
    @Autowired
    private RestTemplate restTemplate;

    public String getAccessToken() throws Exception{
            String accessTokenUrl = RequestURL.ACCESS_TOKEN_URL.getPath()
                    .replace(RequestParameter.APP_ID.getKey(),RequestParameter.APP_ID.getValue())
                    .replace(RequestParameter.SECRET.getKey(),RequestParameter.SECRET.getValue());
            String accessTokenJsonString = restTemplate.getForObject(accessTokenUrl,String.class);
            ObjectMapper mapper = new ObjectMapper();
            AccessTokenJson accessTokenJson = mapper.readValue(accessTokenJsonString,AccessTokenJson.class);
            String accessToken = accessTokenJson.getAccess_token();
            return accessToken;
    }
}
