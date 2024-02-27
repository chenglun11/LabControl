package com.lchnan7.modules.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * comment
 *
 * @author LCHNAN lchnan7@outlook.com
 * @since 1.0.0 2023-01-31
 */
@Data
@TableName("comment")
public class Comment {

    /**
     * 主键id
     */
    
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	    /**
     * 父id
     */
    	private Integer pid;
	    /**
     * 评论信息
     */
    	private String comment;
	    /**
     * 发布人
     */
    	private Integer userId;
	    /**
     * 回复人
     */
    	private Integer replyUserId;
	    /**
     * 评论时间
     */
    	private String createTime;
		/**
	 * 评论人
	 */
	@TableField(exist = false)
	private String realName;
	/**
	 * 回复人
	 */
	@TableField(exist = false)
	private String replyRealName;

	private Integer archivesId;


	@TableField(exist = false)
	private String title;


	@TableField(exist = false)
	private String imageUrl;

	@TableField(exist = false)
	private List<Comment> reply;

	private String browserName;

	private String browserVersion;

	private String systemName;

	private String systemVersion;

	private String ipAddress;


}