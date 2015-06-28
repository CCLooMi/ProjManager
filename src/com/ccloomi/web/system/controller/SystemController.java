package com.ccloomi.web.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
}
