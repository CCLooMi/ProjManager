package com.ccloomi.web.system.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccloomi.core.common.bean.Message;
import com.ccloomi.core.common.controller.BaseController;
import com.ccloomi.web.system.entity.AuthorityEntity;
import com.ccloomi.web.system.service.AuthorityService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：AuthorityController
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月13日-下午11:06:22
 */
@Controller
@RequestMapping("/authority")
public class AuthorityController extends BaseController{
	@Autowired
	private AuthorityService authorityService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Message addAuthority(@RequestBody AuthorityEntity authority){
		Message ms=new Message();
		Serializable authorityid=authorityService.save(authority);
		if(authorityid!=null){
			ms.setCode("0");
			ms.setInfo((String)authorityid);
		}else{
			ms.setCode("1");
			ms.setInfo("添加菜单失败");
		}
		return ms;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public Message deleteAuthority(String id){
		Message ms=new Message();
		boolean isOK=authorityService.delete(id);
		if(isOK){
			ms.setCode("0");
		}else{
			ms.setCode("1");
			ms.setInfo("删除菜单失败");
		}
		return ms;
	}
	/**
	 * 描述：更新菜单
	 * 作者：Chenxj
	 * 日期：2015年8月15日 - 下午10:20:46
	 * @param id
	 * @param pid
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Message updateAuthority(String id,String pid) {
		Message ms=new Message();
		
		return ms;
	}
	/**获取 authorityService*/
	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	/**设置 authorityService*/
	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
	
}
