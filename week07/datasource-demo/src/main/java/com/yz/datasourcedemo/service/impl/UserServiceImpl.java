package com.yz.datasourcedemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yz.datasourcedemo.bean.User;
import com.yz.datasourcedemo.componet.CurDataSource;
import com.yz.datasourcedemo.datasource.DataSourceNames;
import com.yz.datasourcedemo.mapper.UserMapper;
import com.yz.datasourcedemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @CurDataSource(name = DataSourceNames.SECOND)
    @Override
    public User findById(int id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public int updateUserById(User user) {
        return this.baseMapper.updateById(user);
    }
}
