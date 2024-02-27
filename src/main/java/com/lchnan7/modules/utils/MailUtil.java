package com.lchnan7.modules.utils;


import com.lchnan7.modules.config.EmailConfig;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.Random;


public class MailUtil {

    public static void sendMail(String to,String subject,String text) throws MessagingException,UnsupportedEncodingException {
        String host = EmailConfig.getSpringMailHost();
        String userName = EmailConfig.getSpringMailUserName();
        String password = EmailConfig.getSpringMailPassword();
        String from = EmailConfig.getSpringMailUserName();
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        senderImpl.setHost(host);
        senderImpl.setUsername(userName);
        senderImpl.setPassword(password);
        //建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true,"utf-8");
        messageHelper.setTo(to);
        messageHelper.setFrom(from);
        messageHelper.setSubject(subject);
        messageHelper.setText(text);
        //将这个参数设为true，让服务器进行认证,认证用户名和 密码是否正确
        Properties prop= new Properties();
        prop.put("mail.smtp.auth","true");
        //设置超时时间
        prop.put("mail.smtp.timeout", "25000");
        senderImpl.setJavaMailProperties(prop);
        //发送邮件
        senderImpl.send(mailMessage);
    }

    public static String getCode(){
        Random yzm = new Random();                          //定义一个随机生成数技术，用来生成随机数

        String yzm2 = "";                                   //定义一个空的Atring变量用来接收生成的验证码

        for (int i = 0; i < 5; i++) {                       //循环5次每次生成一位，5位验证码

            int a = yzm.nextInt(3);                             //验证码包括数字、大小写字母组成
            switch(a){                                          //a:    0       1       2
                case 0:                                         //      数字   小写字母   大写字母
                    char s=(char)(yzm.nextInt(26)+65);
                    yzm2 = yzm2 + s;
                    break;
                case 1:
                    char s1=(char)(yzm.nextInt(26)+97);
                    yzm2 = yzm2 + s1;
                    break;
                case 2:
                    int s2=yzm.nextInt(10);
                    yzm2 = yzm2 + s2;
                    break;
            }
        }
        System.out.println("用随机生成数方法，生成的验证码:"+yzm2);
        return yzm2;
    };

    public static void myStaticMethod() { ;
        System.out.println("配置值为：" + EmailConfig.getSpringMailHost());
        System.out.println("配置值为：" + EmailConfig.getSpringMailUserName());
        System.out.println("配置值为：" + EmailConfig.getSpringMailPassword());
    }


}
