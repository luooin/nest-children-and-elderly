package com.dao;

import com.entity.GuanaihuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GuanaihuodongVO;
import com.entity.view.GuanaihuodongView;


/**
 * 关爱活动
 * 
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
public interface GuanaihuodongDao extends BaseMapper<GuanaihuodongEntity> {
	
	List<GuanaihuodongVO> selectListVO(@Param("ew") Wrapper<GuanaihuodongEntity> wrapper);
	
	GuanaihuodongVO selectVO(@Param("ew") Wrapper<GuanaihuodongEntity> wrapper);
	
	List<GuanaihuodongView> selectListView(@Param("ew") Wrapper<GuanaihuodongEntity> wrapper);

	List<GuanaihuodongView> selectListView(Pagination page,@Param("ew") Wrapper<GuanaihuodongEntity> wrapper);

	
	GuanaihuodongView selectView(@Param("ew") Wrapper<GuanaihuodongEntity> wrapper);
	

}
