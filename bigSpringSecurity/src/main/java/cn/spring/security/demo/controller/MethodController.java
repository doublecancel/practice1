package cn.spring.security.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/10.
 */
@RestController
@RequestMapping("/method")
public class MethodController {

    @PreAuthorize("hasRole('USER')")
    public String test1(){
        return "ok";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String test2(){
        return "ok";
    }

    @PreAuthorize("hasRole('ALL')")
    public String test3(){
        return "ok";
    }

}
