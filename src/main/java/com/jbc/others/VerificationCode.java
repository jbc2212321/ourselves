package com.jbc.others;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.Random;

public class VerificationCode {

    public static String SendSms(String sPhone) {
        Random random =new Random(); //随机数
        String code =String.valueOf(random.nextInt(10))+String.valueOf(random.nextInt(10))+String.valueOf(random.nextInt(10))+String.valueOf(random.nextInt(10));
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G2fVAaXeDNZy2ofWaVh", "Y22E7ReWO7H4Qbc5ptsimLHfYnBGOw");
        IAcsClient client = new DefaultAcsClient(profile);  //阿里云短信接口，复制的sdk
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", sPhone);
        request.putQueryParameter("SignName", "结对编程");
        request.putQueryParameter("TemplateCode", "SMS_204116372");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try
        {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        }
        catch
        (ClientException e)
        {
            e.printStackTrace();
        }
        return code;
    }


}


