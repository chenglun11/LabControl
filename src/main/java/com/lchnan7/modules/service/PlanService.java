package com.lchnan7.modules.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.entity.Plan;
import com.lchnan7.modules.utils.Result;

/**
 * 计划
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-02-21
 */
public interface PlanService extends IService<Plan>{

    /**
     *  获取所有计划接口
     * @param pageNum
     * @param pageSize
     * @param plan
     * @return
     */
    Result selectPlanList(Plan plan, Integer pageNum, Integer pageSize);


    /**
     *  获取单个计划接口
     * @param id
     * @return
     */
    Result selectPlanInfo(Integer id);

    /**
     * 保存计划接口
     * @param plan
     * @return
     */
    Result savePlanInfo(Plan plan);

    /**
     * 更新计划接口
     * @param plan
     * @return
     */
    Result updatePlanInfo(Plan plan);

    /**
     * 根据id删除计划接口
     * @param id
     * @return
     */
    Result delPlanInfo(Integer id);

    /**
     * 根据id集合批量删除计划接口
     * @param idList
     * @return
     */
    Result delBatchPlanInfo(String idList);




}