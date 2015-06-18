package com.ccloomi.core.listener;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
/**
 * 类    名：IdccappInitializer
 * 类描述：系统应用启动初始化类，此类功能和SystemInitialListener基本相同。无需加注解即可被调用
 * 作    者：Chenxj
 * 日    期：2015年6月17日-上午9:56:22
 */
public class SystemInitializer implements WebApplicationInitializer{
	private final Logger log=LoggerFactory.getLogger(SystemInitializer.class);
	@Override
	public void onStartup(ServletContext sc)throws ServletException {
		sc.setAttribute("logbackConfigLocation", "classpath:logback.xml");
		log.debug("初始化logbak，配置文件地址：[{}]", sc.getAttribute("logbackConfigLocation"));
		sc.addListener(LogbackConfigListener.class);
	    log.debug("初始化logbak完成。");
		
		log.debug("初始化编码过滤器，设置编码：[UTF-8]");
		CharacterEncodingFilter cef=sc.createFilter(CharacterEncodingFilter.class);
		cef.setEncoding("UTF-8");
		cef.setForceEncoding(true);
		FilterRegistration.Dynamic dynamic=sc.addFilter("encodingFilter", cef);
		dynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/");
		
		log.debug("添加编码过滤器完成，过滤地址：[/]");
		log.debug("初始化SpringDispatcherServlet");
		
		DispatcherServlet springDispatcherServlet=sc.createServlet(DispatcherServlet.class);
		springDispatcherServlet.setContextConfigLocation("classpath:spring/spring.xml");
		ServletRegistration.Dynamic servletDynamic=sc.addServlet("spring3", springDispatcherServlet);
		servletDynamic.setLoadOnStartup(1);
		servletDynamic.addMapping("*.do");
		log.debug("初始化SpringDispatcherServlet完成，处理地址：[*.do]");
	}
}
