package com.ccloomi.web.system.bean;

import java.util.Map;
import java.util.Set;

import com.ccloomi.core.common.bean.BaseBean;
import com.ccloomi.web.system.entity.AuthorityEntity;
import com.ccloomi.web.system.entity.RoleAuthorityEntity;
import com.ccloomi.web.system.entity.RoleEntity;
import com.ccloomi.web.system.entity.RoleUserEntity;
import com.ccloomi.web.system.entity.UserEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：RAUvisDataBean
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月23日-下午10:56:21
 */
public class RAUvisDataBean extends BaseBean{
	private static final long serialVersionUID = -3463248907521195269L;
	
	private Map<String, Object>addSet_edge;
	private Map<String, Object>delSet_edge;
	private Map<String, Object>updSet_node;
	private Map<String, Object>delSet_node;
	
	private Set<String>delSet_roleuser;
	private Set<String>delSet_roleauthority;
	private Set<String>delSet_user;
	private Set<String>delSet_role;
	private Set<String>delSet_authority;
	
	private Set<RoleUserEntity>addSet_roleuser;
	private Set<RoleAuthorityEntity>addSet_roleauthority;
	private Set<UserEntity>addSet_user;
	private Set<RoleEntity>addSet_role;
	private Set<AuthorityEntity>addSet_authority;
	
	private Set<UserEntity>updSet_user;
	private Set<RoleEntity>updSet_role;
	private Set<AuthorityEntity>updSet_authority;
	
	/**获取 addSet_edge*/
	public Map<String, Object> getAddSet_edge() {
		return addSet_edge;
	}
	/**设置 addSet_edge*/
	public void setAddSet_edge(Map<String, Object> addSet_edge) {
		this.addSet_edge = addSet_edge;
	}
	/**获取 delSet_edge*/
	public Map<String, Object> getDelSet_edge() {
		return delSet_edge;
	}
	/**设置 delSet_edge*/
	public void setDelSet_edge(Map<String, Object> delSet_edge) {
		this.delSet_edge = delSet_edge;
	}
	/**获取 updSet_node*/
	public Map<String, Object> getUpdSet_node() {
		return updSet_node;
	}
	/**设置 updSet_node*/
	public void setUpdSet_node(Map<String, Object> updSet_node) {
		this.updSet_node = updSet_node;
	}
	/**获取 delSet_node*/
	public Map<String, Object> getDelSet_node() {
		return delSet_node;
	}
	/**设置 delSet_node*/
	public void setDelSet_node(Map<String, Object> delSet_node) {
		this.delSet_node = delSet_node;
	}
	
	//
	/**获取 delSet_roleuser*/
	public Set<String> getDelSet_roleuser() {
		return delSet_roleuser;
	}
	/**获取 delSet_roleauthority*/
	public Set<String> getDelSet_roleauthority() {
		return delSet_roleauthority;
	}
	/**获取 delSet_user*/
	public Set<String> getDelSet_user() {
		return delSet_user;
	}
	/**获取 delSet_role*/
	public Set<String> getDelSet_role() {
		return delSet_role;
	}
	/**获取 delSet_authority*/
	public Set<String> getDelSet_authority() {
		return delSet_authority;
	}
	/**获取 addSet_roleuser*/
	public Set<RoleUserEntity> getAddSet_roleuser() {
		return addSet_roleuser;
	}
	/**获取 addSet_roleauthority*/
	public Set<RoleAuthorityEntity> getAddSet_roleauthority() {
		return addSet_roleauthority;
	}
	/**获取 addSet_user*/
	public Set<UserEntity> getAddSet_user() {
		return addSet_user;
	}
	/**获取 addSet_role*/
	public Set<RoleEntity> getAddSet_role() {
		return addSet_role;
	}
	/**获取 addSet_authority*/
	public Set<AuthorityEntity> getAddSet_authority() {
		return addSet_authority;
	}
	/**获取 updSet_user*/
	public Set<UserEntity> getUpdSet_user() {
		return updSet_user;
	}
	/**获取 updSet_role*/
	public Set<RoleEntity> getUpdSet_role() {
		return updSet_role;
	}
	/**获取 updSet_authority*/
	public Set<AuthorityEntity> getUpdSet_authority() {
		return updSet_authority;
	}
}
