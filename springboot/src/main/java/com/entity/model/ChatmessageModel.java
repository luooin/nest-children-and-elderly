package com.entity.model;

import com.entity.ChatmessageEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 消息表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
public class ChatmessageModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 好友用户ID
	 */
	
	private Long fid;
		
	/**
	 * 内容
	 */
	
	private String content;
		
	/**
	 * 格式(1:文字，2:图片)
	 */
	
	private Integer format;
		
	/**
	 * 消息已读(0:未读，1:已读)
	 */
	
	private Integer isread;
				
	
	/**
	 * 设置：好友用户ID
	 */
	 
	public void setFid(Long fid) {
		this.fid = fid;
	}
	
	/**
	 * 获取：好友用户ID
	 */
	public Long getFid() {
		return fid;
	}
				
	
	/**
	 * 设置：内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
				
	
	/**
	 * 设置：格式(1:文字，2:图片)
	 */
	 
	public void setFormat(Integer format) {
		this.format = format;
	}
	
	/**
	 * 获取：格式(1:文字，2:图片)
	 */
	public Integer getFormat() {
		return format;
	}
				
	
	/**
	 * 设置：消息已读(0:未读，1:已读)
	 */
	 
	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	
	/**
	 * 获取：消息已读(0:未读，1:已读)
	 */
	public Integer getIsread() {
		return isread;
	}
			
}
