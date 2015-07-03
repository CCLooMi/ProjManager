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
	 * 日        期：2015年7月3日-上午11:06:00
	 * @param entityClass
	 * @param map
	 * @return EntityList
	 */
	public List<T> findByProperties(Class<T>entityClass,Map<String, Object>propertyNameValues);
	/**
	 * 方法描述：通过Entity属性查找
	 * 作        者：Chenxj
	 * 日        期：2015年7月3日-上午11:18:12
	 * @param entityClass
	 * @param param Entity属性
	 * @param value Entity属性值
	 * @return EntityList
	 */
	public List<T> findByProperty(Class<T>entityClass,String param,Object value);
	/**
	 * 方法描述：通过多个属性查找多个属性列表
	 * 作        者：Chenxj
	 * 日        期：2015年7月3日-上午11:59:03
	 * @param entityClass
	 * @param propertyNameValues
	 * @param columnNames
	 * @return 当返回结果只有一条时返回List<Object>，有多条时返回List<Object[]>
	 */
	public List<Object[]>findPropertiesByProperties(Class<T>entityClass,Map<String, Object>propertyNameValues,String...columnNames);
	/**
	 * 方法描述：通过多个属性查找单个属性列表
	 * 作        者：Chenxj
	 * 日        期：2015年7月3日-上午11:59:25
	 * @param entityClass
	 * @param propertyNameValues
	 * @param columnNames
	 * @return
	 */
	public List<Object>findPropertyByProperties(Class<T>entityClass,Map<String, Object>propertyNameValues,String columnName);
	/**
	 * 方法描述：通过单个出现查找多个属性列表
	 * 作        者：Chenxj
	 * 日        期：2015年7月3日-上午11:59:43
	 * @param entityClass
	 * @param param
	 * @param value
	 * @param columnNames
	 * @return 当返回结果只有一条时返回List<Object>，有多条时返回List<Object[]>
	 */
	public List<Object[]>findPropertiesByProperty(Class<T>entityClass,String param,String value,String...columnNames);
	/**
	 * 方法描述：通过单个属性查找单个属性列表
	 * 作        者：Chenxj
	 * 日        期：2015年7月3日-下午12:00:00
	 * @param entityClass
	 * @param param
	 * @param value
	 * @param columnName
	 * @return
	 */
	public List<Object>findPropertyByProperty(Class<T>entityClass,String param,String value,String columnName);
}
