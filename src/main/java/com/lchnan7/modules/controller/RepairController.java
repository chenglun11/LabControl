package com.lchnan7.modules.controller;;
import com.lchnan7.modules.service.RepairService;
import com.lchnan7.modules.entity.Repair;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.BindingType;

/**
 * 报修
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-14
 */
@RestController
@RequestMapping("/common/repair")
@Api(tags="报修")
public class RepairController {
    @Autowired
    private RepairService repairService;

    /**
    *  获取所有报修
    * @param pageNum
    * @param pageSize
    * @param repair
    * @return
    */

    @GetMapping("/getRepairList")
    @ApiOperation("获取所有报修")
    public Result getRepairList(Repair repair, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return repairService.selectRepairList(repair,pageNum,pageSize);
    }


    @GetMapping("/getRepairInfo")
    @ApiOperation("根据id获取单个报修")
    public Result getRepairInfo(Integer id){
        return repairService.selectRepairInfo(id);
    }

    /**
    * 保存报修
    * @param repair
    * @return
    */
    @PostMapping("/saveRepairInfo")
    @ApiOperation("保存报修")
    public Result saveRepairInfo(@RequestBody Repair repair){
        return repairService.saveRepairInfo(repair);
    }


    /**
     * 更新报修
     * @param repair
     * @return
     */

    @PutMapping("/updateRepairInfo")
    @ApiOperation("更新报修")
    public Result updateRepairInfo(@RequestBody Repair repair){
        return repairService.updateRepairInfo(repair);
    }

    /**
     * 根据id删除报修
     * @param id
     * @return
     */
    @DeleteMapping("/delRepairInfo")
    @ApiOperation("根据id删除报修")
    public Result delRepairInfo(Integer id){
        return repairService.delRepairInfo(id);
    }

    /**
     * 根据id集合批量删除报修
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchRepairInfo")
    @ApiOperation("根据id集合批量删除报修")
    public Result delBatchRepairInfo(String idList){
        return repairService.delBatchRepairInfo(idList);
    }

}