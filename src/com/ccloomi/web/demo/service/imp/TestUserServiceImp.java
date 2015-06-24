package com.ccloomi.web.demo.service.imp;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.imp.BaseDaoImp;
import com.ccloomi.core.common.service.BaseService;
import com.ccloomi.web.demo.dao.TestUserDao;
import com.ccloomi.web.demo.entity.TestUser;
import com.ccloomi.web.demo.service.TestUserService;
/**
 * 类名：TestUserServiceImp
 * 描述：
 * 作者： Chenxj
 * 日期：2015年6月24日 - 下午1:37:31
 */
@Service("testUserService")
@Transactional
public class TestUserServiceImp extends BaseDaoImp<TestUser> implements BaseService<TestUser>,TestUserService {
	@Autowired
	private TestUserDao testUserDao;

	public TestUserDao getTestUserDao() {
		return testUserDao;
	}

	public void setTestUserDao(TestUserDao testUserDao) {
		this.testUserDao = testUserDao;
	}

	@Override
	public TestUser getUserById(Serializable id) {
		return this.testUserDao.getUserById(id);
	}

	@Override
	public Serializable saveTestUser(TestUser testUser) {
		return this.testUserDao.save(testUser);
	}

	@Override
	public void saveOrUpdateUser(TestUser testUser) {
		this.testUserDao.saveOrUpdate(testUser);
	}
	
}
