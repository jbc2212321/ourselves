package com.jbc.Question;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ipython
{
    public static String AnswerQuestion(String sGetQuestion) throws IOException
    {
        ClassPathResource classPathResource = new ClassPathResource("UsePython.py");
//        String env[]=new String[]{"path=D:\\anaconda3"};  //设置路径,有anaconda环境开启
        String[] arguments = new String[] {"cmd ","/c" ,"python "+classPathResource.getPath()+" "+sGetQuestion};//指令
        Process process = Runtime.getRuntime().exec(arguments);  //运行指令
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));  //读入并确定编码格式
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = in.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString(); //返回答案
    }

}
