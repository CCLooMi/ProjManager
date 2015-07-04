package com.ccloomi.core.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * 类名：BaseDao
 * 描述：BaseDao基础接口
 * 作者： Chenxj
 * 日期：2015年6月23日 - 下午4:12:38
 */
public interface BaseDao<T> {
	public Serializable save(T entity);
	public void update(T entity);
	public void saveOrUpdate(T entity);
	public void delete(T entity);
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
	 * @return
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
	 * @return
	 */
	public List<Object[]>findPropertiesByProperty(Class<T>entityClass,String param,Object value,String...columnNames);
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
	public List<Object>findPropertyByProperty(Class<T>entityClass,String param,Object value,String columnName);
}
