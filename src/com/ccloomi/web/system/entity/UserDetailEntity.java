package com.ccloomi.web.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloomi.core.common.entity.IdEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：UserDetailEntity
 * 类 描 述：用户详情
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午9:39:45
 */
@Entity
@Table(name="sys_user_detail")
public class UserDetailEntity extends IdEntity{
	private static final long serialVersionUID = 4032017684803646244L;
	/**用户ID*/
	private String idUser;
	/**键*/
	private String K;
	/**值*/
	private String V;
	/**获取 用户ID*/
	public String getIdUser() {
		return idUser;
	}
	/**设置 用户ID*/
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	/**获取 键*/
	public String getK() {
		return K;
	}
	/**设置 键*/
	public void setK(String k) {
		K = k;
	}
	/**获取 值*/
	public String getV() {
		return V;
	}
	/**设置 值*/
	public void setV(String v) {
		V = v;
	}
	
}
