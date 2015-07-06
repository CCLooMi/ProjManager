package com.ccloomi.web.system.dao.imp;

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
	protected Class<RoleAuthorityEntity> tClass() {
		return RoleAuthorityEntity.class;
	}
	
}
