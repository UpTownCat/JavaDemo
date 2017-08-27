package com.example.service;

import com.example.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
public interface UserService {
    User getUserByUsername(String username);
    List<User> getAllUsers();
    int addUser(User user);
}
