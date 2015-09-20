package com.ccloomi.core.common.service;

import org.springframework.stereotype.Service;
/**
 * 类名：GenericService
 * 描述：抽象服务类通用服务实现类
 * 作者： Chenxj
 * 日期：2015年9月10日 - 下午3:34:43
 * @param <T>
 */
@Service("baseService")
public class GenericService<T> extends AbstractService<T> implements BaseService<T>{
	
}
