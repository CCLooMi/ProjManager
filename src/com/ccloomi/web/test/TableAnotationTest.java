package com.ccloomi.web.test;

import javax.persistence.Table;

import com.ccloomi.web.system.entity.UserEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：TableAnotationTest
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月13日-下午9:07:52
 */
public class TableAnotationTest {
	public static void main(String[] args) {
		UserEntity u=new UserEntity();
		Class<?>c=u.getClass();
		System.out.println(c.getDeclaredAnnotation(Table.class).name());
	}
}
