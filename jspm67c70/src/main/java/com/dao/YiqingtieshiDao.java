package com.dao;

import com.entity.YiqingtieshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YiqingtieshiVO;
import com.entity.view.YiqingtieshiView;


/**
 * 疫情贴士
 * 
 * @author 
 * @email 
 * @date 2021-03-19 10:07:56
 */
public interface YiqingtieshiDao extends BaseMapper<YiqingtieshiEntity> {
	
	List<YiqingtieshiVO> selectListVO(@Param("ew") Wrapper<YiqingtieshiEntity> wrapper);
	
	YiqingtieshiVO selectVO(@Param("ew") Wrapper<YiqingtieshiEntity> wrapper);
	
	List<YiqingtieshiView> selectListView(@Param("ew") Wrapper<YiqingtieshiEntity> wrapper);

	List<YiqingtieshiView> selectListView(Pagination page,@Param("ew") Wrapper<YiqingtieshiEntity> wrapper);
	
	YiqingtieshiView selectView(@Param("ew") Wrapper<YiqingtieshiEntity> wrapper);
	
}
