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


import com.dao.KangyiwupinDao;
import com.entity.KangyiwupinEntity;
import com.service.KangyiwupinService;
import com.entity.vo.KangyiwupinVO;
import com.entity.view.KangyiwupinView;

@Service("kangyiwupinService")
public class KangyiwupinServiceImpl extends ServiceImpl<KangyiwupinDao, KangyiwupinEntity> implements KangyiwupinService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KangyiwupinEntity> page = this.selectPage(
                new Query<KangyiwupinEntity>(params).getPage(),
                new EntityWrapper<KangyiwupinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KangyiwupinEntity> wrapper) {
		  Page<KangyiwupinView> page =new Query<KangyiwupinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KangyiwupinVO> selectListVO(Wrapper<KangyiwupinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KangyiwupinVO selectVO(Wrapper<KangyiwupinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KangyiwupinView> selectListView(Wrapper<KangyiwupinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KangyiwupinView selectView(Wrapper<KangyiwupinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
