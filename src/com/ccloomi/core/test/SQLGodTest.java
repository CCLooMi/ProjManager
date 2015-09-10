package com.ccloomi.core.test;

import com.ccloomi.core.common.sql.imp.SQLMaker;
import com.ccloomi.test.BaseSpringTest;
import com.ccloomi.web.system.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：SQLGodTest
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月29日-上午10:50:39
 */
public class SQLGodTest extends BaseSpringTest{
	public static void main(String[] args) throws Exception {
		SQLMaker sm=new SQLMaker();
		sm.SELECT("u.username,u.password")
		.FROM(new UserEntity(), "u")
		.WHERE("u.id=?","ABCDEFGJHOJ");
		System.out.println(sm);
		System.out.println(new ObjectMapper().writeValueAsString(sm));
		
		sm.clean();
		sm.DELETE(new UserEntity(), "u")
		.WHERE("u.id=?","123")
		.AND("u.name=?","apple");
		System.out.println(sm);
		
		sm.clean();
		sm.SELECT("u.id,u.name")
		.SELECT_AS("u.name","u_name")
		.FROM(new UserEntity(), "u")
		.WHERE("u.id=1")
		.AND("u.name=?","apple");
		System.out.println(sm);
	}
}
