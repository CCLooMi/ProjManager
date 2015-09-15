package com.ccloomi.core.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.ccloomi.core.common.sql.SQLGod;
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
	public int insert(T entity);
	/**
	 * 描述：批量删除
	 * 作者：Chenxj
	 * 日期：2015年8月25日 - 上午12:01:47
	 * @param ids
	 */
	public int[] batchDelete(Collection<? extends Object>ids);
	/**
	 * 描述：批量添加
	 * 作者：Chenxj
	 * 日期：2015年8月25日 - 下午10:12:05
	 * @param entitys
	 * @return
	 */
	public List<Serializable> batchSave(Collection<T>entitys);
	/**
	 * 描述：批量更新
	 * 作者：Chenxj
	 * 日期：2015年8月25日 - 下午10:26:24
	 * @param entitys
	 */
	public void batchUpdate(Collection<T>entitys);
	/**
	 * 描述：批量添加或更新
	 * 作者：Chenxj
	 * 日期：2015年8月25日 - 下午10:25:20
	 * @param entitys
	 */
	public void batchSaveOrUpdate(Collection<T>entitys);
	/**
	 * 方法描述：通过ID查找
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午10:01:29
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
