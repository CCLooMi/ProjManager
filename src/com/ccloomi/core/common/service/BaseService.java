package com.ccloomi.core.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 类名：BaseService
 * 描述：基础服务接口
 * 作者： Chenxj
 * 日期：2015年6月23日 - 下午4:19:03
 */
public interface BaseService<T> {
	public T getById(Class<T> entityClass,Serializable id);
	/**
	 * 方法描述：通过Entity属性查找
	 * 作        者：Chenxj
	 * 日        期：2015年7月3日-上午10:54:21
	 * @param entityClass
	 * @param params 属性列表
	 * @param values 属性值列表
	 * @return
	 */
	public List<T> findByProperties(Class<T>entityClass,String[]params,Object[]values);
	/**
	 * 方法描述：通过Entity属性查找,map中的key为entity属性名，value为对应的属性值
	 * 作        者：Chenxj
	 * 日        期：2015年7月3日-上午10:54:55
	 * @param entityClass
	 * @param map
	 * @return
	 */
	public List<T> findByProperties(Class<T>entityClass,Map<String, Object>map);
}
