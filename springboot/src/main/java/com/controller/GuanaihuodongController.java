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

import com.entity.GuanaihuodongEntity;
import com.entity.view.GuanaihuodongView;

import com.service.GuanaihuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 关爱活动
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-17 18:21:12
 */
@RestController
@RequestMapping("/guanaihuodong")
public class GuanaihuodongController {
    @Autowired
    private GuanaihuodongService guanaihuodongService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GuanaihuodongEntity guanaihuodong,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			guanaihuodong.setFabuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GuanaihuodongEntity> ew = new EntityWrapper<GuanaihuodongEntity>();

		PageUtils page = guanaihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guanaihuodong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GuanaihuodongEntity guanaihuodong, 
		HttpServletRequest request){
        EntityWrapper<GuanaihuodongEntity> ew = new EntityWrapper<GuanaihuodongEntity>();

		PageUtils page = guanaihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guanaihuodong), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GuanaihuodongEntity guanaihuodong){
       	EntityWrapper<GuanaihuodongEntity> ew = new EntityWrapper<GuanaihuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( guanaihuodong, "guanaihuodong")); 
        return R.ok().put("data", guanaihuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GuanaihuodongEntity guanaihuodong){
        EntityWrapper< GuanaihuodongEntity> ew = new EntityWrapper< GuanaihuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( guanaihuodong, "guanaihuodong")); 
		GuanaihuodongView guanaihuodongView =  guanaihuodongService.selectView(ew);
		return R.ok("查询关爱活动成功").put("data", guanaihuodongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GuanaihuodongEntity guanaihuodong = guanaihuodongService.selectById(id);
		guanaihuodong.setClicknum(guanaihuodong.getClicknum()+1);
		guanaihuodong.setClicktime(new Date());
		guanaihuodongService.updateById(guanaihuodong);
        guanaihuodong = guanaihuodongService.selectView(new EntityWrapper<GuanaihuodongEntity>().eq("id", id));
        return R.ok().put("data", guanaihuodong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GuanaihuodongEntity guanaihuodong = guanaihuodongService.selectById(id);
		guanaihuodong.setClicknum(guanaihuodong.getClicknum()+1);
		guanaihuodong.setClicktime(new Date());
		guanaihuodongService.updateById(guanaihuodong);
        guanaihuodong = guanaihuodongService.selectView(new EntityWrapper<GuanaihuodongEntity>().eq("id", id));
        return R.ok().put("data", guanaihuodong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GuanaihuodongEntity guanaihuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(guanaihuodong);
        guanaihuodongService.insert(guanaihuodong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GuanaihuodongEntity guanaihuodong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(guanaihuodong);
        guanaihuodongService.insert(guanaihuodong);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GuanaihuodongEntity guanaihuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(guanaihuodong);
        guanaihuodongService.updateById(guanaihuodong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<GuanaihuodongEntity> list = new ArrayList<GuanaihuodongEntity>();
        for(Long id : ids) {
            GuanaihuodongEntity guanaihuodong = guanaihuodongService.selectById(id);
            guanaihuodong.setSfsh(sfsh);
            guanaihuodong.setShhf(shhf);
            list.add(guanaihuodong);
        }
        guanaihuodongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        guanaihuodongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,GuanaihuodongEntity guanaihuodong, HttpServletRequest request,String pre){
        EntityWrapper<GuanaihuodongEntity> ew = new EntityWrapper<GuanaihuodongEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = guanaihuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, guanaihuodong), params), params));
        return R.ok().put("data", page);
    }










}
