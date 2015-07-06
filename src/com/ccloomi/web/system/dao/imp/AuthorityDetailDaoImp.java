package com.ccloomi.web.system.dao.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
import com.ccloomi.web.system.dao.AuthortyDetailDao;
import com.ccloomi.web.system.entity.AuthorityDetailEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：AuthorityDetailDaoImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月5日-下午4:30:31
 */
@Service("authorityDetailDao")
public class AuthorityDetailDaoImp extends AbstractBaseDao<AuthorityDetailEntity> implements AuthortyDetailDao{

	@Override
	public AuthorityDetailEntity getById(Serializable id) {
		return getById(AuthorityDetailEntity.class, id);
	}

	@Override
	public List<AuthorityDetailEntity> findByProperties(Map<String, Object> propertyNameValues) {
		return findByProperties(AuthorityDetailEntity.class, propertyNameValues);
	}

	@Override
	public List<AuthorityDetailEntity> findByProperty(String param, Object value) {
		return findByProperty(AuthorityDetailEntity.class, param, value);
	}

	@Override
	public List<Object[]> findPropertiesByProperties(Map<String, Object> propertyNameValues, String... columnNames) {
		return findPropertiesByProperties(AuthorityDetailEntity.class, propertyNameValues, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperties(Map<String, Object> propertyNameValues, String columnName) {
		return findPropertyByProperties(AuthorityDetailEntity.class, propertyNameValues, columnName);
	}

	@Override
	public List<Object[]> findPropertiesByProperty(String param, Object value,String... columnNames) {
		return findPropertiesByProperty(AuthorityDetailEntity.class, param, value, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperty(String param, Object value,String columnName) {
		return findPropertyByProperty(AuthorityDetailEntity.class, param, value, columnName);
	}

	@Override
	public Serializable selectCountByProperty(String propertyName, Object value) {
		return selectCountByProperty(AuthorityDetailEntity.class, propertyName, value);
	}

	@Override
	public Serializable selectCountByProperties(Map<String, Object> propertyNameValues) {
		return selectCountByProperties(AuthorityDetailEntity.class, propertyNameValues);
	}

	@Override
	public Serializable selectCount() {
		return selectCount(AuthorityDetailEntity.class);
	}
	
}
