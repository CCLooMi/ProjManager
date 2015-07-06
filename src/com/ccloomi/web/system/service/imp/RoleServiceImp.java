package com.ccloomi.web.system.service.imp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.service.abstracted.AbstractBaseService;
import com.ccloomi.web.system.dao.RoleDao;
import com.ccloomi.web.system.entity.RoleEntity;
import com.ccloomi.web.system.service.RoleService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：RoleServiceImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月4日-上午8:55:45
 */
@Service("roleService")
public class RoleServiceImp extends AbstractBaseService<RoleEntity> implements RoleService{
	private RoleDao roleDao;

	/**获取 roleDao*/
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**设置 roleDao*/
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public RoleEntity getById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleEntity> findByProperties(
			Map<String, Object> propertyNameValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleEntity> findByProperty(String param, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> findPropertiesByProperties(
			Map<String, Object> propertyNameValues, String... columnNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findPropertyByProperties(
			Map<String, Object> propertyNameValues, String columnName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> findPropertiesByProperty(String param, Object value,
			String... columnNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> findPropertyByProperty(String param, Object value,
			String columnName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
