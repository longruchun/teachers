package com.yangsha.dao_impl;

import java.util.List;
import java.util.Map;

import com.yangsha.dao_interface.IPetOwnerDao;
import com.yangsha.entity.Pet;
import com.yangsha.entity.PetOwner;
import com.yangsha.util.JdbcHelper;

public class PetOwnerDaoImpl implements IPetOwnerDao {

	@Override
	public int add(PetOwner t) {
		String sql = "insert into petOwner(name,password,money) values(?,?,?)";
		int i = JdbcHelper.executeUpdate(sql,t.getName(),t.getPassword(),t.getMoney());
		return i;
	}

	@Override
	public int delete(int id) {
		
		    String sql = "delete from petOwner where id=?";
	        int i =JdbcHelper.executeUpdate(sql, id);
			return i;
	}

	@Override
	public int update(PetOwner t) {
		
		String sql = "update petOwner set name=?,password=?,money=? where id=?";
        int i =JdbcHelper.executeUpdate(sql,t.getName(),t.getPassword(),t.getMoney(),t.getId());
		return i;
	}

	@Override
	public List<PetOwner> getAll() {
		String sql = "select * from petOwner";
		List<PetOwner> list = JdbcHelper.executeQuery(sql, PetOwner.class);
		return list;
	}

	@Override
	public PetOwner getEntityById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from petOwner where id=?";
		List<PetOwner> list = JdbcHelper.executeQuery(sql, PetOwner.class,id);
		return list.get(0)==null?null:list.get(0);
	}

	@Override
	public List<PetOwner> getPager(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(PetOwner t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
