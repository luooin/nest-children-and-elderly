package com.dao;

import com.entity.CanyuhuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CanyuhuodongVO;
import com.entity.view.CanyuhuodongView;


/**
 * 参与活动
 * 
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
public interface CanyuhuodongDao extends BaseMapper<CanyuhuodongEntity> {
	
	List<CanyuhuodongVO> selectListVO(@Param("ew") Wrapper<CanyuhuodongEntity> wrapper);
	
	CanyuhuodongVO selectVO(@Param("ew") Wrapper<CanyuhuodongEntity> wrapper);
	
	List<CanyuhuodongView> selectListView(@Param("ew") Wrapper<CanyuhuodongEntity> wrapper);

	List<CanyuhuodongView> selectListView(Pagination page,@Param("ew") Wrapper<CanyuhuodongEntity> wrapper);

	
	CanyuhuodongView selectView(@Param("ew") Wrapper<CanyuhuodongEntity> wrapper);
	

}
