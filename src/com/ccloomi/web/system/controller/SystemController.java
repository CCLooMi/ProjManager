package com.ccloomi.web.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ccloomi.core.common.controller.BaseController;

@Controller
public class SystemController extends BaseController{
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
}
