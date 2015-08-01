package com.ccloomi.web.test;

import com.ccloomi.test.BaseSpringTest;
import com.ccloomi.web.system.service.VisService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：VisTest
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月1日-下午2:19:33
 */
public class VisTest extends BaseSpringTest{
	public static void main(String[] args) {
		VisService vs=VisTest.getBean("visService", VisService.class);
		System.out.println(vs.getAllRAUvisData());
	}
}
