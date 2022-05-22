package com.yz.demo.service;

/**
 * 发送消息
 *
 * version: 1.0
 */
public interface PubService {

    /**
     * 发送消息
     *
     * @param msg 消息
     * @return success
     */
    String pushMsg(String msg);
}
