package com.ccloomi.web.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloomi.core.common.entity.IdEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：OrganizationEntity
 * 类 描 述：组织实体
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午9:43:26
 */
@Entity
@Table(name="sys_organization")
public class OrganizationEntity extends IdEntity {
	private static final long serialVersionUID = -801012731146956463L;
	/**组织机构名称*/
	private String name;
	/**上级组织机构ID*/
	private String idParent;
	/**获取 组织机构名称*/
	public String getName() {
		return name;
	}
	/**设置 组织机构名称*/
	public void setName(String name) {
		this.name = name;
	}
	/**获取 上级组织机构ID*/
	public String getIdParent() {
		return idParent;
	}
	/**设置 上级组织机构ID*/
	public void setIdParent(String idParent) {
		this.idParent = idParent;
	}
	
}
