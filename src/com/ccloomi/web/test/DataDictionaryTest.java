package com.ccloomi.web.test;

import java.io.Serializable;

import com.ccloomi.test.BaseSpringTest;
import com.ccloomi.web.system.entity.DataDictionaryEntity;
import com.ccloomi.web.system.service.DataDictionaryService;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：DataDictionaryTest
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年9月20日-上午7:16:21
 */
public class DataDictionaryTest extends BaseSpringTest{
	public static void main(String[] args) {
		DataDictionaryService ds=DataDictionaryTest.ctx.getBean("dataDictionaryService", DataDictionaryService.class);
		DataDictionaryEntity d=new DataDictionaryEntity();
		d.setCode("lampStatus");
		d.setK("电灯状态");
		Serializable id=ds.save(d);
		
		d=new DataDictionaryEntity();
		d.setCode("lampStatus");
		d.setK("开");
		d.setV("1");
		d.setPid((String) id);
		ds.save(d);
		
		d=new DataDictionaryEntity();
		d.setCode("lampStatus");
		d.setK("关");
		d.setV("0");
		d.setPid((String) id);
		ds.save(d);
	}
}
