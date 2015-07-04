package com.ccloomi.web.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloomi.core.common.entity.IdEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：OrganizationUserEntity
 * 类 描 述：用户组织机构中间实体
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午9:42:03
 */
@Entity
@Table(name="sys_organization_user")
public class OrganizationUserEntity extends IdEntity {
	private static final long serialVersionUID = -5816233823609061266L;
	/**组织机构ID*/
	private String idOrganization;
	/**用户ID*/
	private String idUser;
	/**获取 组织机构ID*/
	public String getIdOrganization() {
		return idOrganization;
	}
	/**设置 组织机构ID*/
	public void setIdOrganization(String idOrganization) {
		this.idOrganization = idOrganization;
	}
	/**获取 用户ID*/
	public String getIdUser() {
		return idUser;
	}
	/**设置 用户ID*/
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	
}
