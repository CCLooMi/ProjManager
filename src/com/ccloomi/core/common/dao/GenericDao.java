package com.ccloomi.core.common.dao;

import org.springframework.stereotype.Service;
/**
 * 类名：BaseDaoImp
 * 描述：基础DAO实现用于注入BaseServiceImp中
 * 作者： Chenxj
 * 日期：2015年9月10日 - 下午3:32:52
 * @param <T>
 */
@Service("baseDao")
public class GenericDao<T> extends AbstractDao<T> implements BaseDao<T>{
	
}
