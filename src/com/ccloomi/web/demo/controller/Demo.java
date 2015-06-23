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
		boolean isOK1=memcachedClient.add("123456", name);
		boolean isOK2=memcachedClient.set("123456", name);
		if(isOK1){
			//没有则添加，已有则不添加
			System.out.println("Add user:"+name+"successed.");
		}
		if(isOK2){
			//有则替换没有则添加
			System.out.println("Set user:"+name+"successed.");
		}
		return "Hello "+name;
	}
}
