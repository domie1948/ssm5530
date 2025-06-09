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


import com.dao.YiqingtieshiDao;
import com.entity.YiqingtieshiEntity;
import com.service.YiqingtieshiService;
import com.entity.vo.YiqingtieshiVO;
import com.entity.view.YiqingtieshiView;

@Service("yiqingtieshiService")
public class YiqingtieshiServiceImpl extends ServiceImpl<YiqingtieshiDao, YiqingtieshiEntity> implements YiqingtieshiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YiqingtieshiEntity> page = this.selectPage(
                new Query<YiqingtieshiEntity>(params).getPage(),
                new EntityWrapper<YiqingtieshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YiqingtieshiEntity> wrapper) {
		  Page<YiqingtieshiView> page =new Query<YiqingtieshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YiqingtieshiVO> selectListVO(Wrapper<YiqingtieshiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YiqingtieshiVO selectVO(Wrapper<YiqingtieshiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YiqingtieshiView> selectListView(Wrapper<YiqingtieshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YiqingtieshiView selectView(Wrapper<YiqingtieshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
