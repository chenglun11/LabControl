package com.lchnan7.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 收藏
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
@Data
@TableName("`collect`")
@ApiModel(value="collect对象", description="收藏")
public class Collect {

    /**
     * 主键id
     */
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer id;
    /**
     * 收藏人
     */
	@ApiModelProperty(value = "收藏人")
	private Integer userId;
    /**
     * 攻略
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
	 * 收藏人
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "收藏人")
	private String realName;
	/**
	 * 攻略
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "攻略")
	private String title;
	/**
	 * 图片
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "图片")
	private String imageUrl;

}
