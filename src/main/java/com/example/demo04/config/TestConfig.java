package com.example.demo04.config;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component()
public class TestConfig implements ApplicationRunner {

//    @Bean
//    public String  testConfig(){
//        System.out.println("+++++++++++++++++++++我是啥表");
//        return  "hhha";
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("+++++++++++++++++++++我是啥表");
    }
}
