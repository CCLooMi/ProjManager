package com.ccloomi.core.common.service.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.service.BaseService;
/**
 * 类名：BaseServiceImp
 * 描述：基础服务实现类
 * 作者： Chenxj
 * 日期：2015年6月23日 - 下午4:20:02
 */
@Service("baseService")
public class BaseServiceImp<T> implements BaseService<T>{
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
	
	@Override
	public T getById(Class<T> entityClass, Serializable id) {
		return getBaseDao().getById(entityClass, id);
	}

	@Override
	public List<T> findByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues) {
		return getBaseDao().findByProperties(entityClass, propertyNameValues);
	}

	@Override
	public List<T> findByProperty(Class<T> entityClass, String param,Object value) {
		return getBaseDao().findByProperty(entityClass, param, value);
	}

	@Override
	public List<Object[]> findPropertiesByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues, String... columnNames) {
		return getBaseDao().findPropertiesByProperties(entityClass, propertyNameValues, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues, String columnName) {
		return getBaseDao().findPropertyByProperties(entityClass, propertyNameValues, columnName);
	}

	@Override
	public List<Object[]> findPropertiesByProperty(Class<T> entityClass,String param, Object value, String... columnNames) {
		return getBaseDao().findPropertiesByProperty(entityClass, param, value, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperty(Class<T> entityClass,String param, Object value, String columnName) {
		return getBaseDao().findPropertyByProperty(entityClass, param, value, columnName);
	}
}
