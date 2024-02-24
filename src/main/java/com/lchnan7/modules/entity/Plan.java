package com.lchnan7.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 计划
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-02-21
 */
@Data
@TableName("`plan`")
@ApiModel(value="plan对象", description="计划")
public class Plan {

    /**
     * 主键id
     */
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer id;
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
     * 备注
     */
	@ApiModelProperty(value = "备注")
	private String remark;
    /**
     * 实验室
     */
	@ApiModelProperty(value = "实验室")
	private Integer labId;
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
	 * 实验室
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "实验室")
	private String labName;

}
