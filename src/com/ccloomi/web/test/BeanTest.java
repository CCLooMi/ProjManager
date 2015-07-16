package com.ccloomi.web.test;

import com.ccloomi.web.system.entity.UserEntity;

public class BeanTest {
	public static void main(String[] args) {
		UserEntity u=new UserEntity();
		System.out.println(u.getProperty("kk"));
		System.out.println(u.getProperty("id"));
	}
}
