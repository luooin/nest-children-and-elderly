package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.FuwuleixingEntity;
import com.entity.view.FuwuleixingView;

import com.service.FuwuleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 服务类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
@RestController
@RequestMapping("/fuwuleixing")
public class FuwuleixingController {
    @Autowired
    private FuwuleixingService fuwuleixingService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FuwuleixingEntity fuwuleixing,
		HttpServletRequest request){
        EntityWrapper<FuwuleixingEntity> ew = new EntityWrapper<FuwuleixingEntity>();

		PageUtils page = fuwuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FuwuleixingEntity fuwuleixing, 
		HttpServletRequest request){
        EntityWrapper<FuwuleixingEntity> ew = new EntityWrapper<FuwuleixingEntity>();

		PageUtils page = fuwuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fuwuleixing), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FuwuleixingEntity fuwuleixing){
       	EntityWrapper<FuwuleixingEntity> ew = new EntityWrapper<FuwuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fuwuleixing, "fuwuleixing")); 
        return R.ok().put("data", fuwuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FuwuleixingEntity fuwuleixing){
        EntityWrapper< FuwuleixingEntity> ew = new EntityWrapper< FuwuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fuwuleixing, "fuwuleixing")); 
		FuwuleixingView fuwuleixingView =  fuwuleixingService.selectView(ew);
		return R.ok("查询服务类型成功").put("data", fuwuleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FuwuleixingEntity fuwuleixing = fuwuleixingService.selectById(id);
        return R.ok().put("data", fuwuleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FuwuleixingEntity fuwuleixing = fuwuleixingService.selectById(id);
        return R.ok().put("data", fuwuleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FuwuleixingEntity fuwuleixing, HttpServletRequest request){
        if(fuwuleixingService.selectCount(new EntityWrapper<FuwuleixingEntity>().eq("fuwuleixing", fuwuleixing.getFuwuleixing()))>0) {
            return R.error("服务类型已存在");
        }
    	//ValidatorUtils.validateEntity(fuwuleixing);
        fuwuleixingService.insert(fuwuleixing);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FuwuleixingEntity fuwuleixing, HttpServletRequest request){
        if(fuwuleixingService.selectCount(new EntityWrapper<FuwuleixingEntity>().eq("fuwuleixing", fuwuleixing.getFuwuleixing()))>0) {
            return R.error("服务类型已存在");
        }
    	//ValidatorUtils.validateEntity(fuwuleixing);
        fuwuleixingService.insert(fuwuleixing);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FuwuleixingEntity fuwuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fuwuleixing);
        if(fuwuleixingService.selectCount(new EntityWrapper<FuwuleixingEntity>().ne("id", fuwuleixing.getId()).eq("fuwuleixing", fuwuleixing.getFuwuleixing()))>0) {
            return R.error("服务类型已存在");
        }
        fuwuleixingService.updateById(fuwuleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fuwuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
