package com.ccloomi.web.demo.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccloomi.core.common.controller.BaseController;
import com.ccloomi.web.demo.entity.TestUser;
import com.ccloomi.web.demo.service.TestUserService;
/**
 * 类名：TestUserController
 * 描述：TestUserController
 * 作者： Chenxj
 * 日期：2015年6月24日 - 下午1:38:23
 */
@Controller
@RequestMapping("/testUser")
public class TestUserController extends BaseController{
	@Autowired
	private TestUserService testUserService;
	
	public TestUserService getTestUserService() {
		return testUserService;
	}

	public void setTestUserService(TestUserService testUserService) {
		this.testUserService = testUserService;
	}
	@RequestMapping("/getUserById")
	@ResponseBody
	public TestUser getUserById(String id){
		return this.testUserService.getUserById(id);
	}
	@RequestMapping("/saveUser")
	@ResponseBody
	public Serializable saveUser(TestUser testUser){
		return this.testUserService.saveTestUser(testUser);
	}
	@RequestMapping("/saveOrUpdateUser")
	public void saveOrUpdateUser(TestUser testUser){
		this.testUserService.saveOrUpdateUser(testUser);
	}
}
