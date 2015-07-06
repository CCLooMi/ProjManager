package com.ccloomi.web.system.dao.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
import com.ccloomi.web.system.dao.UserDao;
import com.ccloomi.web.system.entity.UserEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：UserDaoImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午10:26:54
 */
public class UserDaoImp extends AbstractBaseDao<UserEntity> implements UserDao{

	@Override
	public UserEntity getById(Serializable id) {
		return getById(UserEntity.class, id);
	}

	@Override
	public List<UserEntity> findByProperties(Map<String, Object> propertyNameValues) {
		return findByProperties(UserEntity.class, propertyNameValues);
	}

	@Override
	public List<UserEntity> findByProperty(String param, Object value) {
		return findByProperty(UserEntity.class, param, value);
	}

	@Override
	public List<Object[]> findPropertiesByProperties(Map<String, Object> propertyNameValues, String... columnNames) {
		return findPropertiesByProperties(UserEntity.class, propertyNameValues, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperties(Map<String, Object> propertyNameValues, String columnName) {
		return findPropertyByProperties(UserEntity.class, propertyNameValues, columnName);
	}

	@Override
	public List<Object[]> findPropertiesByProperty(String param, Object value,String... columnNames) {
		return findPropertiesByProperty(UserEntity.class, param, value, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperty(String param, Object value,String columnName) {
		return findPropertyByProperty(UserEntity.class, param, value, columnName);
	}

	@Override
	public Serializable selectCountByProperty(String propertyName, Object value) {
		return selectCountByProperty(UserEntity.class, propertyName, value);
	}

	@Override
	public Serializable selectCountByProperties(Map<String, Object> propertyNameValues) {
		return selectCountByProperties(UserEntity.class, propertyNameValues);
	}

	@Override
	public Serializable selectCount() {
		return selectCount(UserEntity.class);
	}
	
}
