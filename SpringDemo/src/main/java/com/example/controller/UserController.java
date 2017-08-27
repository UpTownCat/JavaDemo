package com.example.controller;

import com.example.bean.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/26.
 * 用户控制器
 */
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @PostMapping("/login")
    public String userLogin(User user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "users/user_info";
    }

    /**
     * 用户列表
     * @return
     */
    @GetMapping("/list")
    public String userList(Map<String, Object> map) {
        List<User> users = userService.getAllUsers();
        map.put("users", users);
        return "users/user_list";
    }

}
