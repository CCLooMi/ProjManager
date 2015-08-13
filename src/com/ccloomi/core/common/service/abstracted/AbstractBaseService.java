package com.ccloomi.core.common.service.abstracted;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.service.BaseService;
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
	public void delete(Serializable id){
		getDao().delete(id);
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
	public List<T> findByProperties(Map<String, Object> propertyNameValues) {
		return getDao().findByProperties(propertyNameValues);
	}

	@Override
	public List<T> findByProperty(String param, Object value) {
		return getDao().findByProperty(param, value);
	}

	@Override
	public List<Object[]> findPropertiesByProperties(Map<String, Object> propertyNameValues, String... columnNames) {
		return getDao().findPropertiesByProperties(propertyNameValues, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperties(Map<String, Object> propertyNameValues, String columnName) {
		return getDao().findPropertyByProperties(propertyNameValues, columnName);
	}

	@Override
	public List<Object[]> findPropertiesByProperty(String param, Object value,String... columnNames) {
		return getDao().findPropertiesByProperty(param, value, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperty(String param, Object value,String columnName) {
		return getDao().findPropertyByProperty(param, value, columnName);
	}

	@Override
	public Serializable selectCountByProperty(String propertyName, Object value) {
		return getDao().selectCountByProperty(propertyName, value);
	}

	@Override
	public Serializable selectCountByProperties(Map<String, Object> propertyNameValues) {
		return getDao().selectCountByProperties(propertyNameValues);
	}

	@Override
	public Serializable selectCount() {
		return getDao().selectCount();
	}
	
	
}
