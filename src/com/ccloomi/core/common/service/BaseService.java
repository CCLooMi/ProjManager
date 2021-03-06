package com.ccloomi.core.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ccloomi.core.common.sql.SQLGod;

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
	public boolean delete(Serializable id);
	public void delete(T entity);
	public int insert(T entity);
	/**
	 * 方法描述：通过ID查找
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:07:01
	 * @param id
	 * @return T
	 */
	public T getById(Serializable id);
	/**
	 * 方法描述：
	 * 作者：Chenxj
	 * 日期：2015年8月28日 - 上午8:53:33
	 * @param sg
	 * @return
	 */
	public int updateBySQLGod(SQLGod sg);
	/**
	 * 方法描述：
	 * 作者：Chenxj
	 * 日期：2015年8月28日 - 上午8:53:29
	 * @param sg
	 * @return
	 */
	public int[] batchUpdateBySQLGod(SQLGod sg);
	/**
	 * 方法描述：
	 * 作者：Chenxj
	 * 日期：2015年8月28日 - 上午8:53:38
	 * @param sg
	 * @return
	 */
	public List<Map<String, Object>>findBySQLGod(SQLGod sg);
}
