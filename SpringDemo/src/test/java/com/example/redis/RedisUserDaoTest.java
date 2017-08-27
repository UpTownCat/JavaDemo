package com.example.redis;

import com.example.bean.User;
import com.example.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class RedisUserDaoTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUserDao redisUserDao;
    @Autowired
    private UserDao userDao;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void connect() {
        Long expire = redisTemplate.getExpire("k1");
        logger.info("expire = {}", expire);
    }

    /**
     * 保存
     */
    @Test
    public void setUser() {
        User user = userDao.selectUserByUsername("uptowncat");
        redisUserDao.setUser(user);
        logger.info("save user successfully!");
    }

    /**
     * 获取
     */
    @Test
    public void  getUser() {
        int id = 1;
        User user = redisUserDao.getUser(id);
        logger.info("user = {}", user);
    }
}
