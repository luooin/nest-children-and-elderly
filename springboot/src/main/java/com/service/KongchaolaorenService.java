package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KongchaolaorenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KongchaolaorenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KongchaolaorenView;


/**
 * 空巢老人
 *
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
public interface KongchaolaorenService extends IService<KongchaolaorenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KongchaolaorenVO> selectListVO(Wrapper<KongchaolaorenEntity> wrapper);
   	
   	KongchaolaorenVO selectVO(@Param("ew") Wrapper<KongchaolaorenEntity> wrapper);
   	
   	List<KongchaolaorenView> selectListView(Wrapper<KongchaolaorenEntity> wrapper);
   	
   	KongchaolaorenView selectView(@Param("ew") Wrapper<KongchaolaorenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KongchaolaorenEntity> wrapper);

   	

}

