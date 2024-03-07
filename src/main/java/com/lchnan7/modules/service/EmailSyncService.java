package com.lchnan7.modules.service;

import com.lchnan7.modules.utils.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.Map;

@Service
@Slf4j
public class EmailSyncService {


    @Autowired
    private MailUtil mailUtil;

    @Async
    public void sendSMS(String email,String text, Map<String, Object>templateModel,String tempName){


        log.info("调用发送邮件方法...");
        try {
            //log.info("email:"+email+"temp:"+templateModel);
            mailUtil.sendMail(email,text,templateModel,tempName);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
