package com.ccloomi.web.system.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloomi.core.common.entity.IdEntity;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：FileEntity
 * 类 描 述：文件实体
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月3日-下午9:45:04
 */
@Entity
@Table(name="sys_file")
public class FileEntity extends IdEntity {
	private static final long serialVersionUID = 3090902882670536474L;
	private String name;
	private String hashLight;
	private String hash;
	private byte[] data;
	private Timestamp datetimeUpload;
	private String extend;
	private String filepath;
	private String fileurl;
	/**获取 name*/
	public String getName() {
		return name;
	}
	/**设置 name*/
	public void setName(String name) {
		this.name = name;
	}
	/**获取 hashLight*/
	public String getHashLight() {
		return hashLight;
	}
	/**设置 hashLight*/
	public void setHashLight(String hashLight) {
		this.hashLight = hashLight;
	}
	/**获取 hash*/
	public String getHash() {
		return hash;
	}
	/**设置 hash*/
	public void setHash(String hash) {
		this.hash = hash;
	}
	/**获取 data*/
	public byte[] getData() {
		return data;
	}
	/**设置 data*/
	public void setData(byte[] data) {
		this.data = data;
	}
	/**获取 datetimeUpload*/
	public Timestamp getDatetimeUpload() {
		return datetimeUpload;
	}
	/**设置 datetimeUpload*/
	public void setDatetimeUpload(Timestamp datetimeUpload) {
		this.datetimeUpload = datetimeUpload;
	}
	/**获取 extend*/
	public String getExtend() {
		return extend;
	}
	/**设置 extend*/
	public void setExtend(String extend) {
		this.extend = extend;
	}
	/**获取 filepath*/
	public String getFilepath() {
		return filepath;
	}
	/**设置 filepath*/
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	/**获取 fileurl*/
	public String getFileurl() {
		return fileurl;
	}
	/**设置 fileurl*/
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	/**获取 serialversionuid*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
