package com.ccloomi.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：Cacheable
 * 类 描 述：开启缓存注解
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月29日-上午9:37:56
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cacheable {
	/**缓存时长,单位毫秒*/
	public long time() default -1;
}
