package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KongchaolaorenDao;
import com.entity.KongchaolaorenEntity;
import com.service.KongchaolaorenService;
import com.entity.vo.KongchaolaorenVO;
import com.entity.view.KongchaolaorenView;

@Service("kongchaolaorenService")
public class KongchaolaorenServiceImpl extends ServiceImpl<KongchaolaorenDao, KongchaolaorenEntity> implements KongchaolaorenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KongchaolaorenEntity> page = this.selectPage(
                new Query<KongchaolaorenEntity>(params).getPage(),
                new EntityWrapper<KongchaolaorenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KongchaolaorenEntity> wrapper) {
		  Page<KongchaolaorenView> page =new Query<KongchaolaorenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KongchaolaorenVO> selectListVO(Wrapper<KongchaolaorenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KongchaolaorenVO selectVO(Wrapper<KongchaolaorenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KongchaolaorenView> selectListView(Wrapper<KongchaolaorenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KongchaolaorenView selectView(Wrapper<KongchaolaorenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
