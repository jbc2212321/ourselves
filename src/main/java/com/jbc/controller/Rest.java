package com.jbc.controller;

import com.jbc.others.VerificationCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
    @GetMapping("/register/phone")
    public String GetCode(@RequestParam("phone")String phone){
        return VerificationCode.SendSms(phone);
    }//发送验证码
}
