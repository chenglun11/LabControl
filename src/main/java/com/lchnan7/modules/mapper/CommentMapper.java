package com.lchnan7.modules.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lchnan7.modules.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * comment
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2023-01-31
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> selectListInfo(Comment comment);
	
}