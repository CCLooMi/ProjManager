package com.ccloomi.web.system.dao.imp;

import java.io.Serializable;

import com.ccloomi.core.common.dao.imp.BaseDaoImp;
import com.ccloomi.web.system.dao.UserDao;
import com.ccloomi.web.system.entity.UserEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：UserDaoImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午10:26:54
 */
public class UserDaoImp extends BaseDaoImp<UserEntity> implements UserDao{

	@Override
	public UserEntity getUserById(Serializable id) {
		return getById(UserEntity.class, id);
	}
}
