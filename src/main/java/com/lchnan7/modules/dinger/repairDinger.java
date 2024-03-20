package com.lchnan7.modules.dinger;

import com.jaemon.dingtalk.dinger.annatations.DingerMarkdown;
import com.jaemon.dingtalk.dinger.annatations.DingerText;
import com.jaemon.dingtalk.entity.DingTalkResult;

public interface repairDinger {
    @DingerMarkdown(value = "您有新的报修未处理,报修实验室为${appointLab}",
            title = "报修申请")
    DingTalkResult repairSuccess(String appointLab);

    DingTalkResult repairFailed(String orderNo, int num, boolean flag);
}
