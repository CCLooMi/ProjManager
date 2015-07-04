package com.ccloomi.web.system.dao;

import java.io.Serializable;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.web.system.entity.UserEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：UserDao
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午10:26:16
 */
public interface UserDao extends BaseDao<UserEntity> {
	/**
	 * 描述：通过ID查找User
	 * 作者：Chenxj
	 * 日期：2015年7月3日 - 下午10:32:25
	 * @param id
	 * @return
	 */
	public UserEntity getUserById(Serializable id);
}
