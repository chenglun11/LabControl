package com.lchnan7.modules.controller;

;
import com.lchnan7.modules.service.LabService;
import com.lchnan7.modules.entity.Lab;
import com.lchnan7.modules.utils.TimeUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import com.lchnan7.modules.utils.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 实验室
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-14
 */
@RestController
@RequestMapping("/common/lab")
@Api(tags = "实验室")
public class LabController {
    @Autowired
    private LabService labService;

    /**
     * 获取所有实验室
     *
     * @param pageNum
     * @param pageSize
     * @param lab
     * @return
     */

    @GetMapping("/getLabList")
    @ApiOperation("获取所有实验室")
    public Result getLabList(Lab lab, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return labService.selectLabList(lab, pageNum, pageSize);
    }


    @GetMapping("/getLabInfo")
    @ApiOperation("根据id获取单个实验室")
    public Result getLabInfo(Integer id) {
        return labService.selectLabInfo(id);
    }

    /**
     * 保存实验室
     *
     * @param lab
     * @return
     */
    @PostMapping("/saveLabInfo")
    @ApiOperation("保存实验室")
    public Result saveLabInfo(@RequestBody Lab lab) {
        return labService.saveLabInfo(lab);
    }


    /**
     * 更新实验室
     *
     * @param lab
     * @return
     */

    @PutMapping("/updateLabInfo")
    @ApiOperation("更新实验室")
    public Result updateLabInfo(@RequestBody Lab lab) {
        return labService.updateLabInfo(lab);
    }

    /**
     * 根据id删除实验室
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delLabInfo")
    @ApiOperation("根据id删除实验室")
    public Result delLabInfo(Integer id) {
        return labService.delLabInfo(id);
    }

    /**
     * 根据id集合批量删除实验室
     *
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchLabInfo")
    @ApiOperation("根据id集合批量删除实验室")
    public Result delBatchLabInfo(String idList) {
        return labService.delBatchLabInfo(idList);
    }

}