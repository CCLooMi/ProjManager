package com.ccloomi.web.system.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccloomi.core.tag.BaseTag;
import com.ccloomi.core.util.StringUtil;
import com.ccloomi.web.system.service.DataDictionaryService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：CCInputTag
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年9月22日-下午11:03:18
 */
public class CCInputTag extends BaseTag{
	private static final long serialVersionUID = -1165095592558752576L;
	@Autowired
	private DataDictionaryService dataDictionaryService;
	private InputEnum type=InputEnum.text;
	private String label;
	private String name;
	private String value;
	private String key;
	@Override
	public void doTag() throws JspException, IOException {
		StringBuffer sb=new StringBuffer();
		sb.append("<div class=\"form-group\">");
		if(type==InputEnum.text||type==InputEnum.password){
			sb.append(labelHTML(name,label));
			sb.append("<div class=\"col-sm-10\">");
			sb.append(StringUtil.format("<input type=\"?\" class=\"form-control\" id=\"?\" name=\"?\" value=\"?\" placeholder=\"?\">",type,name,name,value,label));
		}else if(type==InputEnum.textarea){
			sb.append(StringUtil.format("<label for=\"?\" class=\"col-sm-2 control-label\">?</label>", name,label));
			sb.append("<div class=\"col-sm-10\">");
			sb.append(StringUtil.format("<textarea class=\"form-control\" rows=\"3\" id=\"?\" name=\"?\" placeholder=\"?\">?</textarea>", name,name,label,value));
		}else if(type==InputEnum.select){
			
		}else if(type==InputEnum.radio){
			
		}else if(type==InputEnum.checkbox){
			
		}
		sb.append("</div></div>");
		out.write(sb.toString());
	}
	private String labelHTML(Object...args){
		return StringUtil.format2("<label for=\"?\" class=\"col-sm-2 control-label\">?</label>", args);
	}
	/**获取 label*/
	public String getLabel() {
		return label;
	}
	/**设置 label*/
	public void setLabel(String label) {
		this.label = label;
	}
	/**获取 name*/
	public String getName() {
		return name;
	}
	/**设置 name*/
	public void setName(String name) {
		this.name = name;
	}
	/**获取 value*/
	public String getValue() {
		return value;
	}
	/**设置 value*/
	public void setValue(String value) {
		this.value = value;
	}
	/**获取 type*/
	public InputEnum getType() {
		return type;
	}
	/**设置 type*/
	public void setType(InputEnum type) {
		this.type = type;
	}
	/**获取 key*/
	public String getKey() {
		return key;
	}
	/**设置 key*/
	public void setKey(String key) {
		this.key = key;
	}
}
