package com.lchnan7.modules.dinger;

import com.jaemon.dingtalk.dinger.annatations.DingerText;
import com.jaemon.dingtalk.entity.DingTalkResult;

public interface repairDinger {
    @DingerText(value = "您有新的报修未处理,报修实验室为${appointLab}")
    DingTalkResult repairSuccess(String appointLab);

    DingTalkResult repairFailed(String orderNo, int num, boolean flag);
}
