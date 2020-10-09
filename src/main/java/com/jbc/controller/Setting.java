package com.jbc.controller;

import com.jbc.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class Setting {
    @RequestMapping("/index/setting")
    public String ModifySetting(HttpSession session, Model model){
        String username = (String) session.getAttribute("username"); //获取session
        String password = (String) session.getAttribute("password");
        model.addAttribute("username",username);  //存入model
        model.addAttribute("password",password);
        return "pages-settings";
    }

    @ResponseBody
    @GetMapping("register/modify")
    public String ModifyPassword(
            @RequestParam("password")String new_password,
            HttpSession session
    ) throws IOException {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        ArrayList<User>userArrayList = User.GetUser();
        for (User user:userArrayList)
        {
            if (user.GetM_username().equals(username)&&user.GetM_password().equals(password)) //匹配用户
            {
                user.SetM_password(new_password);  //修改密码
            }
        }
        User.ClearAllUser();
        for (User user:userArrayList)
        {
            User.SaveUser(user);  //存入
        }
        return new_password;
    }

}
