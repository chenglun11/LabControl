package com.lchnan7.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 报修
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-02-14
 */
@Data
@TableName("`repair`")
@ApiModel(value="repair对象", description="报修")
public class Repair {

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
     * 报修信息
     */
	@ApiModelProperty(value = "报修信息")
	private String remark;
    /**
     * 检修人
     */
	@ApiModelProperty(value = "检修人")
	private String repairPerson;
    /**
     * 检修单位
     */
	@ApiModelProperty(value = "检修单位")
	private String repairDept;
    /**
     * 检修时间
     */
	@ApiModelProperty(value = "检修时间")
	private String repairTime;
    /**
     * 报修说明
     */
	@ApiModelProperty(value = "报修说明")
	private String repairRemark;
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
	 * 上报人
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "上报人")
	private String realName;
	/**
	 * 实验室
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "实验室")
	private String labName;

}
