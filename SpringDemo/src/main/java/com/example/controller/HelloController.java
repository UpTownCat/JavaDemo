package com.example.controller;

import com.example.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2017/8/26.
 */
@Controller
public class HelloController {

    @Autowired
    private RedisTemplate<String, User> userRedisTemplate;

    @GetMapping("/hello")
    public String greeting() {
        return "hello";
    }

    @GetMapping("/testRedis")
    public void testRedis() {
        User user = new User();
        user.setUsername("uptowncat");
        user.setPassword("******");
        user.setEmail("158668658@qq.com");
        Long time = userRedisTemplate.getExpire("name");
        System.out.println(time);
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/unauthorized")
    public String toUnauthorized() {
        return "unauthorized";
    }
}
