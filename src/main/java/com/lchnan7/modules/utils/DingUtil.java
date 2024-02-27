package com.lchnan7.modules.utils;

import com.jaemon.dingtalk.DingTalkRobot;
import com.jaemon.dingtalk.DingTalkSender;
import com.jaemon.dingtalk.entity.enums.MsgTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DingUtil {

    @Autowired
    private DingTalkSender dingTalkSender;

    public void SendDing(String text){
        String Keywords = "SEC1ed4a78e771733e1add79887256d30ebedad338bf1b83ad6ca1aefed0fe58299";
        String subTitle = "您有新的预约工单待处理！";
        String content = text;

        dingTalkSender.sendAll(MsgTypeEnum.TEXT, Keywords, subTitle, content);
    }
}
