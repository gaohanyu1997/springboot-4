package com.ghy.boot.acutuator.health;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    /*
    * 编写检查方法
    * */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //mongodb 获取连接进行测试
        Map<String,Object> map = new HashMap<>();
        if(1 == 1){
            //builder.up();   //健康
            builder.status(Status.UP);
            map.put("count",1);
            map.put("ms",100);
        }else{
            //builder.down(); //不健康
            builder.status(Status.OUT_OF_SERVICE);
            map.put("err","连接超时");
            map.put("ms",3000);
        }
        builder.withDetail("code",100)
                .withDetails(map);
    }
}
