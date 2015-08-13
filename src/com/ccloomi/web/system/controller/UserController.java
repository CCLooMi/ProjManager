package com.ccloomi.web.system.controller;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccloomi.core.common.bean.Message;
import com.ccloomi.core.common.controller.BaseController;
import com.ccloomi.web.system.entity.UserEntity;
import com.ccloomi.web.system.service.UserService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：UserController
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月12日-下午5:54:32
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	/**获取 userService*/
	public UserService getUserService() {
		return userService;
	}
	
	/**设置 userService*/
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping("/checkUser")
	@ResponseBody
	public Message checkUser(@RequestBody Map<String, String>map){
		Message ms=new Message();
		String username=map.get("username");
		String password=map.get("password");
		Serializable id=userService.checkUser(username, password);
		if(id!=null){
			ms.setCode("0");
			ms.setInfo((String)id);
			saveAttributeToSession("user", userService.getById(id));
		}else{
			ms.setCode("1");
			ms.setInfo("用户名不存在或密码错误！");
		}
		return ms;
	}
	@RequestMapping("/add")
	@ResponseBody
	public Message saveOrUpdateUser(@RequestBody UserEntity user){
		Message ms=new Message();
		Serializable userid=userService.save(user.md5Password());
		if(userid!=null){
			ms.setCode("0");
			ms.setInfo((String)userid);
		}else{
			ms.setCode("1");
			ms.setInfo("添加用户失败");
		}
		return ms;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public Message deleteUser(String id){
		Message ms=new Message();
		boolean isOK=userService.delete(id);
		if(isOK){
			ms.setCode("0");
		}else{
			ms.setCode("1");
			ms.setInfo("删除用户失败");
		}
		return ms;
	}
}
