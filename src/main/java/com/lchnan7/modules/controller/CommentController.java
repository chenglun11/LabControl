package com.lchnan7.modules.controller;

import com.lchnan7.modules.entity.Comment;
import com.lchnan7.modules.service.CommentService;
import com.lchnan7.modules.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

;


/**
 * comment
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2023-01-31
 */
@RestController
@RequestMapping("/common/comment")
@Api(tags="comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
    *  获取所有评论信息
    * @param pageNum
    * @param pageSize
    * @param comment
    * @return
    */

    @GetMapping("/getCommentList")
    @ApiOperation("获取所有评论信息")
    public Result getCommentList(Comment comment, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                 @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize, HttpServletRequest request){
        return commentService.selectCommentList(comment,pageNum,pageSize);
    }

    @GetMapping("/getCommentInfo2")
    @ApiOperation("获取所有评论信息")
    public Result getCommentInfo2(Comment comment, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                  @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize, HttpServletRequest request){
        return commentService.selectCommentInfo2(comment,pageNum,pageSize);
    }

    @GetMapping("/getCommentTreeInfo")
    @ApiOperation("获取所有树形评论信息")
    public Result getCommentTreeInfo(Comment comment, @RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                                     @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize){
        return commentService.selectCommentTreeInfo(comment,pageNum,pageSize);
    }


    /**
    * 保存评论信息
    * @param comment
    * @return
    */
    @PostMapping("/saveCommentInfo")
    @ApiOperation("保存评论信息")
    public Result saveCommentInfo(@RequestBody Comment comment){
        return commentService.saveCommentInfo(comment);
    }


    /**
     * 更新评论信息
     * @param comment
     * @return
     */

    @PutMapping("/updateCommentInfo")
    @ApiOperation("更新评论信息")
    public Result updateCommentInfo(@RequestBody Comment comment){
        return commentService.updateCommentInfo(comment);
    }

    /**
     * 根据id删除评论信息
     * @param id
     * @return
     */
    @DeleteMapping("/delCommentInfo")
    @ApiOperation("根据id删除评论信息")
    public Result delCommentInfo(Integer id){
        return commentService.delCommentInfo(id);
    }

    /**
     * 根据id集合批量删除评论信息
     * @param idList
     * @return
     */
    @DeleteMapping("/delBatchCommentInfo")
    @ApiOperation("根据id集合批量删除评论信息")
    public Result delBatchCommentInfo(String idList){
        return commentService.delBatchCommentInfo(idList);
    }

}