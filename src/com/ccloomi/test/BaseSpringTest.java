package com.ccloomi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 类    名：BaseSpringTest
 * 类描述：所有要测试Spring的测试类都可以继承此抽象类而获得ctx对象
 * 作    者：Chenxj
 * 日    期：2015年6月24日-下午12:54:55
 */
public abstract class BaseSpringTest {
	protected ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/spring.xml");
}
