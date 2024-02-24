package com.lchnan7.modules.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lchnan7.modules.entity.Plan;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 计划
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-02-21
 */
@Mapper
public interface PlanMapper extends BaseMapper<Plan> {

    List<Plan> selectListInfo(Plan plan);

	
}