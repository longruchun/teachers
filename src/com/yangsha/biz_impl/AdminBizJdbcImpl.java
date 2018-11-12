package com.yangsha.biz_impl;

import java.util.List;
import java.util.Map;

import com.yangsha.biz_interface.IAdminBizable;
import com.yangsha.dao_impl.AdminDaoImpl;
import com.yangsha.dao_interface.IAdminDao;
import com.yangsha.entity.Admin;

public class AdminBizJdbcImpl implements IAdminBizable {

	IAdminDao dao=new AdminDaoImpl();
	
	@Override
	public int add(Admin t) {
		// TODO Auto-generated method stub
		return dao.add(t);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Admin t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Admin getEntityById(int id) {
		// TODO Auto-generated method stub
		return dao.getEntityById(id);
	}

	@Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Admin login(String name, String password) {
		// TODO Auto-generated method stub
		Admin admin=getEntityByName(name);
		if(admin!=null) {
			if(admin.getPassword().equals(password)) {
				return admin;
			}
		}
		return null;
	}

	@Override
	public Admin getEntityByName(String name) {
		// TODO Auto-generated method stub
		return dao.getEntityByName(name);
	}

	@Override
	public List<Admin> getPager(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Admin t) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(t);
	}

}
