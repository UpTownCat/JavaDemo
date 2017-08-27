package com.example.service.impl;

import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 更加用户名获取用户
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }

    /**
     * 获取所有用户
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return userDao.selectAllUser();
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }
}
