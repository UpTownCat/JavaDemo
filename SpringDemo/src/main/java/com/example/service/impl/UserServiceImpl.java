package com.example.service.impl;

import com.example.bean.User;
import com.example.service.UserService;

/**
 * Created by Administrator on 2017/8/26.
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");
        user.setEmail("158668658@qq.com");
        return user;
    }
}