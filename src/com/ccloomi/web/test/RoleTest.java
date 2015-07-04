package com.ccloomi.web.test;

import com.ccloomi.test.BaseSpringTest;
import com.ccloomi.web.system.entity.RoleEntity;
import com.ccloomi.web.system.service.RoleService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：RoleTest
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午11:11:24
 */
public class RoleTest extends BaseSpringTest{
	public static void main(String[] args) {
		RoleService rs=RoleTest.getBean("roleService", RoleService.class);
		RoleEntity role=new RoleEntity();
		role.setCode("RT001");
		role.setName("超级管理员");
		rs.save(role);
	}
}
