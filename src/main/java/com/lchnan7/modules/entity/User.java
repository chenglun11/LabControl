package com.lchnan7.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2023-11-30
 */
@Data
@TableName("`user`")
@ApiModel(value="user对象", description="用户")
public class User {

    /**
     * 主键id
     */
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer id;
    /**
     * 用户名
     */
	@ApiModelProperty(value = "用户名")
	private String userName;
    /**
     * 密码
     */
	@ApiModelProperty(value = "密码")
	private String password;
    /**
     * 姓名
     */
	@ApiModelProperty(value = "姓名")
	private String realName;
    /**
     * 性别
     */
	@ApiModelProperty(value = "性别")
	private Integer sex;
    /**
     * 联系方式
     */
	@ApiModelProperty(value = "联系方式")
	private String phone;
    /**
     * 用户类型
     */
	@ApiModelProperty(value = "用户类型")
	private Integer userType;
    /**
     * 图片
     */
	@ApiModelProperty(value = "图片")
	private String imageUrl;
    /**
     * 邮箱
     */
	@ApiModelProperty(value = "邮箱")
	private String email;
    /**
     * 创建时间
     */
	@ApiModelProperty(value = "创建时间")
	private String createTime;
    /**
     * 更新时间
     */
	@ApiModelProperty(value = "更新时间")
	private String updateTime;

	/**
	 * 验证码code值
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "验证码code值")
	private String code;
}
