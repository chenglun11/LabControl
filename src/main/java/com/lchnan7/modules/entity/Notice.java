package com.lchnan7.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("`notice`")
@ApiModel(value="notice对象", description="公告")
public class Notice {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Integer id;
    /**
     * 公告标题
     */
    @ApiModelProperty(value = "公告标题")
    private String title;
    /**
     * 公告详情
     */
    @ApiModelProperty(value = "公告详情")
    private String content;

    @TableField(exist = false)
    @ApiModelProperty(value = "发布人")
    private String realName;
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer userId;

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

    @TableField(exist = false)
    private String loginUserId;

}
