package com.ccloomi.web.test;

import com.ccloomi.test.BaseSpringTest;
import com.ccloomi.web.system.entity.AuthorityEntity;
import com.ccloomi.web.system.service.AuthorityService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：AuthorityTest
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月1日-上午9:19:24
 */
public class AuthorityTest extends BaseSpringTest{
	public static void main(String[] args) {
		AuthorityService authorityService=AuthorityTest.getBean("authorityService", AuthorityService.class);
		AuthorityEntity a=new AuthorityEntity();
		a.setName("系统管理");
		String id=(String)authorityService.save(a);
		
		a=new AuthorityEntity();
		a.setIdParent(id);
		a.setName("角色管理");
		authorityService.save(a);
		
		a=new AuthorityEntity();
		a.setIdParent(id);
		a.setName("权限管理");
		authorityService.save(a);
	}
}
