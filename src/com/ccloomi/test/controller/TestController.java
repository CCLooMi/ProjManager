package com.ccloomi.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ccloomi.core.common.controller.BaseController;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：TestController
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年9月19日-下午9:52:01
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController{
	
	@RequestMapping("/tag")
	public String tagTest(){
		return "test/tagTest";
	}
}
