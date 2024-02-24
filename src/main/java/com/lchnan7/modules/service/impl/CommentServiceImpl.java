package com.lchnan7.modules.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lchnan7.modules.entity.Comment;
import com.lchnan7.modules.mapper.CommentMapper;
import com.lchnan7.modules.service.CommentService;
import com.lchnan7.modules.utils.IpUtils;
import com.lchnan7.modules.utils.Result;
import com.lchnan7.modules.utils.ResultUtil;
import com.lchnan7.modules.utils.TimeUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * comment
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-01-31
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public Result selectCommentList(Comment comment, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> commentList = commentMapper.selectListInfo(comment);
        return ResultUtil.success(1,"正常",new PageInfo<>(commentList));
    }
    @Autowired
    private HttpServletRequest request;

    @Override
    public Result saveCommentInfo(Comment comment) {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        //获取ip地址
        String ipAddress = IpUtils.getIp2region(IpUtils.getIp(request));
        String os = userAgent.getOperatingSystem().getName();
        if (os.contains("mac") || os.contains("Mac")) {
            comment.setSystemName("mac");
        } else if (os.contains("Windows")) {
            comment.setSystemName("windowns");
        }else {
            comment.setSystemName("android");
        }
        comment.setSystemVersion(os);
        comment.setIpAddress(ipAddress);
        comment.setCreateTime(TimeUtil.getCurrentTime());
        commentMapper.insert(comment);
        return ResultUtil.success(1,"成功",null);
    }

    @Override
    public Result updateCommentInfo(Comment comment) {
        commentMapper.updateById(comment);
        return ResultUtil.success(1,"成功",null);
    }

    @Override
    public Result delCommentInfo(Integer id) {
        commentMapper.deleteById(id);
        return ResultUtil.success(1,"成功",null);
    }

    @Override
    public Result delBatchCommentInfo(String idList) {
        List<String> list = Arrays.asList(idList.split(","));
        commentMapper.deleteBatchIds(list);
        return ResultUtil.success(1,"成功",null);
    }
    public static List<Comment> childrenList = new ArrayList<>();

    @Override
    public Result selectCommentTreeInfo(Comment comment,Integer pageNum,Integer pageSize) {
        List<Comment> comments = commentMapper.selectListInfo(null);
        PageHelper.startPage(pageNum,pageSize);
        comment.setPid(0);
        List<Comment> list = commentMapper.selectListInfo(comment);
//        List<Comment> commentList = new ArrayList<>();
        for (Comment comment1:list){
//            if (comment1.getPid() == 0){
            //一级评论,查询她下面的所有信息
            List<Comment> children = getChildren(comments, comment1);
            comment1.setReply(children);
            childrenList = new ArrayList<>();
//                commentList.add(comment1);
//            }
        }
        return ResultUtil.success(1,"成功",new PageInfo<>(list));
    }
    @Override
    public Result selectCommentInfo2(Comment comment, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> commentList = commentMapper.selectListInfo(comment);
        return ResultUtil.success(1,"成功",new PageInfo<>(commentList));
    }


    public List<Comment> getChildren(List<Comment> commentList, Comment comment){
        for (Comment comment1:commentList){
            if (comment1.getPid().equals(comment.getId())){
                childrenList.add(comment1);
                getChildren(commentList,comment1);
            }
        }
        return childrenList;
    }


}