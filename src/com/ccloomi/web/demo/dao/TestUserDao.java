package com.ccloomi.web.demo.dao;

import java.io.Serializable;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.web.demo.entity.TestUser;
/**
 * 类名：TestUserDao
 * 描述：
 * 作者： Chenxj
 * 日期：2015年6月24日 - 下午1:36:44
 */
public interface TestUserDao extends BaseDao<TestUser>{
	public TestUser getUserById(Serializable id);
}
