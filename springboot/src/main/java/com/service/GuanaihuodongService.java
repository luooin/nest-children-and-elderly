package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GuanaihuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GuanaihuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GuanaihuodongView;


/**
 * 关爱活动
 *
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
public interface GuanaihuodongService extends IService<GuanaihuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GuanaihuodongVO> selectListVO(Wrapper<GuanaihuodongEntity> wrapper);
   	
   	GuanaihuodongVO selectVO(@Param("ew") Wrapper<GuanaihuodongEntity> wrapper);
   	
   	List<GuanaihuodongView> selectListView(Wrapper<GuanaihuodongEntity> wrapper);
   	
   	GuanaihuodongView selectView(@Param("ew") Wrapper<GuanaihuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GuanaihuodongEntity> wrapper);

   	

}

