package com.ccloomi.core.common.sql.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccloomi.core.common.entity.BaseEntity;
import com.ccloomi.core.common.sql.SQLGod;
import com.ccloomi.core.util.StringUtil;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：SQLMaker
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月27日-下午10:27:03
 */
public class SQLMaker implements SQLGod{
	private final Logger log=LoggerFactory.getLogger(getClass());
	/**0查询1更新*/
	private int type;
	private StringBuilder sb;
	private Map<String, String>table_alias;
	private Map<String, BaseEntity>alias_entity;
	private List<String>select_columns;
	private String where;
	private List<String>andor;
	private List<Object>values;
	private List<String>set;
	private List<String>order_by;
	private String limit;
	private List<Object[]>batchArgs;
	
	private void init(){
		this.sb				= new StringBuilder();
		this.table_alias	= new HashMap<String, String>();
		this.alias_entity	= new HashMap<String, BaseEntity>();
		this.select_columns	= new ArrayList<String>();
		this.where			= "1=1";
		this.andor			= new ArrayList<String>();
		this.values			= new ArrayList<Object>();
		this.set			= new ArrayList<String>();
		this.order_by		= new ArrayList<String>();
		this.limit			= "";
	}
	/**获取 batchArgs*/
	public List<Object[]> getBatchArgs() {
		return batchArgs;
	}
	/**设置 batchArgs*/
	public SQLMaker setBatchArgs(List<Object[]> batchArgs) {
		this.batchArgs = batchArgs;
		return this;
	}
	public SQLMaker SELECT(String...columns){
		this.type=0;
		if(this.select_columns==null){
			this.init();
		}
		for(String column:columns){
			this.select_columns.add(column);
		}
		return this;
	}
	public SQLMaker SELECT_AS(String column,String alias){
		this.type=0;
		if(this.select_columns==null){
			this.init();
		}
		this.select_columns.add(StringUtil.format("? AS '?'", column,alias));
		return this;
	}
	public SQLMaker UPDATE(BaseEntity entity,String alias){
		this.type=1;
		this.init();
		this.table_alias.put(entity.getTableName(),alias);
		this.alias_entity.put(alias, entity);
		return this;
	}
	public SQLMaker FROM(BaseEntity entity,String alias){
		this.table_alias.put(entity.getTableName(),alias);
		this.alias_entity.put(alias, entity);
		return this;
	}
	public SQLMaker WHERE(String str){
		this.where=str;
		return this;
	}
	public SQLMaker WHERE(String str,Object...values){
		this.where=str;
		for(Object value:values){
			this.values.add(value);
		}
		return this;
	}
	public SQLMaker AND(String str){
		this.andor.add(" AND "+str);
		return this;
	}
	public SQLMaker AND(String str,Object...values){
		this.andor.add(" AND "+str);
		for(Object value:values){
			this.values.add(value);
		}
		return this;
	}
	public SQLMaker OR(String str){
		this.andor.add(" OR "+str);
		return this;
	}
	public SQLMaker OR(String str,Object...values){
		this.andor.add(" OR "+str);
		for(Object value:values){
			this.values.add(value);
		}
		return this;
	}
	public SQLMaker SET(String str,Object...values){
		this.set.add(str);
		for(Object value:values){
			this.values.add(value);
		}
		return this;
	}
	public SQLMaker ORDER_BY(String...columns){
		for(String column:columns){
			this.order_by.add(column);
		}
		return this;
	}
	public SQLMaker LIMIT(int page,int pageSize){
		this.limit=" LIMIT ?,?";
		this.values.add(page);
		this.values.add(pageSize);
		return this;
	}
	private String sqlString(){
		if(this.type==0){
			
			sb.append("SELECT ").append(StringUtil.joinString(",", this.select_columns.toArray()));
			
			List<String>tableNames=new ArrayList<String>();
			for(String tableName:this.table_alias.keySet()){
				String alias=this.table_alias.get(tableName);
				tableNames.add(StringUtil.joinString(" ",tableName,alias));
			}
			sb.append(" FROM ").append(StringUtil.join(",", tableNames.toArray()));
			sb.append(" WHERE ").append(this.where);
			sb.append(StringUtil.join(" ", this.andor.toArray()));
			if(this.order_by.size()>0){
				sb.append(" ORDER BY ").append(StringUtil.join(",", this.order_by.toArray()));
			}
			sb.append(limit);
		}else if(this.type==1){
			List<String>tableNames=new ArrayList<String>();
			for(String tableName:this.table_alias.keySet()){
				String alias=this.table_alias.get(tableName);
				tableNames.add(StringUtil.joinString(" ",tableName,alias));
			}
			sb.append("UPDATE ").append(StringUtil.join(",", tableNames.toArray()));
			sb.append(" SET ").append(StringUtil.join(",", this.set.toArray()));
			sb.append(" WHERE ").append(this.where);
			sb.append(StringUtil.join(" ", this.andor.toArray()));
		}
		
		StringBuffer sbf=new StringBuffer();
		
		for(String alias:this.alias_entity.keySet()){
			Pattern pattern1=Pattern.compile("\\s"+alias+"\\.\\w+");
			Pattern pattern2=Pattern.compile(","+alias+"\\.\\w+");
			BaseEntity entity=this.alias_entity.get(alias);
			Matcher matcher1=pattern1.matcher(sb.toString());
			
			while(matcher1.find()){
				String pname=matcher1.group().split("\\.")[1];
				matcher1.appendReplacement(sbf, " "+alias+"."+entity.getPropertyTableColumn(pname));
			}
			matcher1.appendTail(sbf);
			
			Matcher matcher2=pattern2.matcher(sbf.toString());
			
			sbf=new StringBuffer();
			while(matcher2.find()){
				String pname=matcher2.group().split("\\.")[1];
				matcher2.appendReplacement(sbf, ","+alias+"."+entity.getPropertyTableColumn(pname));
			}
			matcher2.appendTail(sbf);
		}
		return sb.toString();
	}
	@Override
	public Map<String, List<? extends Object>> sql(){
		Map<String, List<? extends Object>>result=new HashMap<String, List<? extends Object>>();
		String sql=sqlString();
		result.put(sql, values);
		log.debug("SQLGod生成SQL::[{}]",result);
		return result;
	}
	@Override
	public Map<String, List<Object[]>> batchSql() {
		Map<String, List<Object[]>>result=new HashMap<String, List<Object[]>>();
		String sql=sqlString();
		result.put(sql, batchArgs);
		log.debug("SQLGod生成SQL::[{}]",result);
		return result;
	}
}
