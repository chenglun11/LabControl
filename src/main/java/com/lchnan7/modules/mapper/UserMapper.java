package com.lchnan7.modules.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lchnan7.modules.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2023-11-30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

	
}