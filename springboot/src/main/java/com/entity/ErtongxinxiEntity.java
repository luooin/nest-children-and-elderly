package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 儿童信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
@TableName("ertongxinxi")
public class ErtongxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ErtongxinxiEntity() {
		
	}
	
	public ErtongxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 儿童编号
	 */
					
	private String ertongbianhao;
	
	/**
	 * 儿童姓名
	 */
					
	private String ertongxingming;
	
	/**
	 * 儿童照片
	 */
					
	private String ertongzhaopian;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 年龄
	 */
					
	private Integer nianling;
	
	/**
	 * 兴趣爱好
	 */
					
	private String xingquaihao;
	
	/**
	 * 家庭情况
	 */
					
	private String jiatingqingkuang;
	
	/**
	 * 学习状况
	 */
					
	private String xuexizhuangkuang;
	
	/**
	 * 儿童信息
	 */
					
	private String ertongxinxi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：儿童编号
	 */
	public void setErtongbianhao(String ertongbianhao) {
		this.ertongbianhao = ertongbianhao;
	}
	/**
	 * 获取：儿童编号
	 */
	public String getErtongbianhao() {
		return ertongbianhao;
	}
	/**
	 * 设置：儿童姓名
	 */
	public void setErtongxingming(String ertongxingming) {
		this.ertongxingming = ertongxingming;
	}
	/**
	 * 获取：儿童姓名
	 */
	public String getErtongxingming() {
		return ertongxingming;
	}
	/**
	 * 设置：儿童照片
	 */
	public void setErtongzhaopian(String ertongzhaopian) {
		this.ertongzhaopian = ertongzhaopian;
	}
	/**
	 * 获取：儿童照片
	 */
	public String getErtongzhaopian() {
		return ertongzhaopian;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getNianling() {
		return nianling;
	}
	/**
	 * 设置：兴趣爱好
	 */
	public void setXingquaihao(String xingquaihao) {
		this.xingquaihao = xingquaihao;
	}
	/**
	 * 获取：兴趣爱好
	 */
	public String getXingquaihao() {
		return xingquaihao;
	}
	/**
	 * 设置：家庭情况
	 */
	public void setJiatingqingkuang(String jiatingqingkuang) {
		this.jiatingqingkuang = jiatingqingkuang;
	}
	/**
	 * 获取：家庭情况
	 */
	public String getJiatingqingkuang() {
		return jiatingqingkuang;
	}
	/**
	 * 设置：学习状况
	 */
	public void setXuexizhuangkuang(String xuexizhuangkuang) {
		this.xuexizhuangkuang = xuexizhuangkuang;
	}
	/**
	 * 获取：学习状况
	 */
	public String getXuexizhuangkuang() {
		return xuexizhuangkuang;
	}
	/**
	 * 设置：儿童信息
	 */
	public void setErtongxinxi(String ertongxinxi) {
		this.ertongxinxi = ertongxinxi;
	}
	/**
	 * 获取：儿童信息
	 */
	public String getErtongxinxi() {
		return ertongxinxi;
	}

}
