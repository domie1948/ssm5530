package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusskangyiwupinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusskangyiwupinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusskangyiwupinView;


/**
 * 抗疫物品评论表
 *
 * @author 
 * @email 
 * @date 2021-03-19 10:07:56
 */
public interface DiscusskangyiwupinService extends IService<DiscusskangyiwupinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusskangyiwupinVO> selectListVO(Wrapper<DiscusskangyiwupinEntity> wrapper);
   	
   	DiscusskangyiwupinVO selectVO(@Param("ew") Wrapper<DiscusskangyiwupinEntity> wrapper);
   	
   	List<DiscusskangyiwupinView> selectListView(Wrapper<DiscusskangyiwupinEntity> wrapper);
   	
   	DiscusskangyiwupinView selectView(@Param("ew") Wrapper<DiscusskangyiwupinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusskangyiwupinEntity> wrapper);
   	
}

