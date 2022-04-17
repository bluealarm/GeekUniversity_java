package com.yz.datasourcedemo.service;

import com.yz.datasourcedemo.bean.User;

/**
 * UserService
 */
public interface UserService {

    /**
     * 根据id 查询
     * @param id 用户id
     * @return 返回user
     */
    User findById(int id);

    /**
     * 根据id修改
     * @param user user
     * @return 返回更新状态
     */
    int updateUserById(User user);
}
