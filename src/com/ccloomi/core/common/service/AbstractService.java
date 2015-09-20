package com.ccloomi.core.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.sql.SQLGod;
/**
 * © 2015-2015 CCLooMi.Inc Copyright
 * 类    名：AbstractService
 * 类 描 述：抽象服务类
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年9月20日-下午5:44:31
 * @param <T>
 */
@Transactional
public abstract class AbstractService<T> implements BaseService<T>{
	protected final Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BaseDao<T> baseDao;
	
	protected BaseDao<T> getDao(){
		return baseDao;
	}
	
	@Override
	public Serializable save(T entity) {
		return getDao().save(entity);
	}

	@Override
	public void update(T entity) {
		getDao().update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getDao().saveOrUpdate(entity);
	}
	@Override
	public boolean delete(Serializable id){
		return getDao().delete(id);
	}
	@Override
	public int insert(T entity){
		return getDao().insert(entity);
	}
	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public T getById(Serializable id) {
		return getDao().getById(id);
	}

	@Override
	public int updateBySQLGod(SQLGod sg){
		return getDao().updateBySQLGod(sg);
	}
	@Override
	public int[] batchUpdateBySQLGod(SQLGod sg){
		return getDao().batchUpdateBySQLGod(sg);
	}
	@Override
	public List<Map<String, Object>>findBySQLGod(SQLGod sg){
		return getDao().findBySQLGod(sg);
	}
}
