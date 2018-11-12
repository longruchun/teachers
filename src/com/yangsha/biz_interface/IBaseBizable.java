package com.yangsha.biz_interface;

import java.util.List;
import java.util.Map;

public interface IBaseBizable<T> {
	int add(T t);
	int delete(int id);
	int update(T t);
	int updateByPrimaryKeySelective(T t);
	T getEntityById(int id);
	List<T> getAll();
	
	List<T> getPager(Map<String,Integer> map);
	
	
}
