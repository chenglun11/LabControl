package com.lchnan7.modules.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lchnan7.modules.entity.Comment;
import com.lchnan7.modules.utils.Result;

/**
 * comment
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2023-01-31
 */
public interface CommentService extends IService<Comment> {

    Result selectCommentList(Comment comment, Integer pageNum, Integer pageSize);

    Result saveCommentInfo(Comment comment);

    Result updateCommentInfo(Comment comment);

    Result delCommentInfo(Integer id);

    Result delBatchCommentInfo(String idList);


    Result selectCommentTreeInfo(Comment comment,Integer pageNum,Integer pageSize);

    Result selectCommentInfo2(Comment comment, Integer pageNum, Integer pageSize);
}