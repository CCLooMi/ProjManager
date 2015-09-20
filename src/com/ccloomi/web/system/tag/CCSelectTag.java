package com.ccloomi.web.system.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccloomi.core.common.sql.imp.SQLMaker;
import com.ccloomi.core.tag.BaseTag;
import com.ccloomi.core.util.StringUtil;
import com.ccloomi.web.system.entity.DataDictionaryEntity;
import com.ccloomi.web.system.service.DataDictionaryService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：CCSelectTag
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年9月19日-下午9:06:07
 */
public class CCSelectTag extends BaseTag{
	private static final long serialVersionUID = 2485463322503405000L;
	@Autowired
	private DataDictionaryService dataDictionaryService;
	private String keyCode;
	private String value;
	
	public void doTag() throws JspException,IOException{
		JspWriter out=pageContext.getOut();
		SQLMaker sm=new SQLMaker();
		sm.SELECT("d.id,d.K,d.V")
		.FROM(new DataDictionaryEntity(), "d")
		.WHERE("d.pid IS NOT NULL")
		.AND("d.code=?",keyCode);
		List<Map<String, Object>>list=dataDictionaryService.findBySQLGod(sm);
		StringBuilder sb=new StringBuilder();
		sb.append("<select>");
		
		if(value==null||"".equals(value)){
			for(Map<String, Object>map:list){
				sb.append(StringUtil.format("<option value=\"?\">?</optin>", map.get("V"),map.get("K")));
			}
		}else{
			for(Map<String, Object>map:list){
				Object v=map.get("V");
				sb.append(StringUtil.format("<option value=\"?\" ?>?</optin>", v,(value.equals(v)?"selected=selected":""),map.get("K")));
			}
		}
		
		sb.append("</select>");
		out.write(sb.toString());
	}
	
	/**获取 keyCode*/
	public String getKeyCode() {
		return keyCode;
	}
	/**设置 keyCode*/
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	/**获取 value*/
	public String getValue() {
		return value;
	}
	/**设置 value*/
	public void setValue(String value) {
		this.value = value;
	}
}
