package com.lchnan7.modules.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lchnan7.modules.entity.Appoint;
import com.lchnan7.modules.entity.Lab;
import com.lchnan7.modules.entity.Plan;
import com.lchnan7.modules.entity.User;
import com.lchnan7.modules.mapper.AppointMapper;
import com.lchnan7.modules.mapper.LabMapper;
import com.lchnan7.modules.mapper.PlanMapper;
import com.lchnan7.modules.mapper.UserMapper;
import com.lchnan7.modules.service.AppointService;
import com.lchnan7.modules.service.DingSyncService;
import com.lchnan7.modules.service.EmailSyncService;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

import com.lchnan7.modules.utils.TimeUtil;
/**
 * 预约
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-14
 */
@Service
public class AppointServiceImpl extends ServiceImpl<AppointMapper, Appoint> implements AppointService {

    @Autowired
    private AppointMapper appointMapper;



    /**
     *  获取所有预约接口实现类
     * @param pageNum
     * @param pageSize
     * @param appoint
     * @return
     */
    @Override
    public Result selectAppointList(Appoint appoint, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Appoint> data = appointMapper.selectListInfo(appoint);
        return ResultUtil.success(1,"成功",new PageInfo<>(data));
    }


    /**
     * 获取单个预约接口实现类
     * @param id
     * @return
     */
    @Override
    public Result selectAppointInfo(Integer id) {
        Appoint appoint = appointMapper.selectById(id);
        return ResultUtil.success(1,"成功",appoint);
    }


    @Autowired
    private PlanMapper planMapper;

    /**
     * 保存预约接口实现类
     * @param appoint
     * @return
     */

    @Autowired
    private LabMapper labMapper;

    @Override
    public Result saveAppointInfo(Appoint appoint) {

        QueryWrapper<Plan> wrapper2 = new QueryWrapper<>();
        wrapper2.eq("appoint_day",appoint.getAppointDay()).eq("time",appoint.getTime()).eq("lab_id",appoint.getLabId());

        Plan plan = planMapper.selectOne(wrapper2);
        if (plan !=null){
            return ResultUtil.error(-1,"该验室当前时间段不可预约");
        }

        QueryWrapper<Appoint> wrapper = new QueryWrapper<>();
        wrapper.eq("appoint_day",appoint.getAppointDay()).eq("time",appoint.getTime()).eq("lab_id",appoint.getLabId());
        Appoint appoint1 = appointMapper.selectOne(wrapper);
        if (appoint1 !=null){
            return ResultUtil.error(-1,"该实验室这个时间段已经是被人预约了");
        }
        appoint.setStatus(1);
        appoint.setCreateTime(TimeUtil.getCurrentTime());
        appoint.setUpdateTime(TimeUtil.getCurrentTime());
        appointMapper.insert(appoint);
        //钉钉
//        User user = userMapper.selectById(appoint1.getUserId());
//        String username = user.getRealName();
        //String text = "您有新的预约事项，来自"+appoint1.getLabName()+".";

        Lab lab = labMapper.selectById(appoint.getLabId());

        dingSyncService.SendDing(lab.getLabName());
        return ResultUtil.success(1,"成功",null);
    }

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmailSyncService emailSyncService;
    @Autowired
    private DingSyncService dingSyncService;
    /**
     * 更新预约接口实现类
     * @param appoint
     * @return
     */
    @Override
    public Result updateAppointInfo(Appoint appoint) {
        Appoint appoint1 = appointMapper.selectById(appoint.getId());
        Lab lab1 = labMapper.selectById(appoint.getLabId());
        if (lab1.getStatus() == 3){
            return ResultUtil.error(-1,"该实验室维护中");
        }

        if (appoint1.getStatus() == 2){
            return ResultUtil.error(-1,"该申请已经审核通过");
        }
        appoint.setUpdateTime(TimeUtil.getCurrentTime());
        appointMapper.updateById(appoint);
        if (appoint.getStatus() == 2){
            User user = userMapper.selectById(appoint1.getUserId());
            Lab lab = labMapper.selectById(appoint.getLabId());

            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("name", user.getRealName());
            templateModel.put("labName", lab.getLabName());
            templateModel.put("approvalTime", appoint.getUpdateTime());
            //代表审核通过
            emailSyncService.sendSMS(user.getEmail(),"实验室申请审核结果",templateModel,"approvalNotification");
        }
        if (appoint.getStatus() == 3) {
            System.out.println("3");
            User usererr = userMapper.selectById(appoint1.getUserId());
            Lab laberr = labMapper.selectById(appoint.getLabId());

            Map<String, Object> templateModel = new HashMap<>();
            templateModel.put("name", usererr.getRealName());
            templateModel.put("labName", laberr.getLabName());
            templateModel.put("approvalTime", appoint.getUpdateTime());
            //代表审核通过
            emailSyncService.sendSMS(usererr.getEmail(),"实验室申请审核结果",templateModel,"errorNotification");
        }
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id删除预约删除接口实现类
     * @param id
     * @return
     */
    @Override
    public Result delAppointInfo(Integer id) {
        appointMapper.deleteById(id);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id集合批量删除预约接口实现类
     * @param idList
     * @return
     */
    @Override
    public Result delBatchAppointInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        appointMapper.deleteBatchIds(list);
        return ResultUtil.success(1,"成功",null);
    }



}