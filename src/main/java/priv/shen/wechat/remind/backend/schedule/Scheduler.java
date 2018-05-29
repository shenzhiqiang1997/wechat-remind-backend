package priv.shen.wechat.remind.backend.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import priv.shen.wechat.remind.backend.constant.Constant;
import priv.shen.wechat.remind.backend.repository.FormidRepository;
import priv.shen.wechat.remind.backend.util.AccessTokenUtil;

import java.util.Date;

@Component("myScheduler")
public class Scheduler {
    @Autowired
    private FormidRepository formidRepository;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private AccessTokenUtil accessTokenUtil;

    @Scheduled(initialDelay = 0,fixedRate = 3600*1000*2)
    public void refreshAccessToken() throws Exception {
        String accessToken = accessTokenUtil.getAccessToken();
        redisTemplate.opsForValue().set(Constant.ACCESS_TOKEN.getValue(),accessToken);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void homeworkDeleteScheduler(){
        Date deleteDate = new Date((new Date().getTime()-3600*1000*24*6));
        formidRepository.deleteAllByDateBefore(deleteDate);
    }
}
