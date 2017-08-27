package com.example.dao;

import com.example.bean.User;

/**
 * Created by Administrator on 2017/8/27.
 */
public interface UserDao {
    User selectUserById(int id);
}
