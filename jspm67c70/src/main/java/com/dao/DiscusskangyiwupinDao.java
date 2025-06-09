package com.dao;

import com.entity.DiscusskangyiwupinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusskangyiwupinVO;
import com.entity.view.DiscusskangyiwupinView;


/**
 * 抗疫物品评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-19 10:07:56
 */
public interface DiscusskangyiwupinDao extends BaseMapper<DiscusskangyiwupinEntity> {
	
	List<DiscusskangyiwupinVO> selectListVO(@Param("ew") Wrapper<DiscusskangyiwupinEntity> wrapper);
	
	DiscusskangyiwupinVO selectVO(@Param("ew") Wrapper<DiscusskangyiwupinEntity> wrapper);
	
	List<DiscusskangyiwupinView> selectListView(@Param("ew") Wrapper<DiscusskangyiwupinEntity> wrapper);

	List<DiscusskangyiwupinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusskangyiwupinEntity> wrapper);
	
	DiscusskangyiwupinView selectView(@Param("ew") Wrapper<DiscusskangyiwupinEntity> wrapper);
	
}
