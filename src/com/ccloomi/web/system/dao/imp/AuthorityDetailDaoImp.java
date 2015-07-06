package com.ccloomi.web.system.dao.imp;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
import com.ccloomi.web.system.dao.AuthortyDetailDao;
import com.ccloomi.web.system.entity.AuthorityDetailEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：AuthorityDetailDaoImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月5日-下午4:30:31
 */
@Service("authorityDetailDao")
public class AuthorityDetailDaoImp extends AbstractBaseDao<AuthorityDetailEntity> implements AuthortyDetailDao{

	@Override
	protected Class<AuthorityDetailEntity> tClass() {
		return AuthorityDetailEntity.class;
	}
	
}
