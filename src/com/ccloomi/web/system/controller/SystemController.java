package com.ccloomi.web.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"userid"})
public class SystemController {
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/home")
	public String home(@ModelAttribute("userid") String userid){
		return "home";
	}
}
