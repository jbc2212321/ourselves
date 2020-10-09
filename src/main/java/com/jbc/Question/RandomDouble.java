package com.jbc.Question;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomDouble {
    public static String[]GetRandom(int iNumber){
        String[] answer =new String[iNumber];
        DecimalFormat df = new DecimalFormat("#.000");
        for (int i = 0; i < iNumber; i++) {
            answer[i]=String.valueOf(Double.parseDouble(df.format(-200 + ((200 + 200) * new Random().nextDouble()))));
        }
        return answer;
    }

}
