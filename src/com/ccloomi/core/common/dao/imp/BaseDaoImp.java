package com.ccloomi.core.common.dao.imp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ccloomi.core.common.dao.BaseDao;
import com.ccloomi.core.common.dao.abstracted.AbstractBaseDao;
import com.ccloomi.core.util.StringUtil;
/**
 * 类名：BaseDaoImp
 * 描述：BaseDao实现类
 * 作者： Chenxj
 * 日期：2015年6月23日 - 下午4:13:47
 */
@Service("baseDao")
public class BaseDaoImp<T> extends AbstractBaseDao<T> implements BaseDao<T>{
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperties(Class<T> entityClass, String[] params,Object[] values) {
		String queryString=StringUtil.joinString(" ", "from",entityClass.getSimpleName(),"where",StringUtil.joinString("=? ", params),"=?");
		log.debug(queryString);
		return (List<T>) getHibernateTemplate().find(queryString, values);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperties(Class<T> entityClass,Map<String, Object> map) {
		Object[]params=map.keySet().toArray();
		Object[]vals=map.values().toArray();
		String queryString=StringUtil.joinString(" ", "from",entityClass.getSimpleName(),"where",StringUtil.joinString("=? ", params),"=?");
		log.debug(queryString);
		return (List<T>) getHibernateTemplate().find(queryString, vals);
	}
}
