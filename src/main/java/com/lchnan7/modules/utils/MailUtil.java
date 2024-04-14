package com.lchnan7.modules.utils;


import com.lchnan7.modules.config.EmailConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@Slf4j
@Component
public class MailUtil {
    @Autowired
    private TemplateEngine templateEngine;

    public void sendMail(String to, String subject, Map<String, Object> templateModel, String templateName) throws MessagingException {
        TemplateEngine engine = new TemplateEngine();
        Context context = new Context();
        context.setVariables(templateModel);

//        log.info("Processing template with name: {}", templateName);
//        if (templateEngine == null) {
//            log.error("Template engine is null!");
//        }
//        if (context == null) {
//            log.error("Context is null!");
//        }

        // 使用模板引擎生成HTML内容
        String htmlContent = templateEngine.process(templateName, context);

        int port = EmailConfig.getSpringMailPort();
        String host = EmailConfig.getSpringMailHost();
        String userName = EmailConfig.getSpringMailUserName();
        String password = EmailConfig.getSpringMailPassword();
        String from = EmailConfig.getSpringMailUserName();
        //log.info(String.valueOf(port));
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        senderImpl.setPort(port);
        senderImpl.setHost(host);
        senderImpl.setUsername(userName);
        senderImpl.setPassword(password);

        //建立邮件消息,发送简单邮件和html邮件的区别
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true,"utf-8");
        messageHelper.setTo(to);
        messageHelper.setFrom(from);
        messageHelper.setSubject(subject);
        messageHelper.setText(htmlContent,true);

        //将这个参数设为true，让服务器进行认证,认证用户名和 密码是否正确
        Properties prop= new Properties();
        prop.put("mail.smtp.auth","true");
        //设置SSL
        prop.put("mail.smtp.ssl","true");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //设置超时时间
        prop.put("mail.smtp.timeout", "5000");
        senderImpl.setJavaMailProperties(prop);

        //发送邮件
        senderImpl.send(mailMessage);
    }




}
