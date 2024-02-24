package com.lchnan7.modules.service;

import com.lchnan7.modules.utils.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSyncService {

    @Async
    public void sendSMS(String email,String text){
        log.info("调用发送邮件方法...");
        try {
            MailUtil.sendMail(email,"申请通知",text);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
