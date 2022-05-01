package com.yz.rpcfx.demo.provider;

import com.yz.rpcfx.demo.api.User;
import com.yz.rpcfx.demo.api.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
