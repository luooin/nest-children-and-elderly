package com.entity.view;

import com.entity.CanyuhuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 参与活动
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
@TableName("canyuhuodong")
public class CanyuhuodongView  extends CanyuhuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CanyuhuodongView(){
	}
 
 	public CanyuhuodongView(CanyuhuodongEntity canyuhuodongEntity){
 	try {
			BeanUtils.copyProperties(this, canyuhuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
