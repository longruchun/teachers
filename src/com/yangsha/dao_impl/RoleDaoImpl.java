package com.yangsha.dao_impl;

import java.util.List;
import java.util.Map;

import com.mysql.jdbc.JDBC4PreparedStatementHelper;
import com.yangsha.dao_interface.IRoleDao;
import com.yangsha.entity.role;
import com.yangsha.util.JdbcHelper;

public class RoleDaoImpl implements IRoleDao {

	@Override
	public int add(role t) {
		// TODO Auto-generated method stub
		//String sql="insert into role()"
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
		String sql="select * from role where id=?";
		Object[] params=new Object[] {id};
		List<role> list=JdbcHelper.executeQuery(sql,role.class,params);
		return list.size()==0?null:list.get(0);
	}

	@Override
	public List<role> getAll() {
		// TODO Auto-generated method stub
		String sql="select * from role";
		List<role> list=JdbcHelper.executeQuery(sql,role.class);
		return list;
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
