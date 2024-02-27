package com.lchnan7.modules.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lchnan7.modules.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    List<Notice> selectListInfo(Notice notice);


}