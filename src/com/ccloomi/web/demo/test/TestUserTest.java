package com.ccloomi.web.demo.test;

import com.ccloomi.test.BaseSpringTest;
import com.ccloomi.web.demo.controller.TestUserController;
import com.ccloomi.web.demo.entity.TestUser;

public class TestUserTest extends BaseSpringTest {
	public static void main(String[] args) {
		TestUserTest t=new TestUserTest();
		TestUserController uc=t.ctx.getBean("testUserController",TestUserController.class);
		
		TestUser u=new TestUser();
		u.setId("4028a1f44e243508014e243509760000");
		u.setEmail("Chenxj@to.com");
		u.setNickname("Chenxj");
		u.setPassword("apple");
//		System.out.println(uc.getUserById("4028a1f44dfabc5d014dfabd3c210001"));
		uc.saveOrUpdateUser(u);
	}
}
