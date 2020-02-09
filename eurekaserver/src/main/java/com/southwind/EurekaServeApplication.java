package com.southwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wuyanshen
 * @date 2020-02-06 6:24 下午
 * @discription 启动类
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServeApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServeApplication.class, args);
    }
}
