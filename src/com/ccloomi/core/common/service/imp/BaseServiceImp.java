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
	public List<T> findByProperties(Class<T> entityClass, String[] params,Object[] values) {
		return this.baseDao.findByProperties(entityClass, params, values);
	}

	@Override
	public List<T> findByProperties(Class<T> entityClass,Map<String, Object> map) {
		return this.baseDao.findByProperties(entityClass, map);
	}
	
}
