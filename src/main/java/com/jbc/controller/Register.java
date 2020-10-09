package com.jbc.controller;

import com.jbc.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class Register {
    @RequestMapping("/register")
    public String RegisterUser(){
        return "注册";
    }

    @RequestMapping("/in2")
    public String EnterPage(
            @RequestParam("username") String username,
            @RequestParam("phone")String phone,
//            @RequestParam("form-code")String code,
            @RequestParam("form-password")String password,
            @RequestParam("form-repeat-password") String check,
            Model model) throws IOException {
        User user =new User(username,password,phone);
        User.SaveUser(user);  //存入txt
        return "登录";
    }

}
