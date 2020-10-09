package com.jbc.controller;

import com.jbc.Question.RandomDouble;
import com.jbc.Question.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class Question {
    @RequestMapping("/index/choose")
    public String ChoosingLevel(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");  //获取session
        String password = (String) session.getAttribute("password");
        model.addAttribute("username", username);  //设置model
        model.addAttribute("password", password);
        return "做题";
    }

    @GetMapping("/index/readquestion")
    public String GettingQuestion(
            @RequestParam(value = "number" ,defaultValue = "10") String number,
            @RequestParam(value = "level",defaultValue = "小学") String level,
            Model model,HttpSession session
    ) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] QuestionArrayList =new String[Integer.parseInt(number)];  //问题
        String[] AnswerArrayList = new String[Integer.parseInt(number)];  //答案
        String[] RealArrayListA = RandomDouble.GetRandom(Integer.parseInt(number));  //A选项
        String[] RealArrayListB = RandomDouble.GetRandom(Integer.parseInt(number));  //B选项
        String[] RealArrayListC = RandomDouble.GetRandom(Integer.parseInt(number));  //C选项
        String[] RealArrayListD = RandomDouble.GetRandom(Integer.parseInt(number));  //D选项
        if (level.equals("小学"))  //难度选择
        {
            arrayList = Test.GetPrimary(Integer.parseInt(number));
        }
        if (level.equals("初中"))
        {
            arrayList = Test.GetJunior(Integer.parseInt(number));
        }
        if (level.equals("高中"))
        {
            arrayList = Test.GetHigh(Integer.parseInt(number));
        }
        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.println(arrayList.get(i));
            if (i%2==0)
            {
                QuestionArrayList[i/2]=arrayList.get(i);  //读入题目
            }
            else
            {
                AnswerArrayList[i/2]=arrayList.get(i);  //读入答案
            }
        }
        for (int i = 0; i < AnswerArrayList.length; i++) {
            switch (new Random().nextInt(4))  //随机存入A、B、C、D选项中
            {
                case 0:
                    RealArrayListA[i]=AnswerArrayList[i];
                    break;
                case 1:
                    RealArrayListB[i]=AnswerArrayList[i];
                    break;
                case 2:
                    RealArrayListC[i]=AnswerArrayList[i];
                    break;
                case 3:
                    RealArrayListD[i]=AnswerArrayList[i];
                    break;
                default:
                    break;
            }
        }
        model.addAttribute("questions",QuestionArrayList);  //存入model
        model.addAttribute("answer",AnswerArrayList);
        model.addAttribute("number",Integer.parseInt(number));
        model.addAttribute("options_A",RealArrayListA);
        model.addAttribute("options_B",RealArrayListB);
        model.addAttribute("options_C",RealArrayListC);
        model.addAttribute("options_D",RealArrayListD);
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "做题";
    }
}
