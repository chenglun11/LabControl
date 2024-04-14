package com.lchnan7.modules.dinger;

import com.jaemon.dingtalk.dinger.annatations.DingerMarkdown;
import com.jaemon.dingtalk.dinger.annatations.DingerText;
import com.jaemon.dingtalk.dinger.annatations.Parameter;
import com.jaemon.dingtalk.entity.DingTalkResult;

import java.math.BigDecimal;

public interface OrderDinger {

    @DingerMarkdown(
            value = "### 您有新的未处理审核<br>"+"实验室为${appointLab}, 请[点此链接](http://lab.ca7.asia)登录系统进行处理",
            title = "预约申请")
    DingTalkResult orderSuccess(String appointLab);

    DingTalkResult orderFailed(String orderNo, int num, boolean flag);
}
