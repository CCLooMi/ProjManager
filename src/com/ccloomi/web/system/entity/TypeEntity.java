package com.ccloomi.web.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloomi.core.common.entity.IdEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：TypeEntity
 * 类 描 述：类型实体
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午9:47:09
 */
@Entity
@Table(name="sys_type")
public class TypeEntity extends IdEntity {
	private static final long serialVersionUID = 7216216806455318412L;
	private String name;
	private String code;
	private String idParent;
	/**获取 name*/
	public String getName() {
		return name;
	}
	/**设置 name*/
	public void setName(String name) {
		this.name = name;
	}
	/**获取 code*/
	public String getCode() {
		return code;
	}
	/**设置 code*/
	public void setCode(String code) {
		this.code = code;
	}
	/**获取 idParent*/
	public String getIdParent() {
		return idParent;
	}
	/**设置 idParent*/
	public void setIdParent(String idParent) {
		this.idParent = idParent;
	}
	
}
