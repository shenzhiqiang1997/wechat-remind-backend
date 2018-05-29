package priv.shen.wechat.remind.backend.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import priv.shen.wechat.remind.backend.constant.Constant;
import priv.shen.wechat.remind.backend.util.AccessTokenUtil;

@Component
public class Scheduler {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private AccessTokenUtil accessTokenUtil;
    @Scheduled(fixedRate = 3600*1000*2)
    public void refreshAccessToken() throws Exception {
        String accessToken = accessTokenUtil.getAccessToken();
        redisTemplate.opsForValue().set(Constant.ACCESS_TOKEN.getValue(),accessToken);
    }
}
