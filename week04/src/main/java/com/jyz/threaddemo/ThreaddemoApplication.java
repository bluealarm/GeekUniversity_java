package com.jyz.threaddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.RunnableFuture;

@SpringBootApplication
public class ThreaddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreaddemoApplication.class, args);
    }

}
