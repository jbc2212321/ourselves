package com.jbc.controller;

import com.jbc.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class Index {
    @RequestMapping(value = "/in")
    public String SignIndex(
            @RequestParam(value = "username") String sUsername,
            @RequestParam(value = "password") String sPassword,
            Model model,
            HttpSession session) throws IOException {
        ArrayList<User>userArrayList = User.GetUser();
        for (User user: userArrayList)
        {
            if (user.GetM_username().equals(sUsername)&&user.GetM_password().equals(sPassword))//判断用户名和密码是否匹配
            {
                session.setAttribute("username",sUsername);//设置session
                session.setAttribute("password",sPassword);
                model.addAttribute("username",sUsername);  //设置model
                model.addAttribute("password",sPassword);
                return "index";
            }
        }
            model.addAttribute("msg","用户名或密码错误！");  //错误提示
            return "登录";

    }


    @RequestMapping("/index")
    public String StartIndex()
    {
        return "登录";
    }

    @RequestMapping("/index/in")
    public String GetIndex(HttpSession session,Model model){
        String username = (String) session.getAttribute("username"); //获得session
        String password = (String) session.getAttribute("password");
        model.addAttribute("username",username);  //设置model
        model.addAttribute("password",password);
        return "index";
    }
}
