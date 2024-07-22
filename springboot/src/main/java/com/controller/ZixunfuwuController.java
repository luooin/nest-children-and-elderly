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

import com.entity.ZixunfuwuEntity;
import com.entity.view.ZixunfuwuView;

import com.service.ZixunfuwuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 咨询服务
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
@RestController
@RequestMapping("/zixunfuwu")
public class ZixunfuwuController {
    @Autowired
    private ZixunfuwuService zixunfuwuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZixunfuwuEntity zixunfuwu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zixunfuwu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZixunfuwuEntity> ew = new EntityWrapper<ZixunfuwuEntity>();

		PageUtils page = zixunfuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunfuwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZixunfuwuEntity zixunfuwu, 
		HttpServletRequest request){
        EntityWrapper<ZixunfuwuEntity> ew = new EntityWrapper<ZixunfuwuEntity>();

		PageUtils page = zixunfuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zixunfuwu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZixunfuwuEntity zixunfuwu){
       	EntityWrapper<ZixunfuwuEntity> ew = new EntityWrapper<ZixunfuwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zixunfuwu, "zixunfuwu")); 
        return R.ok().put("data", zixunfuwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZixunfuwuEntity zixunfuwu){
        EntityWrapper< ZixunfuwuEntity> ew = new EntityWrapper< ZixunfuwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zixunfuwu, "zixunfuwu")); 
		ZixunfuwuView zixunfuwuView =  zixunfuwuService.selectView(ew);
		return R.ok("查询咨询服务成功").put("data", zixunfuwuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZixunfuwuEntity zixunfuwu = zixunfuwuService.selectById(id);
        return R.ok().put("data", zixunfuwu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZixunfuwuEntity zixunfuwu = zixunfuwuService.selectById(id);
        return R.ok().put("data", zixunfuwu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZixunfuwuEntity zixunfuwu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zixunfuwu);
        zixunfuwuService.insert(zixunfuwu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZixunfuwuEntity zixunfuwu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zixunfuwu);
        zixunfuwuService.insert(zixunfuwu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZixunfuwuEntity zixunfuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zixunfuwu);
        zixunfuwuService.updateById(zixunfuwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zixunfuwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
