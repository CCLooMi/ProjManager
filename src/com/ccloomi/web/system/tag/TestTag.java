package com.ccloomi.web.system.tag;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：TestTag
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年9月25日-下午10:55:41
 */
public class TestTag extends BodyTagSupport{
	private static final long serialVersionUID = -6906995731724021290L;

	@Override
	public int doStartTag() throws JspException {
		System.out.println("----------doStartTag----------");
		System.out.println(getBodyContent());
		return EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		Set<String>set=new HashSet<String>();
		String body=bodyContent.getString();
		//匹配去掉左边和右边空格内容的字符
		Pattern pattern=Pattern.compile("[^\\s].+\\..+[^\\s]");
		Matcher matcher=pattern.matcher(body);
		while(matcher.find()){
			set.add(matcher.group());
		}
		return EVAL_PAGE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("----------doEndTag----------");
		System.out.println(getBodyContent().getString());
		return 0;
	}
	
}
