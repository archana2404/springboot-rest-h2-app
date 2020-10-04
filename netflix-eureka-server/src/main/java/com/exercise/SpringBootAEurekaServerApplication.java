package com.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootAEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAEurekaServerApplication.class, args);
    }
}
