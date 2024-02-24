package com.lchnan7.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 攻略
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2024-01-05
 */
@Data
@TableName("`archives`")
@ApiModel(value="archives对象", description="攻略")
public class Archives {

    /**
     * 主键id
     */
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer id;
    /**
     * 攻略标题
     */
	@ApiModelProperty(value = "攻略标题")
	private String title;
    /**
     * 攻略简介
     */
	@ApiModelProperty(value = "攻略简介")
	private String summary;
    /**
     * 分类
     */
	@ApiModelProperty(value = "分类")
	private Integer sortId;
    /**
     * 详细内容
     */
	@ApiModelProperty(value = "详细内容")
	private String content;
    /**
     * 所在城市
     */
	@ApiModelProperty(value = "所在城市")
	private String address;
    /**
     * 是否推荐
     */
	@ApiModelProperty(value = "是否推荐")
	private Integer isBanner;
    /**
     * 图片
     */
	@ApiModelProperty(value = "图片")
	private String imageUrl;
    /**
     * 用户id
     */
	@ApiModelProperty(value = "用户id")
	private Integer userId;
    /**
     * 状态
     */
	@ApiModelProperty(value = "状态")
	private Integer type;
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
	 * 分类
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "分类")
	private String sortName;
	/**
	 * 发布人
	 */
	@TableField(exist = false)
	@ApiModelProperty(value = "发布人")
	private String realName;


	@TableField(exist = false)
	private String userImageUrl;

	@TableField(exist = false)
	private Integer likeCount;

	@TableField(exist = false)
	private Integer commentCount;

	@TableField(exist = false)
	private Integer collectCount;

	@TableField(exist = false)
	private Boolean isLike = false;

	@TableField(exist = false)
	private Boolean isCollect = false;

	@TableField(exist = false)
	private String loginUserId;

	private Integer readCount;

	private String documentUrl;

	private Double score;
}
