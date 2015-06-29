package com.ccloomi.core.common.dao.abstracted;

import java.io.Serializable;

//import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
/**
 * 类名：AbstractBaseDao
 * 描述：抽象持久化基类
 * 作者： Chenxj
 * 日期：2015年6月23日 - 下午4:11:37
 */
public abstract class AbstractBaseDao<T>{
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
	public T getById(Class<T> entityClass,Serializable id){
		return getHibernateTemplate().get(entityClass, id);
	}
}
