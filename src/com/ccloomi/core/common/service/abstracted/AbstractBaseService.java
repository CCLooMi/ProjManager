package com.ccloomi.core.common.service.abstracted;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.service.BaseService;

public abstract class AbstractBaseService<T> implements BaseService<T>{
	protected final Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BaseDao<T> baseDao;

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public Serializable save(T entity) {
		return getBaseDao().save(entity);
	}

	@Override
	public void update(T entity) {
		getBaseDao().update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getBaseDao().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		getBaseDao().delete(entity);
	}
}
