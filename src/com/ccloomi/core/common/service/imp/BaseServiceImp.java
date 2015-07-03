package com.ccloomi.core.common.service.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

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
@Transactional
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
	public T getById(Class<T> entityClass, Serializable id) {
		return this.baseDao.getById(entityClass, id);
	}

	@Override
	public List<T> findByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues) {
		return this.baseDao.findByProperties(entityClass, propertyNameValues);
	}

	@Override
	public List<T> findByProperty(Class<T> entityClass, String param,Object value) {
		return this.baseDao.findByProperty(entityClass, param, value);
	}

	@Override
	public List<Object[]> findPropertiesByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues, String... columnNames) {
		return this.baseDao.findPropertiesByProperties(entityClass, propertyNameValues, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues, String columnName) {
		return this.baseDao.findPropertyByProperties(entityClass, propertyNameValues, columnName);
	}

	@Override
	public List<Object[]> findPropertiesByProperty(Class<T> entityClass,String param, String value, String... columnNames) {
		return this.baseDao.findPropertiesByProperty(entityClass, param, value, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperty(Class<T> entityClass,String param, String value, String columnName) {
		return this.baseDao.findPropertyByProperty(entityClass, param, value, columnName);
	}
}
