package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YiqingtieshiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YiqingtieshiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YiqingtieshiView;


/**
 * 疫情贴士
 *
 * @author 
 * @email 
 * @date 2021-03-19 10:07:56
 */
public interface YiqingtieshiService extends IService<YiqingtieshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YiqingtieshiVO> selectListVO(Wrapper<YiqingtieshiEntity> wrapper);
   	
   	YiqingtieshiVO selectVO(@Param("ew") Wrapper<YiqingtieshiEntity> wrapper);
   	
   	List<YiqingtieshiView> selectListView(Wrapper<YiqingtieshiEntity> wrapper);
   	
   	YiqingtieshiView selectView(@Param("ew") Wrapper<YiqingtieshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YiqingtieshiEntity> wrapper);
   	
}

