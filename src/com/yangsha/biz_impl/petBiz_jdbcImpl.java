package com.yangsha.biz_impl;

import java.util.List;
import java.util.Map;

import com.yangsha.biz_interface.IpetBiz;
import com.yangsha.dao_impl.PetDaoImpl;
import com.yangsha.dao_interface.IPetDao;
import com.yangsha.entity.Pet;

public class petBiz_jdbcImpl implements IpetBiz {

    IPetDao dao=new PetDaoImpl();

	@Override
	public int add(Pet t) {
		// TODO Auto-generated method stub
		return dao.add(t);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public int update(Pet t) {
		// TODO Auto-generated method stub
		return dao.update(t);
	}

	@Override
	public Pet getEntityById(int id) {
		// TODO Auto-generated method stub
		return dao.getEntityById(id);
	}

	@Override
	public List<Pet> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<Pet> getPager(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return dao.getPager(map);
	}

	@Override
	public List<Pet> getPetByStoreId(int storeId) {
		// TODO Auto-generated method stub
		return dao.getPetByStoreId(storeId);
	}

	@Override
	public int updateByPrimaryKeySelective(Pet t) {
		// TODO Auto-generated method stub
		return 0;
	}	
	
	
}
