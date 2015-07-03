package com.ccloomi.core.common.dao.imp;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.allEq(propertyNameValues));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(Class<T> entityClass, String param,Object value) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq(param, value));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findPropertiesByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues, String... columnNames) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.allEq(propertyNameValues));
		ProjectionList pl=Projections.projectionList();
		for(String propertyName:columnNames){
			pl.add(Projections.property(propertyName));
		}
		criteria.setProjection(pl);
		return (List<Object[]>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findPropertyByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues, String columnName) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.allEq(propertyNameValues));
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property(columnName));
		criteria.setProjection(pl);
		return (List<Object>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findPropertiesByProperty(Class<T> entityClass,String param, String value, String... columnNames) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq(param, value));
		ProjectionList pl=Projections.projectionList();
		for(String propertyName:columnNames){
			pl.add(Projections.property(propertyName));
		}
		criteria.setProjection(pl);
		return (List<Object[]>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findPropertyByProperty(Class<T> entityClass,String param, String value, String columnName) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq(param, value));
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property(columnName));
		criteria.setProjection(pl);
		return (List<Object>) getHibernateTemplate().findByCriteria(criteria);
	}
}
