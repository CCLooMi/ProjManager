package com.ccloomi.web.system.bean;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.ccloomi.core.common.bean.BaseBean;
import com.ccloomi.core.component.security.SecretUtil;
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
	
	private Map<String, String>addSet_edge;
	private Map<String, String>delSet_edge;
	private Map<String, Map<String, String>>updSet_node;
	private Map<String, String>delSet_node;
	
	//|******************************************************************
	
	private Set<String>delSet_roleuser=new HashSet<String>();
	private Set<String>delSet_roleauthority=new HashSet<String>();
	private Set<String>delSet_user=new HashSet<String>();
	private Set<String>delSet_role=new HashSet<String>();
	private Set<String>delSet_authority=new HashSet<String>();
	
	private Set<RoleUserEntity>addSet_roleuser=new HashSet<RoleUserEntity>();
	private Set<RoleAuthorityEntity>addSet_roleauthority=new HashSet<RoleAuthorityEntity>();
	private Set<UserEntity>addSet_user=new HashSet<UserEntity>();
	private Set<RoleEntity>addSet_role=new HashSet<RoleEntity>();
	private Set<AuthorityEntity>addSet_authority=new HashSet<AuthorityEntity>();
	
	private Set<UserEntity>updSet_user=new HashSet<UserEntity>();
	private Set<RoleEntity>updSet_role=new HashSet<RoleEntity>();
	private Set<AuthorityEntity>updSet_authority=new HashSet<AuthorityEntity>();
	
	/**获取 addSet_edge*/
	public Map<String, String> getAddSet_edge() {
		return addSet_edge;
	}
	/**设置 addSet_edge*/
	public void setAddSet_edge(Map<String, String> addSet_edge) {
		this.addSet_edge = addSet_edge;
		for(String key:addSet_edge.keySet()){
			String[]vs=key.split("#");
			String value=addSet_edge.get(key);
			if("roleuser".equals(value)){
				RoleUserEntity roleuser=new RoleUserEntity();
				roleuser.setIdUser(vs[0]);
				roleuser.setIdRole(vs[1]);
				addSet_roleuser.add(roleuser);
			}else if("roleauthority".equals(value)){
				RoleAuthorityEntity roleauthority=new RoleAuthorityEntity();
				roleauthority.setIdAuthority(vs[0]);
				roleauthority.setIdRole(vs[1]);
				addSet_roleauthority.add(roleauthority);
			}else if("authority".equals(value)){
				AuthorityEntity authority=new AuthorityEntity();
				authority.setId(vs[0]);
				authority.setIdParent(vs[1]);
				updSet_authority.add(authority);
			}
		}
	}
	/**获取 delSet_edge*/
	public Map<String, String> getDelSet_edge() {
		return delSet_edge;
	}
	/**设置 delSet_edge*/
	public void setDelSet_edge(Map<String, String> delSet_edge) {
		this.delSet_edge = delSet_edge;
		for(String key:delSet_edge.keySet()){
			String value=delSet_edge.get(key);
			if("authority".equals(value)){
				String id=key.split("#")[0];
				delSet_authority.add(id);
			}else{
				String[] vs=value.split("#");
				String id=vs[0];
				if("roleuser".equals(vs[1])){
					delSet_roleuser.add(id);
				}else if("roleauthority".equals(vs[1])){
					delSet_roleauthority.add(id);
				}
			}
		}
	}
	/**获取 updSet_node*/
	public Map<String, Map<String, String>> getUpdSet_node() {
		return updSet_node;
	}
	/**设置 updSet_node*/
	public void setUpdSet_node(Map<String, Map<String, String>> updSet_node) {
		this.updSet_node = updSet_node;
		for(String key:updSet_node.keySet()){
			Map<String, String> node=updSet_node.get(key);
			if("user".equals(node.get("group"))){
				UserEntity user=new UserEntity();
				user.setId(node.get("id"));
				user.setNickname(node.get("nickname"));
				user.setPassword(SecretUtil.MD5(node.get("password")));
				user.setUsername(node.get("username"));
				updSet_user.add(user);
			}else if("role".equals(node.get("group"))){
				RoleEntity role=new RoleEntity();
				role.setId(node.get("id"));
				role.setName(node.get("name"));
				updSet_role.add(role);
			}else if("authority".equals(node.get("group"))){
				AuthorityEntity authority=new AuthorityEntity();
				authority.setId(node.get("id"));
				authority.setName(node.get("name"));
				authority.setUrl(node.get("url"));
				updSet_authority.add(authority);
			}
		}
	}
	/**获取 delSet_node*/
	public Map<String, String> getDelSet_node() {
		return delSet_node;
	}
	/**设置 delSet_node*/
	public void setDelSet_node(Map<String, String> delSet_node) {
		this.delSet_node = delSet_node;
		for(String key:delSet_node.keySet()){
			String value=delSet_node.get(key);
			if("authority".equals(value)){
				delSet_authority.add(key);
			}else if("role".equals(value)){
				delSet_role.add(key);
			}else if("user".equals(value)){
				delSet_user.add(key);
			}
		}
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
