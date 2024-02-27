package com.lchnan7.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 点赞
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-01-05
 */
@Data
@TableName("`like`")
@ApiModel(value="like对象", description="点赞")
public class Like {

    /**
     * 主键id
     */
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer id;
    /**
     * 用户
     */
	@ApiModelProperty(value = "用户")
	private Integer userId;
    /**
     * 新闻
     */
	@ApiModelProperty(value = "档案")
	private Integer archivesId;
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
	 * 用户
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "用户")
	private String realName;
	/**
	 * 攻略标题
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "攻略标题")
	private String title;

}
