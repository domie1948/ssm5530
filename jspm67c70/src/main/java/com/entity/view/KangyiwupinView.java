package com.entity.view;

import com.entity.KangyiwupinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 抗疫物品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-19 10:07:56
 */
@TableName("kangyiwupin")
public class KangyiwupinView  extends KangyiwupinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KangyiwupinView(){
	}
 
 	public KangyiwupinView(KangyiwupinEntity kangyiwupinEntity){
 	try {
			BeanUtils.copyProperties(this, kangyiwupinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
