package com.jbc.User;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class User {
    private String m_username;
    private String m_password;
    private String m_phone;
    private static int m_id=0;

    public User(String m_username, String m_password, String m_phone) {
        this.m_username = m_username;
        this.m_password = m_password;
        this.m_phone = m_phone;
        m_id++;
    }

    public String GetM_username() {
        return m_username;
    }

    public void GetM_username(String m_username) {
        this.m_username = m_username;
    }

    public String GetM_password() {
        return m_password;
    }

    public void SetM_password(String m_password) {
        this.m_password = m_password;
    }

    public String GetM_phone() {
        return m_phone;
    }

    public void GetM_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    public static int getM_id() {
        return m_id;
    }

    public static void setM_id(int m_id) {
        User.m_id = m_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "m_username='" + m_username + '\'' +
                ", m_password='" + m_password + '\'' +
                ", m_phone='" + m_phone + '\'' +
                '}';
    }

    public static void SaveUser(User user) throws IOException {
        FileWriter fileWriter = null;
        try
        {
            File file=new File("E:\\programming\\java\\ourselves\\UserMessage.txt"); //读入txt
            fileWriter = new FileWriter(file, true);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(User.getM_id()+" "+user.m_username+" "+user.m_password+" "+user.m_phone);//写入数据
        printWriter.flush();
        try
        {
            fileWriter.flush();
            printWriter.close();
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void ClearAllUser() throws IOException {  //清空txt
        File file =new File("E:\\programming\\java\\ourselves\\UserMessage.txt");
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> GetUser() throws IOException {
        ArrayList<User> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\programming\\java\\ourselves\\UserMessage.txt"), StandardCharsets.UTF_8));  //读入
        String line = ""; //去除标题行
        while ((line = bufferedReader.readLine()) != null)
        {
            String[] item = line.split("\\s+");
            arrayList.add(new User(item[1],item[2],item[3]));  //读入user信息
        }
        return arrayList;
    }

}
