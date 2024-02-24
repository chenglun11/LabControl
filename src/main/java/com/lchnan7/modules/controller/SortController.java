package com.lchnan7.modules.controller;;
import com.lchnan7.modules.service.SortService;
import com.lchnan7.modules.entity.Sort;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;

import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 分类
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
@RestController
@RequestMapping("/common/sort")
@Api(tags="分类")
public class SortController {
    @Autowired
    private SortService sortService;

    /**
    *  获取所有分类
    * @param pageNum
    * @param pageSize
    * @param sort
    * @return
    */

    @GetMapping("/getSortList")
    @ApiOperation("获取所有分类")
    public Result getSortList(Sort sort, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                      @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return sortService.selectSortList(sort,pageNum,pageSize);
    }


    @GetMapping("/getSortInfo")
    @ApiOperation("根据id获取单个分类")
    public Result getSortInfo(Integer id){
        return sortService.selectSortInfo(id);
    }

    /**
    * 保存分类
    * @param sort
    * @return
    */
    @PostMapping("/saveSortInfo")
    @ApiOperation("保存分类")
    public Result saveSortInfo(@RequestBody Sort sort){
        return sortService.saveSortInfo(sort);
    }


    /**
     * 更新分类
     * @param sort
     * @return
     */

    @PutMapping("/updateSortInfo")
    @ApiOperation("更新分类")
    public Result updateSortInfo(@RequestBody Sort sort){
        return sortService.updateSortInfo(sort);
    }

    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    @DeleteMapping("/delSortInfo")
    @ApiOperation("根据id删除分类")
    public Result delSortInfo(Integer id){
        return sortService.delSortInfo(id);
    }

    /**
     * 根据id集合批量删除分类
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchSortInfo")
    @ApiOperation("根据id集合批量删除分类")
    public Result delBatchSortInfo(String idList){
        return sortService.delBatchSortInfo(idList);
    }










}