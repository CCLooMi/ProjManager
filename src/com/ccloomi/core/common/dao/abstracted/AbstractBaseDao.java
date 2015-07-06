package com.ccloomi.core.common.dao.abstracted;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.ccloomi.core.common.dao.BaseDao;
/**
 * 类名：AbstractBaseDao
 * 描述：抽象持久化基类
 * 作者： Chenxj
 * 日期：2015年6月23日 - 下午4:11:37
 */
public abstract class AbstractBaseDao<T> implements BaseDao<T>{
	protected final Logger log=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	/**
	 * 获取：jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	/**
	 * 设置：jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/**
	 * 获取：hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	/**
	 * 设置：hibernateTemplate
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	/**
	 * 方法描述：添加对象
	 * 作        者：Chenxj
	 * 日        期：2015年6月23日-上午11:46:46
	 * @param entity
	 * @return
	 */
	public Serializable save(T entity){
		return getHibernateTemplate().save(entity);
	}
	/**
	 * 方法描述：修改对象操作
	 * 作        者：Chenxj
	 * 日        期：2015年6月23日-上午11:46:59
	 * @param entity
	 */
	public void update(T entity){
		getHibernateTemplate().update(entity);
	}
	/**
	 * 方法描述：根据ID删除对象操作
	 * 作        者：Chenxj
	 * 日        期：2015年6月23日-上午11:47:14
	 * @param id
	 */
	public void delete(Serializable id){
		
	}
	/**
	 * 方法描述：删除对象操作
	 * 作        者：Chenxj
	 * 日        期：2015年6月23日-下午2:45:49
	 * @param entity
	 */
	public void delete(T entity){
		getHibernateTemplate().delete(entity);
	}
	/**
	 * 方法描述：添加或修改操作
	 * 作        者：Chenxj
	 * 日        期：2015年6月23日-上午11:47:25
	 * @param entity
	 */
	public void saveOrUpdate(T entity){
		getHibernateTemplate().saveOrUpdate(entity);
	}
	/**
	 * 方法描述：通过ID查找对象
	 * 作        者：Chenxj
	 * 日        期：2015年6月24日-上午11:56:33
	 * @param entityClass
	 * @param id
	 * @return
	 */
	protected T getById(Class<T> entityClass,Serializable id){
		return getHibernateTemplate().get(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.allEq(propertyNameValues));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByProperty(Class<T> entityClass, String param,Object value) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq(param, value));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	protected List<Object[]> findPropertiesByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues, String... columnNames) {
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
	protected List<Object> findPropertyByProperties(Class<T> entityClass,Map<String, Object> propertyNameValues, String columnName) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.allEq(propertyNameValues));
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property(columnName));
		criteria.setProjection(pl);
		return (List<Object>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	protected List<Object[]> findPropertiesByProperty(Class<T> entityClass,String param, Object value, String... columnNames) {
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
	protected List<Object> findPropertyByProperty(Class<T> entityClass,String param, Object value, String columnName) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq(param, value));
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property(columnName));
		criteria.setProjection(pl);
		return (List<Object>) getHibernateTemplate().findByCriteria(criteria);
	}
}
