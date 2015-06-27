package com.ccloomi.web.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.ccloomi.core.common.controller.BaseController;

@Controller
@RequestMapping("/demo")
public class Demo extends BaseController{

	@RequestMapping("/info")
	@ResponseBody
	public String sayHello(String name){
		return "Hello "+name;
	}
	@RequestMapping("/login")
	public ModelAndView login(@RequestBody Map<String, String>map){
		String username=map.get("username");
		String password=map.get("password");
		if("Chenxj".equals(username)&&"apple".equals(password)){
			return null;
		}else{
			ModelAndView mav=new ModelAndView();
			MappingJackson2JsonView view=new MappingJackson2JsonView();
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}
}
