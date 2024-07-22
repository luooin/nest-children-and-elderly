package com.dao;

import com.entity.KongchaolaorenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KongchaolaorenVO;
import com.entity.view.KongchaolaorenView;


/**
 * 空巢老人
 * 
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
public interface KongchaolaorenDao extends BaseMapper<KongchaolaorenEntity> {
	
	List<KongchaolaorenVO> selectListVO(@Param("ew") Wrapper<KongchaolaorenEntity> wrapper);
	
	KongchaolaorenVO selectVO(@Param("ew") Wrapper<KongchaolaorenEntity> wrapper);
	
	List<KongchaolaorenView> selectListView(@Param("ew") Wrapper<KongchaolaorenEntity> wrapper);

	List<KongchaolaorenView> selectListView(Pagination page,@Param("ew") Wrapper<KongchaolaorenEntity> wrapper);

	
	KongchaolaorenView selectView(@Param("ew") Wrapper<KongchaolaorenEntity> wrapper);
	

}
