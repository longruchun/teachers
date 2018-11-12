package com.yangsha.biz_impl;

import java.util.List;
import java.util.Map;

import com.yangsha.biz_interface.PetOwnerBiz_interface;
import com.yangsha.biz_interface.PetStoreBiz_interface;
import com.yangsha.dao_impl.PetStoreDaoImpl;
import com.yangsha.dao_interface.IPetStoreDao;
import com.yangsha.entity.Account;
import com.yangsha.entity.Pet;
import com.yangsha.entity.PetOwner;
import com.yangsha.entity.PetStore;

public class PetStoreBiz_impl implements PetStoreBiz_interface {
 
	IPetStoreDao dao=new PetStoreDaoImpl();
	
	@Override
	public void sell(Pet pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buy(Pet pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pet breed(String petType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccountint(int store_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PetStore login() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PetStore> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public int add(PetStore t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(PetStore t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PetStore getEntityById(int id) {
		// TODO Auto-generated method stub
		return dao.getEntityById(id);
	}

	@Override
	public List<PetStore> getPager(Map<String, Integer> map) {
		return dao.getPager(map);
	}

	@Override
	public boolean hasName(String name) {
		// TODO Auto-generated method stub
		return dao.hasName(name);
	}

	@Override
	public int updateByPrimaryKeySelective(PetStore t) {
		// TODO Auto-generated method stub
		return 0;
	}


}
