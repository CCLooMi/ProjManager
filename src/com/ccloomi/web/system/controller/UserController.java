package com.ccloomi.web.system.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccloomi.core.common.bean.Message;
import com.ccloomi.core.common.controller.BaseController;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：UserController
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月12日-下午5:54:32
 */
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@RequestMapping("/checkUser")
	@ResponseBody
	public Message checkUser(@RequestBody Map<String, String>map){
		Message ms=new Message();
		
		return ms;
	}
}
