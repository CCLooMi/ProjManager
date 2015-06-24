package com.ccloomi.web.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloomi.core.common.entity.IdEntity;
/**
 * 类名：TestUser
 * 描述：
 * 作者： Chenxj
 * 日期：2015年6月24日 - 下午1:37:14
 */
@Entity
@Table(name="t_test_user")
public class TestUser extends IdEntity{
	private static final long serialVersionUID = 7122897925141556384L;
	private String nickname;
	private String password;
	private String email;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
