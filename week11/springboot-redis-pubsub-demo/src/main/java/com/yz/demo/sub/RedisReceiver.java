package com.yz.demo.sub;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * 处理接收消息
 *
 * version: 1.0
 */
@Component
@Log4j2
public class RedisReceiver {

    /**
     * 接收订阅消息
     *
     * @param message 消息
     */
    public void receiveMessage(String message) {
        log.info("接收消息:" + message);
    }
}
