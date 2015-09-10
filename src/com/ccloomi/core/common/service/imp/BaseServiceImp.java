package com.ccloomi.core.common.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.service.BaseService;
import com.ccloomi.core.common.service.abstracted.AbstractBaseService;
/**
 * 类名：BaseServiceImp
 * 描述：
 * 作者： Chenxj
 * 日期：2015年9月10日 - 下午3:34:43
 * @param <T>
 */
@Service("baseService")
public class BaseServiceImp<T> extends AbstractBaseService<T> implements BaseService<T>{
	
	@Override
	protected BaseDao<T> getDao() {
		return this.baseDao;
	}
	
	/**注入BaseDaoImp，这样子类就不会强制要求重写getDao方法了,但是这就相当于每个service都注入了两个dao，一个是baseDao，一个是自己私有的dao*/
	@Autowired
	private BaseDao<T> baseDao;

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
}
