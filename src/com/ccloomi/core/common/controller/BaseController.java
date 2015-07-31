package com.ccloomi.core.common.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名：BaseController
 * 描述：基础抽象controller
 * 作者： Chenxj
 * 日期：2015年6月23日 - 下午4:34:11
 */
public abstract class BaseController {
	protected final Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private HttpSession session;
	/**
	 * 方法描述：从session中获取属性值
	 * 作者：Chenxj
	 * 日期：2015年7月31日 - 上午10:01:32
	 * @param name
	 * @return
	 */
	protected Object getSessionAttribute(String name){
		return this.session.getAttribute(name);
	}
	/**
	 * 方法描述：将属性值存到session中
	 * 作者：Chenxj
	 * 日期：2015年7月31日 - 上午10:01:36
	 * @param name
	 * @param value
	 */
	protected void setSessionAttribute(String name,Object value) {
		this.session.setAttribute(name, value);
	}
	/**
	 * 方法描述：清空session
	 * 作者：Chenxj
	 * 日期：2015年7月31日 - 上午10:04:18
	 */
	protected void cleanSession(){
		this.session.invalidate();
	}
	/**
	 * 方法描述：删除某个属性
	 * 作者：Chenxj
	 * 日期：2015年7月31日 - 上午10:04:22
	 * @param name
	 */
	protected void removeAttribute(String name){
		this.session.removeAttribute(name);
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
}
