package com.yangsha.biz_impl;

import java.util.List;
import java.util.Map;

import com.yangsha.biz_interface.IroleBiz;

import com.yangsha.dao_impl.RoleDaoImpl;
import com.yangsha.dao_interface.IRoleDao;
import com.yangsha.entity.role;

public class roleBizImpl implements IroleBiz {
    
	IRoleDao dao=new RoleDaoImpl();

	@Override
	public int add(role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public role getEntityById(int id) {
		// TODO Auto-generated method stub
		return dao.getEntityById(id);
	}

	@Override
	public List<role> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<role> getPager(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(role t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
