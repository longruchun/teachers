package com.yangsha.dao_impl;

import java.util.List;
import java.util.Map;

import com.yangsha.dao_interface.IAdminDao;
import com.yangsha.entity.Admin;
import com.yangsha.util.JdbcHelper;

public class AdminDaoImpl implements IAdminDao {

	
	
	@Override
	public int add(Admin t) {
		// TODO Auto-generated method stub
		String sql="insert into admin(name,password,roleid) values(?,?,?) ";
		Object[] args=new Object[] {t.getName(),t.getPassword(),t.getRoleid()};
		return JdbcHelper.executeUpdate(sql, args);
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
		String sql="select * from admin where id=?";
		Object[] args=new Object[] {id};
		List<Admin> list=JdbcHelper.executeQuery(sql,Admin.class, args);
		
		return list.size()==0?null:list.get(0);
	}

	@Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		String sql="select * from admin";
		List<Admin> list=JdbcHelper.executeQuery(sql,Admin.class);
		return list;
	}

	@Override
	public Admin getEntityByName(String name) {
		// TODO Auto-generated method stub
		String sql="select * from Admin where name=?";
		List<Admin> list=JdbcHelper.executeQuery(sql,Admin.class,name);
		return list.size()==0?null:list.get(0);
	}

	@Override
	public List<Admin> getPager(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Admin t) {
		// TODO Auto-generated method stub
		String sql="update admin set name=? , roleid=? where id=?";
		Object[] args=new Object[] {t.getName(),t.getRoleid(),t.getId()};
		int val=JdbcHelper.executeUpdate(sql, args);
		return val;
	}

}
