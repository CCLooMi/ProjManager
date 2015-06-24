package com.ccloomi.web.demo.dao.imp;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.imp.BaseDaoImp;
import com.ccloomi.web.demo.dao.TestUserDao;
import com.ccloomi.web.demo.entity.TestUser;
/**
 * 类名：TestUserDaoImp
 * 描述：
 * 作者： Chenxj
 * 日期：2015年6月24日 - 下午1:37:04
 */
@Service("testUserDao")
public class TestUserDaoImp extends BaseDaoImp<TestUser> implements TestUserDao{

	@Override
	public TestUser getUserById(Serializable id) {
		return getById(TestUser.class, id);
	}
}
