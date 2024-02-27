package com.lchnan7.modules.service;

import com.jaemon.dingtalk.entity.DingTalkResult;
import com.lchnan7.modules.dinger.OrderDinger;
import com.lchnan7.modules.dinger.repairDinger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class DingSyncService {

    @Autowired
    private OrderDinger orderDinger;
    public void SendDing(String labname){
        log.info("钉钉事件...");
        try {
            DingTalkResult result = orderDinger.orderSuccess(labname);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Autowired
    private repairDinger repairDinger;
    public void SendDingFix(String labname){
        log.info("钉钉事件...");
        try {
            DingTalkResult result = repairDinger.repairSuccess(labname);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
