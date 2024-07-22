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


import com.dao.GuanaihuodongDao;
import com.entity.GuanaihuodongEntity;
import com.service.GuanaihuodongService;
import com.entity.vo.GuanaihuodongVO;
import com.entity.view.GuanaihuodongView;

@Service("guanaihuodongService")
public class GuanaihuodongServiceImpl extends ServiceImpl<GuanaihuodongDao, GuanaihuodongEntity> implements GuanaihuodongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuanaihuodongEntity> page = this.selectPage(
                new Query<GuanaihuodongEntity>(params).getPage(),
                new EntityWrapper<GuanaihuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GuanaihuodongEntity> wrapper) {
		  Page<GuanaihuodongView> page =new Query<GuanaihuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GuanaihuodongVO> selectListVO(Wrapper<GuanaihuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GuanaihuodongVO selectVO(Wrapper<GuanaihuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GuanaihuodongView> selectListView(Wrapper<GuanaihuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GuanaihuodongView selectView(Wrapper<GuanaihuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
