package com.example.dao;

import com.example.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2017/8/27.
 */
public interface UserDao {
    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User selectUserById(int id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 列出所有用户
     * @return
     */
    List<User> selectAllUser();
    User selectUserByUsername(String username);
}
