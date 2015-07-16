package com.ccloomi.core.common.entity;

import javax.persistence.MappedSuperclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccloomi.core.common.bean.BaseBean;
import com.ccloomi.core.common.exception.PropertyNotExistInEntityException;
import com.ccloomi.core.util.StringUtil;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：BaseEntity
 * 类 描 述：抽象基础实体
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月15日-下午8:24:32
 */
public abstract class BaseEntity extends BaseBean{
	private static final long serialVersionUID = 7576292943312235832L;
	protected final Logger log=LoggerFactory.getLogger(getClass());
	public String getProperty(String name){
		return getProperty(getClass(), name);
	}
	private String getProperty(Class<?>c,String name){
		String pname=null;
		try {
			pname=c.getDeclaredField(name).getName();
		} catch (NoSuchFieldException e) {
			if(superClassHasMappedSuperclassAnnotation(c)){
				pname=getProperty(c.getSuperclass(), name);
			}else{
				log.error(StringUtil.format("在?中找不到属性：?", getClass().getName(),name), new PropertyNotExistInEntityException());
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return pname;
	}
	private boolean superClassHasMappedSuperclassAnnotation(Class<?>c){
		return c.getSuperclass().getDeclaredAnnotation(MappedSuperclass.class)==null?false:true;
	}
}
