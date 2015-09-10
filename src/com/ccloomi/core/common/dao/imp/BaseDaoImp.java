package com.ccloomi.core.common.dao.imp;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
/**
 * 类名：BaseDaoImp
 * 描述：基础DAO实现用于注入BaseServiceImp中
 * 作者： Chenxj
 * 日期：2015年9月10日 - 下午3:32:52
 * @param <T>
 */
@Service("baseDao")
public class BaseDaoImp<T> extends AbstractBaseDao<T> implements BaseDao<T>{
	
}
