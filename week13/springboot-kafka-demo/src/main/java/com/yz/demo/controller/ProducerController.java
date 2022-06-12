package com.yz.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 生产者
 * version: 1.0
 */
@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/sendMsg")
    public void sendMsg() {
        kafkaTemplate.send("test02", UUID.randomUUID().toString());
    }

}
