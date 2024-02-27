package com.lchnan7.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实验室
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2024-02-14
 */
@Data
@TableName("`lab`")
@ApiModel(value="lab对象", description="实验室")
public class Lab {

    /**
     * 主键id
     */
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer id;
    /**
     * 实验室名
     */
	@ApiModelProperty(value = "实验室名")
	private String labName;
    /**
     * 分类
     */
	@ApiModelProperty(value = "分类")
	private Integer sortId;
    /**
     * 位置
     */
	@ApiModelProperty(value = "位置")
	private String location;
    /**
     * 简介
     */
	@TableField(value = "`desc`")
	@ApiModelProperty(value = "简介")
	private String desc;
    /**
     * 内容
     */
	@ApiModelProperty(value = "内容")
	private String content;
    /**
     * 状态
     */
	@ApiModelProperty(value = "状态")
	private Integer status;
    /**
     * 图片
     */
	@ApiModelProperty(value = "图片")
	private String imageUrl;
    /**
     * 是否推荐
     */
	@ApiModelProperty(value = "是否推荐")
	private Integer isBanner;
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
	 * 分类名
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "分类名")
	private String sortName;

}
