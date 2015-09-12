package com.ccloomi.web.system.service.imp;

import java.util.ArrayList;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccloomi.core.annotation.Cacheable;
import com.ccloomi.core.common.bean.VisData;
import com.ccloomi.core.common.sql.imp.SQLMaker;
import com.ccloomi.web.system.bean.RAUvisDataBean;
import com.ccloomi.web.system.dao.AuthorityDao;
import com.ccloomi.web.system.dao.RoleAuthorityDao;
import com.ccloomi.web.system.dao.RoleDao;
import com.ccloomi.web.system.dao.RoleUserDao;
import com.ccloomi.web.system.dao.UserDao;
import com.ccloomi.web.system.entity.AuthorityEntity;
import com.ccloomi.web.system.service.VisService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：VisServiceImp
 * 类 描 述：VIS服务接口实现
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月1日-下午12:21:43
 */
@Service("visService")
@Transactional
public class VisServiceImp implements VisService{
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private AuthorityDao authorityDao;
	@Autowired
	private RoleUserDao roleUserDao;
	@Autowired
	private RoleAuthorityDao roleAuthorityDao;
	
	@Override
	@Cacheable
	public VisData getAllRAUvisData() {
		VisData vd=new VisData();
		//添加Nodes
		vd.addNodes(userDao.getAllUserVisNodes());
		vd.addNodes(roleDao.getAllRoleVisNodes());
		vd.addNodes(authorityDao.getAllAuthorityVisNodes());
		//添加Edges
		vd.addEdges(roleUserDao.getAllRoleUserVisEdges());
		vd.addEdges(roleAuthorityDao.getAllRoleAuthorityVisEdges());
		vd.addEdges(authorityDao.getAllAuthorityVisEdges());
		return vd;
	}
	
	@Override
	public boolean saveRAUvisData(RAUvisDataBean rauVisData) {
		//1.删除关联
		roleAuthorityDao.batchDelete(rauVisData.getDelSet_roleauthority());
		roleUserDao.batchDelete(rauVisData.getDelSet_roleuser());
		authorityDao.batchDeletePid(rauVisData.getDelSet_authorityPid());
		//2.删除节点
		userDao.batchDelete(rauVisData.getDelSet_user());
		roleDao.batchDelete(rauVisData.getDelSet_role());
		authorityDao.batchDelete(rauVisData.getDelSet_authority());
		//3.添加关联
		authorityDao.batchAddPid(rauVisData.getAddSet_authorityPid());
		roleAuthorityDao.batchSave(rauVisData.getAddSet_roleauthority());
		roleUserDao.batchSave(rauVisData.getAddSet_roleuser());
		//4.更新节点
		
		SQLMaker sm=new SQLMaker();
		sm.UPDATE(new AuthorityEntity(), "a")
			.SET("a.name=?", "")
			.SET("a.url=?", "")
			.WHERE("a.id=?", "")
			.setBatchArgs(new ArrayList<Object[]>());
		Set<AuthorityEntity>authorities=rauVisData.getUpdSet_authority();
		for(AuthorityEntity authority:authorities){
			Object[]args={authority.getName(),authority.getUrl(),authority.getId()};
			sm.getBatchArgs().add(args);
		}
		authorityDao.batchUpdateBySQLGod(sm);
		roleDao.batchUpdate(rauVisData.getUpdSet_role());
		userDao.batchUpdate(rauVisData.getUpdSet_user());
		return true;
	}
	
	/**获取 roleDao*/
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**设置 roleDao*/
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**获取 authorityDao*/
	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	/**设置 authorityDao*/
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	/**获取 userDao*/
	public UserDao getUserDao() {
		return userDao;
	}

	/**设置 userDao*/
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**获取 roleUserDao*/
	public RoleUserDao getRoleUserDao() {
		return roleUserDao;
	}

	/**设置 roleUserDao*/
	public void setRoleUserDao(RoleUserDao roleUserDao) {
		this.roleUserDao = roleUserDao;
	}

	/**获取 roleAuthorityDao*/
	public RoleAuthorityDao getRoleAuthorityDao() {
		return roleAuthorityDao;
	}

	/**设置 roleAuthorityDao*/
	public void setRoleAuthorityDao(RoleAuthorityDao roleAuthorityDao) {
		this.roleAuthorityDao = roleAuthorityDao;
	}
}
