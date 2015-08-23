package com.ccloomi.web.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccloomi.core.common.bean.Message;
import com.ccloomi.core.common.bean.VisData;
import com.ccloomi.core.common.controller.BaseController;
import com.ccloomi.web.system.bean.RAUvisDataBean;
import com.ccloomi.web.system.service.VisService;

@Controller
public class SystemController extends BaseController{
	@Autowired
	private VisService visService;
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(){
		cleanSession();
		return "login";
	}
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	@RequestMapping("/showAllRAUvisData")
	public String showAllRAUvisData(){
		return "system/allRAUvisData";
	}
	@RequestMapping("/allRAUvisData")
	@ResponseBody
	public VisData AllRAUvisData(){
		return visService.getAllRAUvisData();
	}
	@RequestMapping("/saveRAUvisData")
	@ResponseBody
	public Message saveRAUvisData(@RequestBody RAUvisDataBean vd){
		Message ms=new Message();
		boolean isOK=visService.saveRAUvisData(vd);
		if(isOK){
			ms.setCode("0");
		}else{
			ms.setCode("1");
			ms.setInfo("保存失败");
		}
		return ms;
	}
	/**获取 visService*/
	public VisService getVisService() {
		return visService;
	}
	/**设置 visService*/
	public void setVisService(VisService visService) {
		this.visService = visService;
	}
	
}
