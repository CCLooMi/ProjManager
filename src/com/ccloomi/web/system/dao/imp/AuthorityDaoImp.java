package com.ccloomi.web.system.dao.imp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
import com.ccloomi.web.system.dao.AuthorityDao;
import com.ccloomi.web.system.entity.AuthorityEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：AuthorityDaoImp
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月5日-下午4:27:39
 */
@Service("authorityDao")
public class AuthorityDaoImp extends AbstractBaseDao<AuthorityEntity> implements AuthorityDao{
	
	@Override
	protected Class<AuthorityEntity> tClass() {
		return AuthorityEntity.class;
	}

	@Override
	public List<Map<String, Object>> getAllAuthorityVisEdges() {
		String sql="SELECT a.id AS 'from',a.idParent AS 'to' FROM sys_authority a WHERE a.idParent !=\"\"";
		return getJdbcTemplate().queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getAllAuthorityVisNodes() {
		String sql="SELECT id,name AS 'label','authority' AS 'group',url FROM sys_authority";
		return getJdbcTemplate().queryForList(sql);
	}
	
}
