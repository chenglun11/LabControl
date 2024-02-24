package com.lchnan7.modules.controller;;
import com.lchnan7.modules.service.AppointService;
import com.lchnan7.modules.entity.Appoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 预约
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-02-14
 */
@RestController
@RequestMapping("/common/appoint")
@Api(tags="预约")
public class AppointController {
    @Autowired
    private AppointService appointService;

    /**
    *  获取所有预约
    * @param pageNum
    * @param pageSize
    * @param appoint
    * @return
    */

    @GetMapping("/getAppointList")
    @ApiOperation("获取所有预约")
    public Result getAppointList(Appoint appoint, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return appointService.selectAppointList(appoint,pageNum,pageSize);
    }


    @GetMapping("/getAppointInfo")
    @ApiOperation("根据id获取单个预约")
    public Result getAppointInfo(Integer id){
        return appointService.selectAppointInfo(id);
    }

    /**
    * 保存预约
    * @param appoint
    * @return
    */
    @PostMapping("/saveAppointInfo")
    @ApiOperation("保存预约")
    public Result saveAppointInfo(@RequestBody Appoint appoint){
        return appointService.saveAppointInfo(appoint);
    }


    /**
     * 更新预约
     * @param appoint
     * @return
     */

    @PutMapping("/updateAppointInfo")
    @ApiOperation("更新预约")
    public Result updateAppointInfo(@RequestBody Appoint appoint){
        return appointService.updateAppointInfo(appoint);
    }

    /**
     * 根据id删除预约
     * @param id
     * @return
     */
    @DeleteMapping("/delAppointInfo")
    @ApiOperation("根据id删除预约")
    public Result delAppointInfo(Integer id){
        return appointService.delAppointInfo(id);
    }

    /**
     * 根据id集合批量删除预约
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchAppointInfo")
    @ApiOperation("根据id集合批量删除预约")
    public Result delBatchAppointInfo(String idList){
        return appointService.delBatchAppointInfo(idList);
    }










}