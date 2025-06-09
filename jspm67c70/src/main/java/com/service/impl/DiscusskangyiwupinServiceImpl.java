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


import com.dao.DiscusskangyiwupinDao;
import com.entity.DiscusskangyiwupinEntity;
import com.service.DiscusskangyiwupinService;
import com.entity.vo.DiscusskangyiwupinVO;
import com.entity.view.DiscusskangyiwupinView;

@Service("discusskangyiwupinService")
public class DiscusskangyiwupinServiceImpl extends ServiceImpl<DiscusskangyiwupinDao, DiscusskangyiwupinEntity> implements DiscusskangyiwupinService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusskangyiwupinEntity> page = this.selectPage(
                new Query<DiscusskangyiwupinEntity>(params).getPage(),
                new EntityWrapper<DiscusskangyiwupinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusskangyiwupinEntity> wrapper) {
		  Page<DiscusskangyiwupinView> page =new Query<DiscusskangyiwupinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusskangyiwupinVO> selectListVO(Wrapper<DiscusskangyiwupinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusskangyiwupinVO selectVO(Wrapper<DiscusskangyiwupinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusskangyiwupinView> selectListView(Wrapper<DiscusskangyiwupinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusskangyiwupinView selectView(Wrapper<DiscusskangyiwupinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
