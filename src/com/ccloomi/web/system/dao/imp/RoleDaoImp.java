package com.ccloomi.web.system.dao.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
import com.ccloomi.web.system.dao.RoleDao;
import com.ccloomi.web.system.entity.RoleEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：RoleDaoImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午11:16:35
 */
@Service("roleDao")
public class RoleDaoImp extends AbstractBaseDao<RoleEntity> implements RoleDao{

	@Override
	public RoleEntity getById(Serializable id) {
		return getById(RoleEntity.class, id);
	}

	@Override
	public List<RoleEntity> findByProperties(Map<String, Object> propertyNameValues) {
		return findByProperties(RoleEntity.class, propertyNameValues);
	}

	@Override
	public List<RoleEntity> findByProperty(String param, Object value) {
		return findByProperty(RoleEntity.class, param, value);
	}

	@Override
	public List<Object[]> findPropertiesByProperties(Map<String, Object> propertyNameValues, String... columnNames) {
		return findPropertiesByProperties(RoleEntity.class, propertyNameValues, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperties(Map<String, Object> propertyNameValues, String columnName) {
		return findPropertyByProperties(RoleEntity.class, propertyNameValues, columnName);
	}

	@Override
	public List<Object[]> findPropertiesByProperty(String param, Object value,String... columnNames) {
		return findPropertiesByProperty(RoleEntity.class, param, value, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperty(String param, Object value,String columnName) {
		return findPropertyByProperty(RoleEntity.class, param, value, columnName);
	}

	@Override
	public Serializable selectCountByProperty(String propertyName, Object value) {
		return selectCountByProperty(RoleEntity.class, propertyName, value);
	}

	@Override
	public Serializable selectCountByProperties(Map<String, Object> propertyNameValues) {
		return selectCountByProperties(RoleEntity.class, propertyNameValues);
	}

	@Override
	public Serializable selectCount() {
		return selectCount(RoleEntity.class);
	}
	
}
