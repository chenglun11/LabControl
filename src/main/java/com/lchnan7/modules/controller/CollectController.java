package com.lchnan7.modules.controller;;
import com.lchnan7.modules.entity.Collect;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.service.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.lchnan7.modules.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 收藏
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
@RestController
@RequestMapping("/common/collect")
@Api(tags="收藏")
public class CollectController {
    @Autowired
    private CollectService collectService;

    /**
    *  获取所有收藏
    * @param pageNum
    * @param pageSize
    * @param collect
    * @return
    */

    @GetMapping("/getCollectList")
    @ApiOperation("获取所有收藏")
    public Result getCollectList(Collect collect, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return collectService.selectCollectList(collect,pageNum,pageSize);
    }


    @GetMapping("/getCollectInfo")
    @ApiOperation("根据id获取单个收藏")
    public Result getCollectInfo(Integer id){
        return collectService.selectCollectInfo(id);
    }

    /**
    * 保存收藏
    * @param collect
    * @return
    */
    @PostMapping("/saveCollectInfo")
    @ApiOperation("保存收藏")
    public Result saveCollectInfo(@RequestBody Collect collect){
        return collectService.saveCollectInfo(collect);
    }


    /**
     * 更新收藏
     * @param collect
     * @return
     */

    @PutMapping("/updateCollectInfo")
    @ApiOperation("更新收藏")
    public Result updateCollectInfo(@RequestBody Collect collect){
        return collectService.updateCollectInfo(collect);
    }

    /**
     * 根据id删除收藏
     * @param id
     * @return
     */
    @DeleteMapping("/delCollectInfo")
    @ApiOperation("根据id删除收藏")
    public Result delCollectInfo(Integer id){
        return collectService.delCollectInfo(id);
    }

    /**
     * 根据id集合批量删除收藏
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchCollectInfo")
    @ApiOperation("根据id集合批量删除收藏")
    public Result delBatchCollectInfo(String idList){
        return collectService.delBatchCollectInfo(idList);
    }










}