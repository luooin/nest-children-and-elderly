package com.entity.view;

import com.entity.GuanaihuodongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 关爱活动
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
@TableName("guanaihuodong")
public class GuanaihuodongView  extends GuanaihuodongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GuanaihuodongView(){
	}
 
 	public GuanaihuodongView(GuanaihuodongEntity guanaihuodongEntity){
 	try {
			BeanUtils.copyProperties(this, guanaihuodongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
