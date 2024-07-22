package com.dao;

import com.entity.ErtongxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ErtongxinxiVO;
import com.entity.view.ErtongxinxiView;


/**
 * 儿童信息
 * 
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
public interface ErtongxinxiDao extends BaseMapper<ErtongxinxiEntity> {
	
	List<ErtongxinxiVO> selectListVO(@Param("ew") Wrapper<ErtongxinxiEntity> wrapper);
	
	ErtongxinxiVO selectVO(@Param("ew") Wrapper<ErtongxinxiEntity> wrapper);
	
	List<ErtongxinxiView> selectListView(@Param("ew") Wrapper<ErtongxinxiEntity> wrapper);

	List<ErtongxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ErtongxinxiEntity> wrapper);

	
	ErtongxinxiView selectView(@Param("ew") Wrapper<ErtongxinxiEntity> wrapper);
	

}
