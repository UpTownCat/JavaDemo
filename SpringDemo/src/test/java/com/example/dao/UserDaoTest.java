package com.example.dao;

import com.example.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Test
    public void selectUserById() throws Exception {
        User user = userDao.selectUserById(1);
        logger.info("user = {}", user);
    }
    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("darkstar");
        user.setPassword("123456");
        user.setEmail("1347169498@qq.com");
        userDao.insertUser(user);
        logger.info("id = {}", user.getId());
    }
    @Test
    public void selectAllUser() {
        List<User> users = userDao.selectAllUser();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            logger.info("user = {}", user);
        }
    }

    @Test
    public void selectUserByUsername() {
        String username = "uptowncat";
        User user = userDao.selectUserByUsername(username);
        logger.info("user = {}", user);
    }

}