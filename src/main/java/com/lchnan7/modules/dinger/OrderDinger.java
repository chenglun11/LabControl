package com.lchnan7.modules.dinger;

import com.jaemon.dingtalk.dinger.annatations.DingerText;
import com.jaemon.dingtalk.dinger.annatations.Parameter;
import com.jaemon.dingtalk.entity.DingTalkResult;

import java.math.BigDecimal;

public interface OrderDinger {
    @DingerText(value = "您有新的未处理审核,实验室为${appointLab}")
    DingTalkResult orderSuccess(String appointLab);

    DingTalkResult orderFailed(String orderNo, int num, boolean flag);
}
