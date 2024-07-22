package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CanyuhuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CanyuhuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CanyuhuodongView;


/**
 * 参与活动
 *
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
public interface CanyuhuodongService extends IService<CanyuhuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CanyuhuodongVO> selectListVO(Wrapper<CanyuhuodongEntity> wrapper);
   	
   	CanyuhuodongVO selectVO(@Param("ew") Wrapper<CanyuhuodongEntity> wrapper);
   	
   	List<CanyuhuodongView> selectListView(Wrapper<CanyuhuodongEntity> wrapper);
   	
   	CanyuhuodongView selectView(@Param("ew") Wrapper<CanyuhuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CanyuhuodongEntity> wrapper);

   	

}

