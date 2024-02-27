package com.lchnan7.modules.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lchnan7.modules.entity.Archives;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 攻略
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-01-05
 */
@Mapper
public interface ArchivesMapper extends BaseMapper<Archives> {

    List<Archives> selectListInfo(Archives archives);

	
}