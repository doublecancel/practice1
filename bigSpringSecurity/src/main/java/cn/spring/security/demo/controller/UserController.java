package cn.spring.security.demo.controller;

import cn.spring.security.demo.entity.UserDomain;
import cn.spring.security.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 201/3.
 */
@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/all/test")
    public String login(){
        return "/all/test";
    }

    @RequestMapping("/user/test")
    public String login1(){
        return "/user/test";
    }


    @RequestMapping("/admin/test")
    public String login2(){
        return "/admin/test";
    }


    @RequestMapping("/both/test")
    public String login3(){
        return "/both/test";
    }

    @RequestMapping("/or/test")
    public String login4(){
        return "/or/test";
    }


    @PostMapping("/register")
    public UserDomain register(@RequestBody UserDomain domain){
        domain.setPassword(new BCryptPasswordEncoder().encode(domain.getPassword()));
        domain.setCreate_date(LocalDateTime.now());
        return userService.insert(domain);
    }


}
