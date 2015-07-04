package com.ccloomi.web.system.dao.imp;

import java.io.Serializable;
import java.util.List;

import com.ccloomi.core.common.dao.imp.BaseDaoImp;
import com.ccloomi.web.system.dao.RoleUserDao;
import com.ccloomi.web.system.entity.RoleUserEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：RoleUserDaoImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午10:39:56
 */
public class RoleUserDaoImp extends BaseDaoImp<RoleUserEntity> implements RoleUserDao{

	@Override
	public List<Object> getIdRoleByIdUser(Serializable idUser) {
		return findPropertyByProperty(RoleUserEntity.class, "idUser",idUser, "idRole");
	}

	@Override
	public List<Object> getIdUserByIdRole(Serializable idRole) {
		return findPropertyByProperty(RoleUserEntity.class, "idRole",idRole, "idUser");
	}
	
}
