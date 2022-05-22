package com.yz.demo.service.impl;

import com.yz.demo.config.Const;
import com.yz.demo.config.RedisService;
import com.yz.demo.service.PubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发布消息
 * version: 1.0
 */
@Service
public class PubServiceImpl implements PubService {

    @Autowired
    private RedisService redisService;

    /**
     * 发布消息
     *
     * @param msg 消息
     * @return success
     */
    @Override
    public String pushMsg(String msg) {
        redisService.sendMess(Const.CHANNEL, msg);
        return "success";
    }
}
