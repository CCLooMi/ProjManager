package com.ccloomi.core.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

import com.ccloomi.web.system.entity.UserEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：SQLUtil
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月26日-下午9:32:35
 */
public class SQLUtil {
	
	private StringBuilder sb=new StringBuilder();
	
	public SQLUtil SELECT(String...columns){
		sb.append("SELECT ").append(StringUtil.join(",", columns));
		return this;
	}
	public SQLUtil FROM(Class<?>...classes){
		List<String>tns=new ArrayList<String>();
		for(Class<?>c:classes){
			Table t=c.getDeclaredAnnotation(Table.class);
			String tableName=t==null?c.getName():t.name();
			tns.add(tableName);
		}
		sb.append(" FROM ").append(StringUtil.joinString(",", tns.toArray()));
		return this;
	}
	public SQLUtil WHERE(String columns,Object...values){
		sb.append(" WHERE ").append(columns);
		return this;
	}
	public SQLUtil AND(String columns,Object...values){
		sb.append(" AND ").append(columns);
		return this;
	}
	public String SQL(){
		System.out.println(sb.toString());
		return sb.toString();
	}
	public static void main(String[] args) {
		
		UserEntity user=new UserEntity();
		user.setId("ID0098");
		user.setNickname("JJK");
		user.setUsername("Jacky");
		user.setPassword("123456");
		user.prepareProperties();
		System.out.println(user.getPropertyValue("username"));
		System.out.println(user.getPropertyTableColumn("username"));
		System.out.println(user.getPropertyA(0));
		System.out.println(user.getProperty("username"));
		System.out.println(user.getTableName());
		
//		SQLUtil su=new SQLUtil();
//		su
//		.SELECT("id","name","email")
//		.FROM(UserEntity.class,RoleEntity.class)
//		.WHERE("id=?", "ID009")
//		.AND("name=?", "Chenxj")
//		.SQL();
	}
}
