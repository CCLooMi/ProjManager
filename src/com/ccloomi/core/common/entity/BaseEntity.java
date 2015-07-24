package com.ccloomi.core.common.entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.MappedSuperclass;

import com.ccloomi.core.common.bean.BaseBean;
import com.ccloomi.core.common.exception.PropertyNotExistInEntityException;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：BaseEntity
 * 类 描 述：抽象基础实体
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月15日-下午8:24:32
 */
public abstract class BaseEntity extends BaseBean{
	private static final long serialVersionUID = 4195520472702749062L;
	private List<String>propertiesA=new ArrayList<String>();
	private List<String>propertiesV=new ArrayList<String>();
	private Map<String, String>propertiesMap=new HashMap<String, String>();
	public BaseEntity() {
		findAllProperties(getClass());
		Collections.reverse(propertiesA);
	}
	/**
	 * 方法描述：通过名称查找
	 * 作者：Chenxj
	 * 日期：2015年7月24日 - 下午2:58:00
	 * @param name
	 * @return
	 */
	public String getProperty(String name){
//		return getProperty(getClass(), name);
		if(propertiesMap.containsKey(name)){
			return propertiesMap.get(name);
		}else{
			throw new PropertyNotExistInEntityException("在"+getClass().getName()+"找不到属性："+name);
		}
	}
	/**
	 * 方法描述：从最顶层开始查找
	 * 作者：Chenxj
	 * 日期：2015年7月24日 - 下午2:57:03
	 * @param index
	 * @return
	 */
	public String getPropertyA(int index){
		return propertiesA.get(index);
	}
	/**
	 * 方法描述：从本实体开始向上查找
	 * 作者：Chenxj
	 * 日期：2015年7月24日 - 下午2:57:08
	 * @param index
	 * @return
	 */
	public String getPropertyV(int index){
		return propertiesV.get(index);
	}
//	private String getProperty(Class<?>c,String name){
//		String pname=null;
//		try {
//			pname=c.getDeclaredField(name).getName();
//		} catch (NoSuchFieldException e) {
//			if(superClassHasMappedSuperclassAnnotation(c)){
//				pname=getProperty(c.getSuperclass(), name);
//			}else{
//				throw new PropertyNotExistInEntityException("在"+getClass().getName()+"找不到属性："+name);
//			}
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}
//		return pname;
//	}
	private void findAllProperties(Class<?>c){
		Field[]fields=c.getDeclaredFields();
		int l=fields.length;
		for(Field f:fields){
			propertiesV.add(f.getName());
			propertiesA.add(fields[--l].getName());
			propertiesMap.put(f.getName(),f.getName());
		}
		if(superClassHasMappedSuperclassAnnotation(c)){
			findAllProperties(c.getSuperclass());
		}
	}
	private boolean superClassHasMappedSuperclassAnnotation(Class<?>c){
		return c.getSuperclass().getDeclaredAnnotation(MappedSuperclass.class)==null?false:true;
	}
}
