package com.ccloomi.web.system.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloomi.core.common.entity.IdEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：LogTableEntity
 * 类 描 述：表操作日志实体
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午9:46:21
 */
@Entity
@Table(name="sys_log_table")
public class LogTableEntity extends IdEntity {
	private static final long serialVersionUID = 8873240310149088460L;
	private String nameTable;
	private String dataIndex;
	private Timestamp datetimeCreate;
	private String idUserCreate;
	private String nameUserCreate;
	private Timestamp detetimeModify;
	private String idUserModify;
	private String nameUserModify;
	/**获取 nameTable*/
	public String getNameTable() {
		return nameTable;
	}
	/**设置 nameTable*/
	public void setNameTable(String nameTable) {
		this.nameTable = nameTable;
	}
	/**获取 dataIndex*/
	public String getDataIndex() {
		return dataIndex;
	}
	/**设置 dataIndex*/
	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}
	/**获取 datetimeCreate*/
	public Timestamp getDatetimeCreate() {
		return datetimeCreate;
	}
	/**设置 datetimeCreate*/
	public void setDatetimeCreate(Timestamp datetimeCreate) {
		this.datetimeCreate = datetimeCreate;
	}
	/**获取 idUserCreate*/
	public String getIdUserCreate() {
		return idUserCreate;
	}
	/**设置 idUserCreate*/
	public void setIdUserCreate(String idUserCreate) {
		this.idUserCreate = idUserCreate;
	}
	/**获取 nameUserCreate*/
	public String getNameUserCreate() {
		return nameUserCreate;
	}
	/**设置 nameUserCreate*/
	public void setNameUserCreate(String nameUserCreate) {
		this.nameUserCreate = nameUserCreate;
	}
	/**获取 detetimeModify*/
	public Timestamp getDetetimeModify() {
		return detetimeModify;
	}
	/**设置 detetimeModify*/
	public void setDetetimeModify(Timestamp detetimeModify) {
		this.detetimeModify = detetimeModify;
	}
	/**获取 idUserModify*/
	public String getIdUserModify() {
		return idUserModify;
	}
	/**设置 idUserModify*/
	public void setIdUserModify(String idUserModify) {
		this.idUserModify = idUserModify;
	}
	/**获取 nameUserModify*/
	public String getNameUserModify() {
		return nameUserModify;
	}
	/**设置 nameUserModify*/
	public void setNameUserModify(String nameUserModify) {
		this.nameUserModify = nameUserModify;
	}
	
}
