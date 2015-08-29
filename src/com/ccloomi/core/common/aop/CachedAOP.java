package com.ccloomi.core.common.aop;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ccloomi.core.component.security.SecretUtil;
import com.ccloomi.core.util.StringUtil;
import com.whalin.MemCached.MemCachedClient;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：Cached
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年8月29日-上午7:31:44
 */
@Aspect
public class CachedAOP {
	private final Logger log=LoggerFactory.getLogger(getClass());
	@Autowired
	private MemCachedClient cachedClient;
	/**获取 cachedClient*/
	public MemCachedClient getCachedClient() {
		return cachedClient;
	}
	/**设置 cachedClient*/
	public void setCachedClient(MemCachedClient cachedClient) {
		this.cachedClient = cachedClient;
	}
	@Pointcut("execution(@com.ccloomi.core.annotation.Cacheable !void com.ccloomi.web.*.service.imp.*.*(..))")
	public void serverAroundPointcut(){};

	@Around("serverAroundPointcut()")
	public Object serverAround(ProceedingJoinPoint call) throws Throwable{
		MethodSignature ms=(MethodSignature) call.getSignature();
//		Object targetObj=call.getTarget();
		Object[]args=call.getArgs();
//		log.debug("拦截到{}::{}({})执行",targetObj.getClass(),ms.getMethod().getName(),StringUtil.join(",", args));
//		System.out.println(ms.toLongString());
		
		String key=SecretUtil.MD5(ms.toLongString()+StringUtil.join(",", args));
		if(cachedClient.keyExists(key)){
			log.debug("从缓存中获取数据::id=[{}]",key);
			return cachedClient.get(key);
		}else{
			Object obj=call.proceed();
			if(obj!=null){
				log.debug("将数据保存到缓存::id=[{}]",key);
				Calendar calendar=Calendar.getInstance();
				calendar.add(Calendar.SECOND, 10);
				cachedClient.set(key, obj,calendar.getTime());
				return obj;
			}
		}
		return null;
	}
}
