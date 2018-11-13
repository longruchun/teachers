package com.yangsha.dao_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.JDBC4PreparedStatementHelper;
import com.yangsha.dao_interface.IRoleDao;
import com.yangsha.entity.role;
import com.yangsha.util.JdbcHelper;

public class RoleDaoImpl implements IRoleDao {

	@Override
	public int add(role t) {
        List params=new ArrayList();
		
		String sql_head="insert into role(rolename,resource_ids,";
		String sql_tail=" values(?,?,";
		params.add(t.getRolename());
		params.add(t.getResource_ids());
		if(t.getDesc()!="") {
			sql_head+="desc,";
			sql_tail+="?,";
			params.add(t.getDesc());
		}
		
		sql_head=sql_head.substring(0,sql_head.length()-1);
		sql_tail=sql_tail.substring(0,sql_tail.length()-1);
		String sql=sql_head+")"+sql_tail+")";
		
		int val=JdbcHelper.executeUpdate(sql,params.toArray());
		return val;
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
		List params=new ArrayList();
		
		String sql="update role set rolename=?,";
		params.add(t.getRolename());
		if(t.getDesc()!="") {
			sql+="desc=?,";
			params.add(t.getDesc());
		}
		if(t.getResource_ids()!="") {
			sql+="resource_ids=?,";
			params.add(t.getResource_ids());
		}
		sql=sql.substring(0,sql.length()-1);
		sql+=" where id=?";
		params.add(t.getId());
		int val=JdbcHelper.executeUpdate(sql,params.toArray());
		return val;
	}

}
