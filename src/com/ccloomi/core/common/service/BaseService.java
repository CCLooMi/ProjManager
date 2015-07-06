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
	public Serializable save(T entity);
	public void update(T entity);
	public void saveOrUpdate(T entity);
	public void delete(T entity);
	

	/**
	 * 方法描述：通过ID查找
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:07:01
	 * @param id
	 * @return T
	 */
	public abstract T getById(Serializable id);

	/**
	 * 方法描述：通过多个属性查找
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:07:04
	 * @param propertyNameValues 属性及值
	 * @return List
	 */
	public abstract List<T> findByProperties(Map<String, Object> propertyNameValues);

	/**
	 * 方法描述：通过单个属性查找
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:07:14
	 * @param param 属性名
	 * @param value 属性值
	 * @return List
	 */
	public abstract List<T> findByProperty(String param,Object value);

	/**
	 * 方法描述：通过多属性查找多个属性列表
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:07:12
	 * @param propertyNameValues 属性及值
	 * @param columnNames 要查找的列属性名列表
	 * @return List
	 */
	public abstract List<Object[]> findPropertiesByProperties(Map<String, Object> propertyNameValues, String... columnNames);

	/**
	 * 方法描述：通过多属性查找单个属性列表
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:07:10
	 * @param propertyNameValues 属性及值
	 * @param columnName 要查找的属性名
	 * @return List
	 */
	public abstract List<Object> findPropertyByProperties(Map<String, Object> propertyNameValues, String columnName);

	/**
	 * 方法描述：通过单属性查找多属性列表
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:07:08
	 * @param param 属性名
	 * @param value 属性值
	 * @param columnNames 要查找的列属性名列表
	 * @return List
	 */
	public abstract List<Object[]> findPropertiesByProperty(String param, Object value, String... columnNames);

	/**
	 * 方法描述：通过单个属性查找单个属性列表
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:07:06
	 * @param param 属性名
	 * @param value 属性值
	 * @param columnName 要查找的属性名
	 * @return List
	 */
	public abstract List<Object> findPropertyByProperty(String param, Object value, String columnName);
}
