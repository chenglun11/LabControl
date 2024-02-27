package com.lchnan7.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan7.modules.entity.*;
import com.lchnan7.modules.mapper.*;
import com.lchnan7.modules.service.ArchivesService;
import com.lchnan7.modules.service.NoticeService;
import com.lchnan7.modules.utils.IpUtils;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import com.lchnan7.modules.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 攻略
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-01-05
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public Result selectNoticeList(Notice notice, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Notice> data = noticeMapper.selectListInfo(notice);
        return ResultUtil.success(1,"成功",new PageInfo<>(data));
    }

    @Override
    public Result selectNoticeInfo(Integer id) {
        Notice notice = noticeMapper.selectById(id);
        return ResultUtil.success(1,"成功", notice);
    }

    @Override
    @Transactional
    public Result saveNoticeInfo(Notice notice) {
//        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
//        wrapper.eq("not_person",notice.getLoginUserId()).eq("id",notice.getId());
        notice.setCreateTime(TimeUtil.getCurrentTime());
        notice.setUpdateTime(TimeUtil.getCurrentTime());
        noticeMapper.insert(notice);

        return ResultUtil.success(1,"成功",null);
    }

    @Override
    @Transactional
    public Result updateNoticeInfo(Notice notice) {
        notice.setUpdateTime(TimeUtil.getCurrentTime());
        noticeMapper.updateById(notice);
        return ResultUtil.success(1,"成功",null);
    }

    @Override
    @Transactional
    public Result delNoticeInfo(Integer id) {
        noticeMapper.deleteById(id);
        return ResultUtil.success(1,"成功",null);
    }

    @Override
    @Transactional
    public Result delBatchNoticeInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        noticeMapper.deleteBatchIds(list);
        return ResultUtil.success(1,"成功",null);
    }
}