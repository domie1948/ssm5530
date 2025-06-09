package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KangyiwupinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KangyiwupinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KangyiwupinView;


/**
 * 抗疫物品
 *
 * @author 
 * @email 
 * @date 2021-03-19 10:07:56
 */
public interface KangyiwupinService extends IService<KangyiwupinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KangyiwupinVO> selectListVO(Wrapper<KangyiwupinEntity> wrapper);
   	
   	KangyiwupinVO selectVO(@Param("ew") Wrapper<KangyiwupinEntity> wrapper);
   	
   	List<KangyiwupinView> selectListView(Wrapper<KangyiwupinEntity> wrapper);
   	
   	KangyiwupinView selectView(@Param("ew") Wrapper<KangyiwupinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KangyiwupinEntity> wrapper);
   	
}

