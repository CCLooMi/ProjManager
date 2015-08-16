package com.ccloomi.web.system.service.imp;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.service.abstracted.AbstractBaseService;
import com.ccloomi.web.system.dao.RoleAuthorityDao;
import com.ccloomi.web.system.dao.RoleDao;
import com.ccloomi.web.system.dao.RoleUserDao;
import com.ccloomi.web.system.entity.RoleAuthorityEntity;
import com.ccloomi.web.system.entity.RoleEntity;
import com.ccloomi.web.system.entity.RoleUserEntity;
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
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleUserDao roleUserDao;
	@Autowired
	private RoleAuthorityDao roleAuthorityDao;
	
	@Override
	protected BaseDao<RoleEntity> getDao() {
		return getRoleDao();
	}

	@Override
	public Serializable addAuthority(RoleAuthorityEntity roleAuthority) {
		return roleAuthorityDao.save(roleAuthority);
	}

	@Override
	public Serializable addUser(RoleUserEntity roleUser) {
		return roleUserDao.save(roleUser);
	}
	
	/**获取 roleDao*/
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**设置 roleDao*/
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**获取 roleUserDao*/
	public RoleUserDao getRoleUserDao() {
		return roleUserDao;
	}

	/**设置 roleUserDao*/
	public void setRoleUserDao(RoleUserDao roleUserDao) {
		this.roleUserDao = roleUserDao;
	}

	/**获取 roleAuthorityDao*/
	public RoleAuthorityDao getRoleAuthorityDao() {
		return roleAuthorityDao;
	}

	/**设置 roleAuthorityDao*/
	public void setRoleAuthorityDao(RoleAuthorityDao roleAuthorityDao) {
		this.roleAuthorityDao = roleAuthorityDao;
	}
}
