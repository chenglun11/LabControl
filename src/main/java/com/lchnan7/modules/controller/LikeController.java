package com.lchnan7.modules.controller;;
import com.lchnan7.modules.entity.Like;
import com.lchnan7.modules.service.LikeService;
import com.lchnan7.modules.utils.Result;
import io.swagger.annotations.Api;

import com.lchnan7.modules.utils.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 点赞
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
@RestController
@RequestMapping("/common/like")
@Api(tags="点赞")
public class LikeController {
    @Autowired
    private LikeService likeService;

    /**
    *  获取所有点赞
    * @param pageNum
    * @param pageSize
    * @param like
    * @return
    */

    @GetMapping("/getLikeList")
    @ApiOperation("获取所有点赞")
    public Result getLikeList(Like like, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                              @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return likeService.selectLikeList(like,pageNum,pageSize);
    }


    @GetMapping("/getLikeInfo")
    @ApiOperation("根据id获取单个点赞")
    public Result getLikeInfo(Integer id){
        return likeService.selectLikeInfo(id);
    }

    /**
    * 保存点赞
    * @param like
    * @return
    */
    @PostMapping("/saveLikeInfo")
    @ApiOperation("保存点赞")
    public Result saveLikeInfo(@RequestBody Like like){
        return likeService.saveLikeInfo(like);
    }


    /**
     * 更新点赞
     * @param like
     * @return
     */

    @PutMapping("/updateLikeInfo")
    @ApiOperation("更新点赞")
    public Result updateLikeInfo(@RequestBody Like like){
        return likeService.updateLikeInfo(like);
    }

    /**
     * 根据id删除点赞
     * @param id
     * @return
     */
    @DeleteMapping("/delLikeInfo")
    @ApiOperation("根据id删除点赞")
    public Result delLikeInfo(Integer id){
        return likeService.delLikeInfo(id);
    }

    /**
     * 根据id集合批量删除点赞
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchLikeInfo")
    @ApiOperation("根据id集合批量删除点赞")
    public Result delBatchLikeInfo(String idList){
        return likeService.delBatchLikeInfo(idList);
    }










}