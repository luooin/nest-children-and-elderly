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


import com.dao.CanyuhuodongDao;
import com.entity.CanyuhuodongEntity;
import com.service.CanyuhuodongService;
import com.entity.vo.CanyuhuodongVO;
import com.entity.view.CanyuhuodongView;

@Service("canyuhuodongService")
public class CanyuhuodongServiceImpl extends ServiceImpl<CanyuhuodongDao, CanyuhuodongEntity> implements CanyuhuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CanyuhuodongEntity> page = this.selectPage(
                new Query<CanyuhuodongEntity>(params).getPage(),
                new EntityWrapper<CanyuhuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CanyuhuodongEntity> wrapper) {
		  Page<CanyuhuodongView> page =new Query<CanyuhuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CanyuhuodongVO> selectListVO(Wrapper<CanyuhuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CanyuhuodongVO selectVO(Wrapper<CanyuhuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CanyuhuodongView> selectListView(Wrapper<CanyuhuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CanyuhuodongView selectView(Wrapper<CanyuhuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
