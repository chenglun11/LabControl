package com.lchnan7.modules.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lchnan7.modules.entity.Plan;
import com.lchnan7.modules.mapper.PlanMapper;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.service.PlanService;
import com.lchnan7.modules.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Arrays;
import com.lchnan7.modules.utils.TimeUtil;
/**
 * 计划
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-02-21
 */
@Service
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan> implements PlanService {

    @Autowired
    private PlanMapper planMapper;



    /**
     *  获取所有计划接口实现类
     * @param pageNum
     * @param pageSize
     * @param plan
     * @return
     */
    @Override
    public Result selectPlanList(Plan plan, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Plan> data = planMapper.selectListInfo(plan);
       return ResultUtil.success(1,"成功",new PageInfo<>(data));
    }


    /**
     * 获取单个计划接口实现类
     * @param id
     * @return
     */
    @Override
    public Result selectPlanInfo(Integer id) {
        Plan plan = planMapper.selectById(id);
        return ResultUtil.success(1,"成功",plan);
    }

    /**
     * 保存计划接口实现类
     * @param plan
     * @return
     */
    @Override
    public Result savePlanInfo(Plan plan) {
        plan.setCreateTime(TimeUtil.getCurrentTime());
        plan.setUpdateTime(TimeUtil.getCurrentTime());
        planMapper.insert(plan);
        return ResultUtil.success(1,"成功",null);
}

    /**
     * 更新计划接口实现类
     * @param plan
     * @return
     */
    @Override
    public Result updatePlanInfo(Plan plan) {
        plan.setUpdateTime(TimeUtil.getCurrentTime());
        planMapper.updateById(plan);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id删除计划删除接口实现类
     * @param id
     * @return
     */
    @Override
    public Result delPlanInfo(Integer id) {
        planMapper.deleteById(id);
        return ResultUtil.success(1,"成功",null);
    }

    /**
     * 根据id集合批量删除计划接口实现类
     * @param idList
     * @return
     */
    @Override
    public Result delBatchPlanInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        planMapper.deleteBatchIds(list);
        return ResultUtil.success(1,"成功",null);
    }



}