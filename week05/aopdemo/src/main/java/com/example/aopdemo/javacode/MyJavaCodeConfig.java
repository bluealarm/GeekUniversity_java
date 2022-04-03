package com.example.aopdemo.javacode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyJavaCodeConfig {

    @Bean
    public com.example.aopdemo.javacode.MyJavaCodeExample javaCodeExample() {
        return new com.example.aopdemo.javacode.MyJavaCodeExample();
    }
}
