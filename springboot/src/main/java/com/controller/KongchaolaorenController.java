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

import com.entity.KongchaolaorenEntity;
import com.entity.view.KongchaolaorenView;

import com.service.KongchaolaorenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 空巢老人
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
@RestController
@RequestMapping("/kongchaolaoren")
public class KongchaolaorenController {
    @Autowired
    private KongchaolaorenService kongchaolaorenService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KongchaolaorenEntity kongchaolaoren,
		HttpServletRequest request){
        EntityWrapper<KongchaolaorenEntity> ew = new EntityWrapper<KongchaolaorenEntity>();

		PageUtils page = kongchaolaorenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kongchaolaoren), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KongchaolaorenEntity kongchaolaoren, 
		HttpServletRequest request){
        EntityWrapper<KongchaolaorenEntity> ew = new EntityWrapper<KongchaolaorenEntity>();

		PageUtils page = kongchaolaorenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kongchaolaoren), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KongchaolaorenEntity kongchaolaoren){
       	EntityWrapper<KongchaolaorenEntity> ew = new EntityWrapper<KongchaolaorenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kongchaolaoren, "kongchaolaoren")); 
        return R.ok().put("data", kongchaolaorenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KongchaolaorenEntity kongchaolaoren){
        EntityWrapper< KongchaolaorenEntity> ew = new EntityWrapper< KongchaolaorenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kongchaolaoren, "kongchaolaoren")); 
		KongchaolaorenView kongchaolaorenView =  kongchaolaorenService.selectView(ew);
		return R.ok("查询空巢老人成功").put("data", kongchaolaorenView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KongchaolaorenEntity kongchaolaoren = kongchaolaorenService.selectById(id);
        return R.ok().put("data", kongchaolaoren);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KongchaolaorenEntity kongchaolaoren = kongchaolaorenService.selectById(id);
        return R.ok().put("data", kongchaolaoren);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KongchaolaorenEntity kongchaolaoren, HttpServletRequest request){
        if(kongchaolaorenService.selectCount(new EntityWrapper<KongchaolaorenEntity>().eq("laorenbianhao", kongchaolaoren.getLaorenbianhao()))>0) {
            return R.error("老人编号已存在");
        }
    	//ValidatorUtils.validateEntity(kongchaolaoren);
        kongchaolaorenService.insert(kongchaolaoren);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KongchaolaorenEntity kongchaolaoren, HttpServletRequest request){
        if(kongchaolaorenService.selectCount(new EntityWrapper<KongchaolaorenEntity>().eq("laorenbianhao", kongchaolaoren.getLaorenbianhao()))>0) {
            return R.error("老人编号已存在");
        }
    	//ValidatorUtils.validateEntity(kongchaolaoren);
        kongchaolaorenService.insert(kongchaolaoren);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KongchaolaorenEntity kongchaolaoren, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kongchaolaoren);
        if(kongchaolaorenService.selectCount(new EntityWrapper<KongchaolaorenEntity>().ne("id", kongchaolaoren.getId()).eq("laorenbianhao", kongchaolaoren.getLaorenbianhao()))>0) {
            return R.error("老人编号已存在");
        }
        kongchaolaorenService.updateById(kongchaolaoren);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kongchaolaorenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
