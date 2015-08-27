package com.ccloomi.core.common.dao.abstracted;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

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
	private Class<T>entityClass;
	private String tableName;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public AbstractBaseDao(){
		this.entityClass=getEntityClass();
		Table table=entityClass.getDeclaredAnnotation(Table.class);
		this.tableName=(table==null?entityClass.getName():table.name());
	}
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
	 * 方法描述：获取T的Class
	 * 作者：Chenxj
	 * 日期：2015年7月6日 - 上午11:25:00
	 * @return Class
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass(){
		return (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
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
	public boolean delete(Serializable id){
		if(id!=null){
			String sql="DELETE FROM ? WHERE id=?".replaceFirst("\\?", tableName);
			int i=getJdbcTemplate().update(sql, id);
			return i>0?true:false;
		}else{
			log.error("ID不能为空");
		}
		return false;
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
	 * 描述：批量删除
	 * 作者：Chenxj
	 * 日期：2015年8月25日 - 上午12:01:47
	 * @param ids
	 */
	public int[] batchDelete(Collection<? extends Object>ids){
		if(ids!=null){
			List<Object[]>batchArgs=new ArrayList<Object[]>();
			for(Object id:ids){
				Object[]objs={id};
				batchArgs.add(objs);
			}
			String sql="DELETE FROM ? WHERE id=?".replaceFirst("\\?", tableName);
			int[] i=getJdbcTemplate().batchUpdate(sql, batchArgs);
			return i;
		}else{
			log.error("ID不能为空");
		}
		return new int[0];
	}
	/**
	 * 描述：批量添加
	 * 作者：Chenxj
	 * 日期：2015年8月25日 - 下午10:12:05
	 * @param entitys
	 * @return
	 */
	public List<Serializable> batchSave(Collection<T>entitys){
		List<Serializable>ids=new ArrayList<Serializable>();
		for(T entity:entitys){
			ids.add(getHibernateTemplate().save(entity));
		}
		return ids;
	}
	/**
	 * 描述：批量更新
	 * 作者：Chenxj
	 * 日期：2015年8月25日 - 下午10:26:24
	 * @param entitys
	 */
	public void batchUpdate(Collection<T>entitys){
		for(T entity:entitys){
			getHibernateTemplate().update(entity);
		}
	}
	/**
	 * 描述：批量添加或更新
	 * 作者：Chenxj
	 * 日期：2015年8月25日 - 下午10:25:20
	 * @param entitys
	 */
	public void batchSaveOrUpdate(Collection<T>entitys){
		for(T entity:entitys){
			getHibernateTemplate().saveOrUpdate(entity);
		}
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
	@Override
	public T getById(Serializable id){
		return getHibernateTemplate().get(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperties(Map<String, Object> propertyNameValues) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.allEq(propertyNameValues));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(String param,Object value) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq(param, value));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPropertyInValues(Map<String, Object[]> propertyNameValues) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		propertyNameValues.keySet();
		for(String key:propertyNameValues.keySet()){
			criteria.add(Restrictions.in(key,propertyNameValues.get(key)));
		}
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPropertyInValues(String propertyname,Object...Values){
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.in(propertyname,Values));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPropertyInValues(String propertyname,Collection<Object>Values){
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.in(propertyname,Values));
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object>findPropertyByPropertyInValues(Map<String, Object[]>propertyNameValues,String columnName){
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		for(String key:propertyNameValues.keySet()){
			criteria.add(Restrictions.in(key,propertyNameValues.get(key)));
		}
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property(columnName));
		criteria.setProjection(pl);
		return (List<Object>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findDistinctPropertyByPropertyInValuse(Map<String, Object[]> propertyNameValues,String columnName) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		for(String key:propertyNameValues.keySet()){
			criteria.add(Restrictions.in(key,propertyNameValues.get(key)));
		}
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.distinct(Projections.property(columnName)));
		criteria.setProjection(pl);
		return (List<Object>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]>findPropertiesByPropertyInValues(Map<String, Object[]>propertyNameValues,String...columnNames){
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		for(String key:propertyNameValues.keySet()){
			criteria.add(Restrictions.in(key,propertyNameValues.get(key)));
		}
		ProjectionList pl=Projections.projectionList();
		for(String propertyName:columnNames){
			pl.add(Projections.property(propertyName));
		}
		criteria.setProjection(pl);
		return (List<Object[]>) getHibernateTemplate().findByCriteria(criteria);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findPropertiesByProperties(Map<String, Object> propertyNameValues, String... columnNames) {
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
	public List<Object> findPropertyByProperties(Map<String, Object> propertyNameValues, String columnName) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.allEq(propertyNameValues));
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property(columnName));
		criteria.setProjection(pl);
		return (List<Object>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findPropertiesByProperty(String param, Object value, String... columnNames) {
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
	public List<Object> findPropertyByProperty(String param, Object value, String columnName) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq(param, value));
		ProjectionList pl=Projections.projectionList();
		pl.add(Projections.property(columnName));
		criteria.setProjection(pl);
		return (List<Object>) getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public Serializable selectCountByProperty(String propertyName, Object value) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.eq(propertyName, value));
		criteria.setProjection(Projections.rowCount());
		return (Serializable) getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@Override
	public Serializable selectCount() {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.setProjection(Projections.rowCount());
		return (Serializable) getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@Override
	public Serializable selectCountByProperties(Map<String, Object> propertyNameValues) {
		DetachedCriteria criteria=DetachedCriteria.forClass(entityClass);
		criteria.add(Restrictions.allEq(propertyNameValues));
		criteria.setProjection(Projections.rowCount());
		return (Serializable) getHibernateTemplate().findByCriteria(criteria).get(0);
	}
	
	@Override
	public List<?> findByCriteria(DetachedCriteria criteria){
		return getHibernateTemplate().findByCriteria(criteria);
	}
	
	@Override
	public List<?> findByCriteria(DetachedCriteria criteria,int firstResult,int maxResults){
		return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}
}
