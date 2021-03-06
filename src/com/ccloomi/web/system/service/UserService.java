package com.ccloomi.web.system.service;

import java.io.Serializable;

import com.ccloomi.core.common.service.BaseService;
import com.ccloomi.web.system.entity.UserEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：UserService
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午10:33:45
 */
public interface UserService extends BaseService<UserEntity> {
	/**
	 * 描述：注册用户
	 * 作者：Chenxj
	 * 日期：2015年7月3日 - 下午10:37:19
	 * @param user
	 * @return
	 */
	public Serializable registUser(UserEntity user);
	/**
	 * 描述：检查用户名密码
	 * 作者：Chenxj
	 * 日期：2015年7月12日 - 下午9:19:09
	 * @param username
	 * @param password
	 * @return
	 */
	public Serializable checkUser(String username,String password);
}
