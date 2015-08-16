package com.ccloomi.web.system.service;

import java.io.Serializable;

import com.ccloomi.core.common.service.BaseService;
import com.ccloomi.web.system.entity.RoleAuthorityEntity;
import com.ccloomi.web.system.entity.RoleEntity;
import com.ccloomi.web.system.entity.RoleUserEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：RoleService
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月4日-上午8:55:14
 */
public interface RoleService extends BaseService<RoleEntity>{
	/**
	 * 描述：给角色添加权限
	 * 作者：Chenxj
	 * 日期：2015年8月15日 - 下午10:14:44
	 * @param roleAuthority
	 * @return
	 */
	public Serializable addAuthority(RoleAuthorityEntity roleAuthority);
	/**
	 * 描述：指定用户角色
	 * 作者：Chenxj
	 * 日期：2015年8月15日 - 下午10:14:33
	 * @param roleUser
	 * @return
	 */
	public Serializable addUser(RoleUserEntity roleUser);
}
