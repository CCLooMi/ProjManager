package com.ccloomi.core.common.service.abstracted;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.service.BaseService;
import com.ccloomi.core.common.sql.SQLGod;
@Transactional
public abstract class AbstractBaseService<T> implements BaseService<T>{
	protected final Logger log=LoggerFactory.getLogger(this.getClass());
	
	protected abstract BaseDao<T> getDao();
	
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
	public List<Map<String, Object>>findBySQLGod(SQLGod sg){
		return getDao().findBySQLGod(sg);
	}
}
