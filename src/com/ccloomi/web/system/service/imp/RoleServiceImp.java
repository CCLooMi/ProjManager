package com.ccloomi.web.system.service.imp;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.service.imp.BaseServiceImp;
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
public class RoleServiceImp extends BaseServiceImp<RoleEntity> implements RoleService{
	private RoleDao roleDao;

	/**获取 roleDao*/
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**设置 roleDao*/
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
}