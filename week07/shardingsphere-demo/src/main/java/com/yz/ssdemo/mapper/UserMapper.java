package com.yz.ssdemo.mapper;

import com.yz.ssdemo.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Mapper
 */
@Repository
public interface UserMapper {

    User findUserById(int id);

    int updateUserById(User user);
}
