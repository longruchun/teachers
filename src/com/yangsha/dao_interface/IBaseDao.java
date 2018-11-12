package com.yangsha.dao_interface;

import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {

	int add(T t);
	int delete(int id);
	int update(T t);
	
	int updateByPrimaryKeySelective(T t);
	
	T getEntityById(int id);
	List<T> getAll();
	
	/*
	 *  map.put("pageOffset",SystemContext.getPageOffset());
        map.put("pageSize",SystemContext.getPageSize());
		model.addAttribute("pagers",biz.getPager(map));
	 */
	//ȡ��ҳ���ݵķ���ͨ�÷���
	List<T> getPager(Map<String,Integer> map);
}
