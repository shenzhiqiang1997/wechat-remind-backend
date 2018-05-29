package priv.shen.wechat.remind.backend;

import org.quartz.Scheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.client.RestTemplate;
import priv.shen.wechat.remind.backend.constant.Constant;
import priv.shen.wechat.remind.backend.util.AccessTokenUtil;
import java.text.SimpleDateFormat;

@SpringBootApplication
@EnableScheduling
public class WechatRemindBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatRemindBackendApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    public AccessTokenUtil accessTokenUtil(){
        return new AccessTokenUtil();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(new AdaptableJobFactory());
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true);
        return schedulerFactoryBean;
    }

    @Bean
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean){
        return schedulerFactoryBean.getScheduler();
    }

    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat(Constant.TIME_PATTERN.getValue());
    }
}
