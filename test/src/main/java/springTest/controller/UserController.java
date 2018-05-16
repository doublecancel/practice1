package springTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springTest.service.UserService;

/**
 * Created by Administrator on 2017/8/25.
 */
@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/save")
    public String save(){
        userService.save();
        return "OK";
    }




}
