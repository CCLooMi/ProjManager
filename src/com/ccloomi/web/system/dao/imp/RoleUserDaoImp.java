package com.ccloomi.web.system.dao.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
import com.ccloomi.web.system.dao.RoleUserDao;
import com.ccloomi.web.system.entity.RoleUserEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：RoleUserDaoImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午10:39:56
 */
public class RoleUserDaoImp extends AbstractBaseDao<RoleUserEntity> implements RoleUserDao{

	@Override
	public List<Object> getIdRoleByIdUser(Serializable idUser) {
		return findPropertyByProperty(RoleUserEntity.class, "idUser",idUser, "idRole");
	}

	@Override
	public List<Object> getIdUserByIdRole(Serializable idRole) {
		return findPropertyByProperty(RoleUserEntity.class, "idRole",idRole, "idUser");
	}

	@Override
	public RoleUserEntity getById(Serializable id) {
		return getById(RoleUserEntity.class, id);
	}

	@Override
	public List<RoleUserEntity> findByProperties(Map<String, Object> propertyNameValues) {
		return findByProperties(RoleUserEntity.class, propertyNameValues);
	}

	@Override
	public List<RoleUserEntity> findByProperty(String param, Object value) {
		return findByProperty(RoleUserEntity.class, param, value);
	}

	@Override
	public List<Object[]> findPropertiesByProperties(Map<String, Object> propertyNameValues, String... columnNames) {
		return findPropertiesByProperties(RoleUserEntity.class, propertyNameValues, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperties(Map<String, Object> propertyNameValues, String columnName) {
		return findPropertyByProperties(RoleUserEntity.class, propertyNameValues, columnName);
	}

	@Override
	public List<Object[]> findPropertiesByProperty(String param, Object value,String... columnNames) {
		return findPropertiesByProperty(RoleUserEntity.class, param, value, columnNames);
	}

	@Override
	public List<Object> findPropertyByProperty(String param, Object value,String columnName) {
		return findPropertyByProperty(RoleUserEntity.class, param, value, columnName);
	}

	@Override
	public Serializable selectCountByProperty(String propertyName, Object value) {
		return selectCountByProperty(RoleUserEntity.class, propertyName, value);
	}

	@Override
	public Serializable selectCountByProperties(Map<String, Object> propertyNameValues) {
		return selectCountByProperties(RoleUserEntity.class, propertyNameValues);
	}

	@Override
	public Serializable selectCount() {
		return selectCount(RoleUserEntity.class);
	}
	
}
