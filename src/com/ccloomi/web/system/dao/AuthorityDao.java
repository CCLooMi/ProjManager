package com.ccloomi.web.system.dao;

import java.util.List;
import java.util.Map;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.web.system.entity.AuthorityEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：AuthorityDao
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月5日-下午4:26:52
 */
public interface AuthorityDao extends BaseDao<AuthorityEntity>{
	/**
	 * 描述：获取所有权限VisEdges
	 * 作者：Chenxj
	 * 日期：2015年8月1日 - 下午1:36:38
	 * @return
	 */
	public List<Map<String, Object>>getAllAuthorityVisEdges();
	/**
	 * 描述：获取所有权限VisNodes
	 * 作者：Chenxj
	 * 日期：2015年8月1日 - 下午1:41:19
	 * @return
	 */
	public List<Map<String, Object>>getAllAuthorityVisNodes();
}
