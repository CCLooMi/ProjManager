package com.ccloomi.web.system.dao.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
import com.ccloomi.web.system.dao.AuthorityDao;
import com.ccloomi.web.system.entity.AuthorityEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：AuthorityDaoImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月5日-下午4:27:39
 */
@Service("authorityDao")
public class AuthorityDaoImp extends AbstractBaseDao<AuthorityEntity> implements AuthorityDao{

	@Override
	public AuthorityEntity getById(Serializable id) {
		return getById(AuthorityEntity.class, id);
	}

	@Override
	public List<AuthorityEntity> findByProperties(Map<String, Object> propertyNameValues) {
		return findByProperties(AuthorityEntity.class, propertyNameValues);
	}

	@Override
	public List<AuthorityEntity> findByProperty(String param, Object value) {
		return findByProperty(AuthorityEntity.class, param, value);
	}

	@Override
	public List<Object[]> findPropertiesByProperties(Map<String, Object> propertyNameValues, String... columnNames) {
		return findPropertiesByProperties(AuthorityEntity.class, propertyNameValues, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperties(Map<String, Object> propertyNameValues, String columnName) {
		return findPropertyByProperties(AuthorityEntity.class, propertyNameValues, columnName);
	}

	@Override
	public List<Object[]> findPropertiesByProperty(String param, Object value,String... columnNames) {
		return findPropertiesByProperty(AuthorityEntity.class, param, value, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperty(String param, Object value,String columnName) {
		return findPropertyByProperty(AuthorityEntity.class, param, value, columnName);
	}
	
}
