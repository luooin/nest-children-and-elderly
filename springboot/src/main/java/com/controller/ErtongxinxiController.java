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

import com.entity.ErtongxinxiEntity;
import com.entity.view.ErtongxinxiView;

import com.service.ErtongxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 儿童信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
@RestController
@RequestMapping("/ertongxinxi")
public class ErtongxinxiController {
    @Autowired
    private ErtongxinxiService ertongxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ErtongxinxiEntity ertongxinxi,
		HttpServletRequest request){
        EntityWrapper<ErtongxinxiEntity> ew = new EntityWrapper<ErtongxinxiEntity>();

		PageUtils page = ertongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ertongxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ErtongxinxiEntity ertongxinxi, 
		HttpServletRequest request){
        EntityWrapper<ErtongxinxiEntity> ew = new EntityWrapper<ErtongxinxiEntity>();

		PageUtils page = ertongxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ertongxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ErtongxinxiEntity ertongxinxi){
       	EntityWrapper<ErtongxinxiEntity> ew = new EntityWrapper<ErtongxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ertongxinxi, "ertongxinxi")); 
        return R.ok().put("data", ertongxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ErtongxinxiEntity ertongxinxi){
        EntityWrapper< ErtongxinxiEntity> ew = new EntityWrapper< ErtongxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ertongxinxi, "ertongxinxi")); 
		ErtongxinxiView ertongxinxiView =  ertongxinxiService.selectView(ew);
		return R.ok("查询儿童信息成功").put("data", ertongxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ErtongxinxiEntity ertongxinxi = ertongxinxiService.selectById(id);
        return R.ok().put("data", ertongxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ErtongxinxiEntity ertongxinxi = ertongxinxiService.selectById(id);
        return R.ok().put("data", ertongxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ErtongxinxiEntity ertongxinxi, HttpServletRequest request){
        if(ertongxinxiService.selectCount(new EntityWrapper<ErtongxinxiEntity>().eq("ertongbianhao", ertongxinxi.getErtongbianhao()))>0) {
            return R.error("儿童编号已存在");
        }
    	//ValidatorUtils.validateEntity(ertongxinxi);
        ertongxinxiService.insert(ertongxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ErtongxinxiEntity ertongxinxi, HttpServletRequest request){
        if(ertongxinxiService.selectCount(new EntityWrapper<ErtongxinxiEntity>().eq("ertongbianhao", ertongxinxi.getErtongbianhao()))>0) {
            return R.error("儿童编号已存在");
        }
    	//ValidatorUtils.validateEntity(ertongxinxi);
        ertongxinxiService.insert(ertongxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ErtongxinxiEntity ertongxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ertongxinxi);
        if(ertongxinxiService.selectCount(new EntityWrapper<ErtongxinxiEntity>().ne("id", ertongxinxi.getId()).eq("ertongbianhao", ertongxinxi.getErtongbianhao()))>0) {
            return R.error("儿童编号已存在");
        }
        ertongxinxiService.updateById(ertongxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ertongxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
