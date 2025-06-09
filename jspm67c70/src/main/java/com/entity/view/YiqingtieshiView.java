package com.entity.view;

import com.entity.YiqingtieshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 疫情贴士
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-19 10:07:56
 */
@TableName("yiqingtieshi")
public class YiqingtieshiView  extends YiqingtieshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YiqingtieshiView(){
	}
 
 	public YiqingtieshiView(YiqingtieshiEntity yiqingtieshiEntity){
 	try {
			BeanUtils.copyProperties(this, yiqingtieshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
