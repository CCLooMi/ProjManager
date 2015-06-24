package com.ccloomi.core.common.dao.imp;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
/**
 * 类名：BaseDaoImp
 * 描述：BaseDao实现类
 * 作者： Chenxj
 * 日期：2015年6月23日 - 下午4:13:47
 */
@Service("baseDao")
public class BaseDaoImp<T> extends AbstractBaseDao<T> implements BaseDao<T>{
	
}
