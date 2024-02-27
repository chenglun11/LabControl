package com.lchnan7.modules.controller;

import com.lchnan7.modules.entity.Notice;
import com.lchnan7.modules.mapper.NoticeMapper;
import com.lchnan7.modules.service.NoticeService;
import com.lchnan7.modules.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common/notice")
@Api(tags="公告")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     *  获取所有公告
     * @param pageNum
     * @param pageSize
     * @param notice
     * @return
     */

    @GetMapping("/getNoticeList")
    @ApiOperation("获取所有计划")
    public Result getPlanList(Notice notice, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                              @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return noticeService.selectNoticeList(notice,pageNum,pageSize);
    }
}
