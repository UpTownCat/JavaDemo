package com.example.dao;

import com.example.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}