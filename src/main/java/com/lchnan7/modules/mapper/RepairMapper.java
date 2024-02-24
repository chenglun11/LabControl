package com.lchnan7.modules.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lchnan7.modules.entity.Repair;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 报修
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-02-14
 */
@Mapper
public interface RepairMapper extends BaseMapper<Repair> {

    List<Repair> selectListInfo(Repair repair);

	
}