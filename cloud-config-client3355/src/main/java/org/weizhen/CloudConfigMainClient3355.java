package org.weizhen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudConfigMainClient3355 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigMainClient3355.class,args);
    }
}
