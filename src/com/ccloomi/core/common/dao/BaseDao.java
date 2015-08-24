package com.ccloomi.core.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
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
	public boolean delete(Serializable id);
	public void delete(T entity);
	/**
	 * 描述：
	 * 作者：Chenxj
	 * 日期：2015年8月25日 - 上午12:01:47
	 * @param ids
	 */
	public int[] batchDelete(Collection<? extends Object>ids);
	/**
	 * 方法描述：通过ID查找
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:01:29
	 * @param id
	 * @return T
	 */
	public T getById(Serializable id);

	/**
	 * 方法描述：通过多个属性查找
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:01:51
	 * @param propertyNameValues 属性及值
	 * @return List
	 */
	public List<T> findByProperties(Map<String, Object> propertyNameValues);

	/**
	 * 方法描述：通过单个属性查找
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:02:45
	 * @param param 属性名
	 * @param value 属性值
	 * @return List
	 */
	public List<T> findByProperty(String param,Object value);

	/**
	 * 方法描述：通过Entity属性值查找（相当于in查询）
	 * 作        者：Chenxj
	 * 日        期：2015年7月7日-上午11:05:33
	 * @param entityClass
	 * @param propertyNameValues 属性及值范围
	 * @return List
	 */
	public List<T> findByPropertyInValues(Map<String,Object[]>propertyNameValues);
	
	/**
	 * 方法描述：通过Entity属性值查找（相当于in查询）
	 * 作者：Chenxj
	 * 日期：2015年7月7日 - 上午11:09:53
	 * @param propertyname 属性名
	 * @param Values 属性值集合
	 * @return List
	 */
	public List<T> findByPropertyInValues(String propertyname,Object...Values);
	
	/**
	 * 方法描述：通过Entity属性值查找（相当于in查询）
	 * 作者：Chenxj
	 * 日期：2015年7月7日 - 上午11:13:00
	 * @param propertyname 属性名
	 * @param Values 属性值集合
	 * @return List
	 */
	public List<T> findByPropertyInValues(String propertyname,Collection<Object>Values);
	/**
	 * 方法描述：通过属性及值范围查找单个属性列表
	 * 作者：Chenxj
	 * 日期：2015年7月7日 - 上午11:45:15
	 * @param propertyNameValues 属性及值集合
	 * @param columnName 要查找的属性
	 * @return List
	 */
	public List<Object>findPropertyByPropertyInValues(Map<String, Object[]>propertyNameValues,String columnName);
	/**
	 * 方法描述：通过Entity属性值查找单个属性列表（已去重）
	 * 作        者：Chenxj
	 * 日        期：2015年7月7日-下午5:51:50
	 * @param entityClass
	 * @param propertyNameValues
	 * @param columnName
	 * @return
	 */
	public List<Object>findDistinctPropertyByPropertyInValuse(Map<String, Object[]>propertyNameValues,String columnName);
	/**
	 * 方法描述：通过属性及值范围查找多个属性列表
	 * 作者：Chenxj
	 * 日期：2015年7月7日 - 上午11:45:12
	 * @param propertyNameValues 属性及值集合
	 * @param columnNames 要查找的属性集
	 * @return List
	 */
	public List<Object[]>findPropertiesByPropertyInValues(Map<String, Object[]>propertyNameValues,String...columnNames);
	/**
	 * 方法描述：通过多属性查找多个属性列表
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:03:15
	 * @param propertyNameValues 属性及值
	 * @param columnNames 要查找的列属性名列表
	 * @return List
	 */
	public List<Object[]> findPropertiesByProperties(Map<String, Object> propertyNameValues, String... columnNames);

	/**
	 * 方法描述：通过多属性查找单个属性列表
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:04:31
	 * @param propertyNameValues 属性及值
	 * @param columnName 要查找的列属性名
	 * @return List
	 */
	public List<Object> findPropertyByProperties(Map<String, Object> propertyNameValues, String columnName);

	/**
	 * 方法描述：通过单属性查找多属性列表
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:05:26
	 * @param param 属性名
	 * @param value 属性值
	 * @param columnNames 要查找的列属性名列表
	 * @return List
	 */
	public List<Object[]> findPropertiesByProperty(String param, Object value, String... columnNames);

	/**
	 * 方法描述：通过单个属性查找单个属性列表
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:06:20
	 * @param param 属性名
	 * @param value 属性值
	 * @param columnName 要查找的属性名
	 * @return List
	 */
	public List<Object> findPropertyByProperty(String param, Object value, String columnName);
	
	/**
	 * 方法描述：根据单属性查询记录条数
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:22:14
	 * @param propertyName 属性名
	 * @param value 属性值
	 * @return 记录条数
	 */
	public Serializable selectCountByProperty(String propertyName,Object value);
	/**
	 * 方法描述：更具多属性查询记录条数
	 * 作        者：Chenxj
	 * 日        期：2015年7月3日-下午6:01:11
	 * @param propertyNameValues 属性及值
	 * @return 记录条数
	 */
	public Serializable selectCountByProperties(Map<String, Object>propertyNameValues);
	/**
	 * 方法描述：查询记录条数
	 * 作        者：Chenxj
	 * 日        期：2015年7月3日-下午5:59:12
	 * @return 记录条数
	 */
	public Serializable selectCount();
	/**
	 * 描述：通过DetachedCriteria查找数据
	 * 作者：Chenxj
	 * 日期：2015年7月11日 - 下午7:01:39
	 * @param criteria
	 * @return
	 */
	public List<?> findByCriteria(DetachedCriteria criteria);
	/**
	 * 描述：通过DetachedCriteria查找数据(分页)
	 * 作者：Chenxj
	 * 日期：2015年7月11日 - 下午7:06:01
	 * @param criteria
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<?> findByCriteria(DetachedCriteria criteria,int firstResult,int maxResults);
}
