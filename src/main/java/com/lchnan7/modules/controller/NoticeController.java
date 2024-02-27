package com.lchnan7.modules.controller;

import com.lchnan7.modules.entity.Archives;
import com.lchnan7.modules.entity.Notice;
import com.lchnan7.modules.mapper.NoticeMapper;
import com.lchnan7.modules.service.NoticeService;
import com.lchnan7.modules.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/common/notice")
@Api(tags="公告")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 获取所有公告
     *
     * @param pageNum
     * @param pageSize
     * @param notice
     * @return
     */

    @GetMapping("/getNoticeList")
    @ApiOperation("获取所有计划")
    public Result getNoticeList(Notice notice, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return noticeService.selectNoticeList(notice, pageNum, pageSize);
    }

    @GetMapping("/getArchivesInfo")
    @ApiOperation("根据id获取单个攻略")
    public Result getNoticeInfo(Integer id) {
        return noticeService.selectNoticeInfo(id);
    }

    /**
     * 保存攻略
     *
     * @param notice
     * @return
     */
    @PostMapping("/saveNoticeInfo")
    @ApiOperation("保存公告")
    public Result saveNoticeInfo(@RequestBody Notice notice) {
        return noticeService.saveNoticeInfo(notice);
    }


    /**
     * 更新攻略
     *
     * @param notice
     * @return
     */

    @PutMapping("/updateNoticeInfo")
    @ApiOperation("更新公告")
    public Result updateNoticeInfo(@RequestBody Notice notice) {
        return noticeService.updateNoticeInfo(notice);
    }


    /**
     * 根据id删除攻略
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delNoticeInfo")
    @ApiOperation("根据id删除攻略")
    public Result delNoticeInfo(Integer id) {
        return noticeService.delNoticeInfo(id);
    }

    /**
     * 根据id集合批量删除攻略
     *
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchNoticeInfo")
    @ApiOperation("根据id集合批量删除攻略")
    public Result delBatchNoticeInfo(String idList) {
        return noticeService.delBatchNoticeInfo(idList);

    }
}