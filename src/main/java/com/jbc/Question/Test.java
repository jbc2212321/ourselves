package com.jbc.Question;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;


public class Test //题目类，用于生成小学、初中、高中题目
{
    public static ArrayList<String> GetPrimary(int iNumber) throws IOException {//生成小学题目
        Random random =new Random();                //随机数
        String Operator[]=new String[]{"+","-","*","/"};                //操作符
        int i=iNumber;               //题目数量
        ArrayList<String>arrayList = new ArrayList<>();
        while (i>0)
        {
            int Operand=random.nextInt(4)+1;            //随机选择有多少个操作数
            String item[]=new String[2*Operand+1];               //字符串数组存贮题目
            for(int j=0;j<Operand*2+1;j++)
            {
                if (j%2==0)
                {
                    item[j]= String.valueOf(random.nextInt(100)+1);      //生成数字
                }
                else
                {
                    item[j]=Operator[random.nextInt(4)];                 //随机选择题目
                }
            }
            int left= 0;    //左括号
            int right=left;  //右括号
            if (Operand>1)   //当操作数=1时不需要括号
            {
                while (true)
                {
                    left=random.nextInt(2*Operand-1);
                    if (left%2==0)  //括号只能加在数字旁
                    {
                        break;
                    }
                }
                while (true)
                {
                    right=random.nextInt(2*Operand-left)+left+2;
                    if (right%2==0)  //理由同上
                    {
                        break;
                    }
                }
                if (left!=0&&right!=2*Operand)
                {
                    item[left]="("+item[left];
                    item[right]=item[right]+")";  //加括号
                }
            }
            StringBuilder stringBuffer =new StringBuilder();  //字符串数组转字符串
            for (String s : item)
            {
                stringBuffer.append(s);
            }
            String question = stringBuffer.toString();
            String questioncopy=question;
            question=(iNumber-i+1)+".    "+question;  //加入题号和空格
            arrayList.add(question);
            arrayList.add(Ipython.AnswerQuestion(questioncopy));
            i--;
        }
        return arrayList;
    }

    public static ArrayList<String> GetJunior(int iNumber) throws IOException {  //生成初中题目
        Random random =new Random();
        String Operator[]=new String[]{"+","-","*","/"};
        String Operator2[]=new String[]{"√","^2"};  //基本与小学相似，这里多加了2个操作符
        int i=iNumber;
        ArrayList<String>arrayList = new ArrayList<>();
        while (i>0)
        {
            int Operand=random.nextInt(4)+1;
            String item[]=new String[2*Operand+1];
            for(int j=0;j<Operand*2+1;j++)
            {
                if (j%2==0)
                {
                    item[j]= String.valueOf(random.nextInt(100)+1);
                }
                else
                {
                    item[j]=Operator[random.nextInt(4)];
                }
            }
            String copy[] = Arrays.copyOf(item,2*Operand+1);
            int left= 0;
            int right=left;  //以上代码与小学相似，不再赘述
            int left2=-1;  // 用于选择平方或开方的位置
            while (true)
            {
                left2=random.nextInt(2*Operand+1);
                if (left2%2==0)   //必须是数字部分
                {
                    break;
                }
            }
            int choose1=random.nextInt(2);  //生成随机数选择平方还是开方
            if (choose1==0)
            {
                item[left2]=Operator2[0]+item[left2];  //开方
                copy[left2]=Operator2[0]+"("+copy[left2]+")";
            }
            if (choose1==1)
            {
                item[left2]=item[left2]+Operator2[1];  //平方
                copy[left2]="("+copy[left2]+")"+"p2";
            }
            if (Operand>1)
            {
                while (true)
                {
                    left=random.nextInt(2*Operand-1);
                    if (left%2==0)
                    {
                        break;
                    }
                }
                while (true)
                {
                    right=random.nextInt(2*Operand-left)+left+2;
                    if (right%2==0)
                    {
                        break;
                    }
                }
                if (left!=0&&right!=2*Operand)
                {
                    item[left]="("+item[left];
                    item[right]=item[right]+")";
                }
            }
            StringBuilder stringBuffer =new StringBuilder();
            StringBuilder stringBuffercopy= new StringBuilder();
            for (String s : item)
            {
                stringBuffer.append(s);
            }
            for(String s:copy)
            {
                stringBuffercopy.append(s);
            }
            String question = stringBuffer.toString();
            String questioncopu=stringBuffercopy.toString();
            question=(iNumber-i+1)+".    "+question;  //与小学一样
            arrayList.add(question);
            arrayList.add(Ipython.AnswerQuestion(questioncopu));
            i--;
        }
        return arrayList;
    }

    public static ArrayList<String> GetHigh(int iNumber) throws IOException {
        Random random =new Random();
        String[] Operator =new String[]{"+","-","*","/"};
        String[] Operator2 =new String[]{"√","^2"};
        String[] Operator3 =new String[]{"sin","cos","tan"};  //生成高中题目所需的操作符
        String [] Operator4 = new String[]{"30","45","60","90"};  //生成特殊角度
        ArrayList<String>arrayList = new ArrayList<>();
        int i=iNumber;
        while (i>0)
        {
            int Operand=random.nextInt(4)+1;
            String item[]=new String[2*Operand+1];
            for(int j=0;j<Operand*2+1;j++)
            {
                if (j%2==0)
                {
                    item[j]= String.valueOf(random.nextInt(100)+1);
                }
                else
                {
                    item[j]=Operator[random.nextInt(4)];
                }
            }
            String copy[] = Arrays.copyOf(item,2*Operand+1);
            int left= 0;
            int right=left;
            int left2=-1;
            int left3=-1;  //生成三角函数的随机位置
            do {
                left3 = random.nextInt(2 * Operand + 1);
            } while (left3 % 2 != 0);
            do {
                left2 = random.nextInt(2 * Operand + 1);
            } while (left2 % 2 != 0);
            int choose1=random.nextInt(2);
            int choose2= random.nextInt(3); //三角函数
            if (choose2!=2)  //判断是否是tan
            {
                int chooseT=new Random().nextInt(4);
                item[left3]=Operator3[choose2]+"("+Operator4[chooseT]+")";//三角函数
                copy[left3]=Operator3[choose2]+"("+"q"+Operator4[chooseT]+"h"+")";
            }
            else if (choose2==2)
            {
                int chooseT=new Random().nextInt(3);
                item[left3]=Operator3[choose2]+"("+Operator4[chooseT]+")";
                copy[left3]=Operator3[choose2]+"("+"q"+Operator4[chooseT]+"h"+")";
            }

            if (choose1==0)
            {
                item[left2]=Operator2[0]+item[left2];
                copy[left2]=Operator2[0]+"("+copy[left2]+")";
            }
            if (choose1==1)
            {
                item[left2]=item[left2]+Operator2[1];
                copy[left2]="("+copy[left2]+")"+"p2";
            }
            if (Operand>1)
            {
                while (true)
                {
                    left=random.nextInt(2*Operand-1);
                    if (left%2==0)
                    {
                        break;
                    }
                }
                while (true)
                {
                    right=random.nextInt(2*Operand-left)+left+2;
                    if (right%2==0)
                    {
                        break;
                    }
                }
                if (left!=0&&right!=2*Operand)
                {
                    item[left]="("+item[left];
                    item[right]=item[right]+")";
                    copy[left]="("+copy[left];
                    copy[right]=copy[right]+")";
                }
            }
            StringBuilder stringBuffer =new StringBuilder();
            StringBuilder stringBuildercopy = new StringBuilder();
            for (String s : item)
            {
                stringBuffer.append(s);
            }
            for(String s:copy)
            {
                stringBuildercopy.append(s);
            }
            String question = stringBuffer.toString();
            String questioncopy = stringBuildercopy.toString();
            question=(iNumber-i+1)+".    "+question;
            arrayList.add(question);
            arrayList.add(Ipython.AnswerQuestion(questioncopy));
            i--;
        }
        return arrayList;
    }



}
