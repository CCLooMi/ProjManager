package com.ccloomi.web.system.service;

import com.ccloomi.core.common.bean.VisData;
import com.ccloomi.web.system.bean.RAUvisDataBean;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：VisService
 * 类 描 述：VIS服务接口
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月1日-下午12:09:22
 */
public interface VisService {
	/**
	 * 描述：获取所有角色(R)权限(A)用户(U)的Vis数据
	 * 作者：Chenxj
	 * 日期：2015年8月1日 - 下午12:20:12
	 * @return VisData
	 */
	public VisData getAllRAUvisData();
	/**
	 * 描述：
	 * 作者：Chenxj
	 * 日期：2015年8月23日 - 下午11:08:55
	 * @param rauVisData
	 * @return
	 */
	public boolean saveRAUvisData(RAUvisDataBean rauVisData);
}
