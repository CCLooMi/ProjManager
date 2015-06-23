package com.ccloomi.core.common.service.imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.service.BaseService;
/**
 * 类名：BaseServiceImp
 * 描述：基础服务实现类
 * 作者： Chenxj
 * 日期：2015年6月23日 - 下午4:20:02
 */
@Service("baseService")
@Transactional
public class BaseServiceImp implements BaseService{
	@Autowired
	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
}
