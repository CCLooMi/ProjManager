//package com.ccloomi.web.demo.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.ccloomi.web.demo.entity.TestUser;
//import com.whalin.MemCached.MemCachedClient;
//
//@Aspect
//public class Cached {
//	private final Logger log=LoggerFactory.getLogger(this.getClass());
//	@Autowired
//	private MemCachedClient memCachedClient;
//	
//	public MemCachedClient getMemCachedClient() {
//		return memCachedClient;
//	}
//	public void setMemCachedClient(MemCachedClient memCachedClient) {
//		this.memCachedClient = memCachedClient;
//	}
//	@Pointcut("execution(* com.ccloomi.web.demo.service.imp.*.get*(..))")
//	public void aPointcut(){
//		
//	}
//	public TestUser doGetTestUserByIdAround(ProceedingJoinPoint call,String id){
//		TestUser testUser=null;
//		
//		if(memCachedClient.keyExists(id)){
//			testUser=(TestUser) memCachedClient.get(id);
//			log.debug("=======================:从缓存中获取:", testUser);
//		}else{
//			try{
//				testUser=(TestUser) call.proceed();
//				if(testUser!=null){
//					memCachedClient.set(id, testUser);
//					log.debug("=======================:保存到缓存:", testUser);
//				}
//			}catch(Throwable e){
//				e.printStackTrace();
//			}
//		}
//		
//		return testUser;
//	}
//}
