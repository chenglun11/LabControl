package com.lchnan7.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预约
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-02-14
 */
@Data
@TableName("`appoint`")
@ApiModel(value="appoint对象", description="预约")
public class Appoint {

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
     * 实验室
     */
	@ApiModelProperty(value = "实验室")
	private Integer labId;
    /**
     * 状态
     */
	@ApiModelProperty(value = "状态")
	private Integer status;
    /**
     * 日期
     */
	@ApiModelProperty(value = "日期")
	private String appointDay;
    /**
     * 时间段
     */
	@ApiModelProperty(value = "时间段")
	private Integer time;
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
	 * 预约人2
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "预约人2")
	private String realName;
	/**
	 * 实验室名
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "实验室名")
	private String labName;
	/**
	 * 位置
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "位置")
	private String location;
	/**
	 * 图片
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "图片")
	private String imageUrl;

}
