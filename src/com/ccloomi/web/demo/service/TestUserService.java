package com.ccloomi.web.demo.service;

import java.io.Serializable;

import com.ccloomi.web.demo.entity.TestUser;

/**
 * 类名：TestUserService
 * 描述：
 * 作者： Chenxj
 * 日期：2015年6月24日 - 下午1:37:25
 */
public interface TestUserService {
	public TestUser getUserById(Serializable id);
	public Serializable saveTestUser(TestUser testUser);
	public void saveOrUpdateUser(TestUser testUser);
}
