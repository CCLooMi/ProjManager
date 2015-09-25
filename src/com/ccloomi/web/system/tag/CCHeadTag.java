package com.ccloomi.web.system.tag;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;

import com.ccloomi.core.tag.BaseTag;
import com.ccloomi.core.util.StringUtil;

public class CCHeadTag extends BaseTag{
	private static final long serialVersionUID = 4475655796155693258L;
	private String linkTemplate="<link rel=\"stylesheet\" href=\"?\">";
	private String scriptTemplate="<script src=\"?\"></script>";
	private String pageName;
	private String title;
	@Override
	public void doTag() throws JspException, IOException {
		StringBuilder sb=new StringBuilder();
		sb.append(StringUtil.format("<base href=\"?", basePath()));
		sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		sb.append(StringUtil.format("<title>?</title>", title==null?pageName():title));
		sb.append(StringUtil.format(linkTemplate, "res/css/bootstrap.css"));
		sb.append(StringUtil.format(linkTemplate, "res/css/bootstrap-theme.css"));
		sb.append(StringUtil.format(linkTemplate, "res/css/view/"+pageName()+".css"));
		sb.append(StringUtil.format(scriptTemplate, "res/js/jquery-2.1.4.min.js"));
		sb.append(StringUtil.format(scriptTemplate, "res/js/bootstrap.js"));
		sb.append(StringUtil.format(scriptTemplate, "res/js/view/"+pageName()+".js"));
		out.write(sb.toString());
	}
	private String basePath(){
		ServletContext context=this.pageContext.getServletContext();
		ServletRequest request=this.pageContext.getRequest();
		String path = context.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}
	private String pageName(){
		if(pageName==null){
			Pattern pattern=Pattern.compile("(?!=\\.)[^\\.]+(?=_jsp)");
			Matcher matcher=pattern.matcher(this.pageContext.getPage().getClass().toString());
			while(matcher.find()){
				pageName=matcher.group();
				break;
			}
		}
		return pageName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
