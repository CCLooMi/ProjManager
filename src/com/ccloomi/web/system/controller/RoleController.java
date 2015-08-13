package com.ccloomi.web.system.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccloomi.core.common.bean.Message;
import com.ccloomi.core.common.controller.BaseController;
import com.ccloomi.web.system.entity.RoleEntity;
import com.ccloomi.web.system.service.RoleService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：RoleController
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月12日-下午10:19:47
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Message addRole(@RequestBody RoleEntity role){
		Message m=new Message();
		Serializable roleid=roleService.save(role);
		if(roleid!=null){
			m.setCode("0");
			m.setInfo((String) roleid);
		}else{
			m.setCode("1");
			m.setInfo("添加角色失败");
		}
		return m;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public Message deleteRole(String id){
		Message m=new Message();
		roleService.delete(id);
		m.setCode("0");
		return m;
	}
	/**获取 roleService*/
	public RoleService getRoleService() {
		return roleService;
	}
	/**设置 roleService*/
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
}
