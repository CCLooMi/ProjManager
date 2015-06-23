package com.ccloomi.web.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whalin.MemCached.MemCachedClient;

@Controller
@RequestMapping("/demo")
public class Demo {
	@Autowired
	private MemCachedClient memcachedClient;
	
	public MemCachedClient getMemcachedClient() {
		return memcachedClient;
	}

	public void setMemcachedClient(MemCachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	@RequestMapping("/info")
	@ResponseBody
	public String sayHello(String name){
		System.out.println(name);
		boolean isOK=memcachedClient.add("123456", name);
		if(isOK){
			System.out.println("Add user:"+name+"successed.");
		}
		return "Hello "+name;
	}
}
