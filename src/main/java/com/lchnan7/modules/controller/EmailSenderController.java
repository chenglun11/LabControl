package com.lchnan7.modules.controller;

import com.lchnan7.modules.entity.User;
import com.lchnan7.modules.service.EmailSyncService;
import com.lchnan7.modules.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/common/emailsender")
public class EmailSenderController {

    @Autowired
    private EmailSyncService emailSyncService;
    @GetMapping("/sendbyid")
    @ApiOperation("email测试类")
    public Result senderbyid(String email, String text){

        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("name", "test_name");
        templateModel.put("labName", "test_lab_name");
        templateModel.put("approvalTime", "test_appoint_time");

        return emailSyncService.sendtest(email, text,templateModel,"approvalNotification");
    }
}
