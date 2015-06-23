package com.ccloomi.core.common.dao;

import java.io.Serializable;
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
}
