package com.ccloomi.web.system.dao.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
import com.ccloomi.web.system.dao.RoleAuthorityDao;
import com.ccloomi.web.system.entity.RoleAuthorityEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：RoleAuthorityDaoImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月5日-下午4:33:06
 */
@Service("roleAuthorityDao")
public class RoleAuthorityDaoImp extends AbstractBaseDao<RoleAuthorityEntity> implements RoleAuthorityDao{

	@Override
	public RoleAuthorityEntity getById(Serializable id) {
		return getById(RoleAuthorityEntity.class, id);
	}

	@Override
	public List<RoleAuthorityEntity> findByProperties(Map<String, Object> propertyNameValues) {
		return findByProperties(RoleAuthorityEntity.class, propertyNameValues);
	}

	@Override
	public List<RoleAuthorityEntity> findByProperty(String param, Object value) {
		return findByProperty(RoleAuthorityEntity.class, param, value);
	}

	@Override
	public List<Object[]> findPropertiesByProperties(Map<String, Object> propertyNameValues, String... columnNames) {
		return findPropertiesByProperties(RoleAuthorityEntity.class, propertyNameValues, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperties(Map<String, Object> propertyNameValues, String columnName) {
		return findPropertyByProperties(RoleAuthorityEntity.class, propertyNameValues, columnName);
	}

	@Override
	public List<Object[]> findPropertiesByProperty(String param, Object value,String... columnNames) {
		return findPropertiesByProperty(RoleAuthorityEntity.class, param, value, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperty(String param, Object value,String columnName) {
		return findPropertyByProperty(RoleAuthorityEntity.class, param, value, columnName);
	}
	
}
