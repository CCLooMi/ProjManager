package com.ccloomi.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class Demo {
	@RequestMapping("/info")
	@ResponseBody
	public String sayHello(String name){
		System.out.println(name);
		return "Hello "+name;
	}
}
