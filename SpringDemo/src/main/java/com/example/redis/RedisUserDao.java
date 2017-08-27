package com.example.redis;

import com.example.bean.User;

/**
 * Created by Administrator on 2017/8/27.
 */
public interface RedisUserDao {
    /**
     * 保存用户
     * @param user
     */
    public void setUser(User user);

    /**
     * 获取用户
     * @param id
     * @return
     */
    public User getUser(int id);
}
