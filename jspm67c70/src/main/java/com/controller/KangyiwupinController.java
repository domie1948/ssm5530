package com.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.KangyiwupinEntity;
import com.entity.view.KangyiwupinView;

import com.service.KangyiwupinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 抗疫物品
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-19 10:07:56
 */
@RestController
@RequestMapping("/kangyiwupin")
public class KangyiwupinController {
    @Autowired
    private KangyiwupinService kangyiwupinService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KangyiwupinEntity kangyiwupin, 
		HttpServletRequest request){

        EntityWrapper<KangyiwupinEntity> ew = new EntityWrapper<KangyiwupinEntity>();
    	PageUtils page = kangyiwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kangyiwupin), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KangyiwupinEntity kangyiwupin, HttpServletRequest request){
        EntityWrapper<KangyiwupinEntity> ew = new EntityWrapper<KangyiwupinEntity>();
    	PageUtils page = kangyiwupinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kangyiwupin), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KangyiwupinEntity kangyiwupin){
       	EntityWrapper<KangyiwupinEntity> ew = new EntityWrapper<KangyiwupinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kangyiwupin, "kangyiwupin")); 
        return R.ok().put("data", kangyiwupinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KangyiwupinEntity kangyiwupin){
        EntityWrapper< KangyiwupinEntity> ew = new EntityWrapper< KangyiwupinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kangyiwupin, "kangyiwupin")); 
		KangyiwupinView kangyiwupinView =  kangyiwupinService.selectView(ew);
		return R.ok("查询抗疫物品成功").put("data", kangyiwupinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KangyiwupinEntity kangyiwupin = kangyiwupinService.selectById(id);
        return R.ok().put("data", kangyiwupin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KangyiwupinEntity kangyiwupin = kangyiwupinService.selectById(id);
        return R.ok().put("data", kangyiwupin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        KangyiwupinEntity kangyiwupin = kangyiwupinService.selectById(id);
        if(type.equals("1")) {
        	kangyiwupin.setThumbsupnum(kangyiwupin.getThumbsupnum()+1);
        } else {
        	kangyiwupin.setCrazilynum(kangyiwupin.getCrazilynum()+1);
        }
        kangyiwupinService.updateById(kangyiwupin);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KangyiwupinEntity kangyiwupin, HttpServletRequest request){
    	kangyiwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kangyiwupin);

        kangyiwupinService.insert(kangyiwupin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KangyiwupinEntity kangyiwupin, HttpServletRequest request){
    	kangyiwupin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kangyiwupin);

        kangyiwupinService.insert(kangyiwupin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody KangyiwupinEntity kangyiwupin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kangyiwupin);
        kangyiwupinService.updateById(kangyiwupin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kangyiwupinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<KangyiwupinEntity> wrapper = new EntityWrapper<KangyiwupinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = kangyiwupinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	


}
