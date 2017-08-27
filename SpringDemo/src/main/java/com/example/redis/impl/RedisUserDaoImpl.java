package com.example.redis.impl;

import com.example.bean.User;
import com.example.redis.RedisUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/27.
 */
@Component
public class RedisUserDaoImpl implements RedisUserDao {
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Override
    public void setUser(User user) {
        ValueOperations<String, User> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("user_id=" + user.getId(), user);
    }

    @Override
    public User getUser(int id) {
        ValueOperations<String, User> opsForValue = redisTemplate.opsForValue();
        User user = opsForValue.get("user_id=" + id);
        return user;
    }
}
