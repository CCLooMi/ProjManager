package com.ccloomi.web.test;

import java.io.Serializable;

import com.ccloomi.core.component.security.SecretUtil;
import com.ccloomi.test.BaseSpringTest;
import com.ccloomi.web.system.entity.UserEntity;
import com.ccloomi.web.system.service.UserService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：UserServiceTest
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月12日-下午5:40:43
 */
public class UserServiceTest extends BaseSpringTest{
	UserService us=ctx.getBean("userService", UserService.class);
	
	public static void main(String[] args) {
		UserServiceTest t=new UserServiceTest();
		t.checkUserTest();
	}
	
	public void addTest(){
		UserEntity u=new UserEntity();
		u.setUsername("Chenxj");
		u.setPassword(SecretUtil.MD5("apple"));
		u.setNickname("CCLooMi");
		us.saveOrUpdate(u);
	}
	public void checkUserTest(){
		Serializable id=us.checkUser("Chenxj", "apple");
		if(id!=null){
			System.out.println("检查通过："+id);
		}else{
			System.out.println("检查不通过！");
		}
		id=us.checkUser("Chenxj", "applee");
		if(id!=null){
			System.out.println("检查通过："+id);
		}else{
			System.out.println("检查不通过！");
		}
	}
}
