package com.lchnan7.modules.controller;;
import com.lchnan7.modules.service.PlanService;
import com.lchnan7.modules.entity.Plan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.*;
import org.springframework.web.bind.annotation.*;

/**
 * 计划
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-21
 */
@RestController
@RequestMapping("/common/plan")
@Api(tags="计划")
public class PlanController {
    @Autowired
    private PlanService planService;

    /**
    *  获取所有计划
    * @param pageNum
    * @param pageSize
    * @param plan
    * @return
    */

    @GetMapping("/getPlanList")
    @ApiOperation("获取所有计划")
    public Result getPlanList(Plan plan, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return planService.selectPlanList(plan,pageNum,pageSize);
    }


    @GetMapping("/getPlanInfo")
    @ApiOperation("根据id获取单个计划")
    public Result getPlanInfo(Integer id){
        return planService.selectPlanInfo(id);
    }

    /**
    * 保存计划
    * @param plan
    * @return
    */
    @PostMapping("/savePlanInfo")
    @ApiOperation("保存计划")
    public Result savePlanInfo(@RequestBody Plan plan){
        return planService.savePlanInfo(plan);
    }


    /**
     * 更新计划
     * @param plan
     * @return
     */

    @PutMapping("/updatePlanInfo")
    @ApiOperation("更新计划")
    public Result updatePlanInfo(@RequestBody Plan plan){
        return planService.updatePlanInfo(plan);
    }

    /**
     * 根据id删除计划
     * @param id
     * @return
     */
    @DeleteMapping("/delPlanInfo")
    @ApiOperation("根据id删除计划")
    public Result delPlanInfo(Integer id){
        return planService.delPlanInfo(id);
    }

    /**
     * 根据id集合批量删除计划
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchPlanInfo")
    @ApiOperation("根据id集合批量删除计划")
    public Result delBatchPlanInfo(String idList){
        return planService.delBatchPlanInfo(idList);
    }










}