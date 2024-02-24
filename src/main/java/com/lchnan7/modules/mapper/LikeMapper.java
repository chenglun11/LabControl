package com.lchnan7.modules.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lchnan7.modules.entity.Like;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 点赞
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
@Mapper
public interface LikeMapper extends BaseMapper<Like> {

    List<Like> selectListInfo(Like like);

	
}