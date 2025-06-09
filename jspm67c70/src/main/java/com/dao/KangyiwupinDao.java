package com.dao;

import com.entity.KangyiwupinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KangyiwupinVO;
import com.entity.view.KangyiwupinView;


/**
 * 抗疫物品
 * 
 * @author 
 * @email 
 * @date 2021-03-19 10:07:56
 */
public interface KangyiwupinDao extends BaseMapper<KangyiwupinEntity> {
	
	List<KangyiwupinVO> selectListVO(@Param("ew") Wrapper<KangyiwupinEntity> wrapper);
	
	KangyiwupinVO selectVO(@Param("ew") Wrapper<KangyiwupinEntity> wrapper);
	
	List<KangyiwupinView> selectListView(@Param("ew") Wrapper<KangyiwupinEntity> wrapper);

	List<KangyiwupinView> selectListView(Pagination page,@Param("ew") Wrapper<KangyiwupinEntity> wrapper);
	
	KangyiwupinView selectView(@Param("ew") Wrapper<KangyiwupinEntity> wrapper);
	
}
