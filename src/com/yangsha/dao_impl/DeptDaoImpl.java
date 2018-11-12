package com.yangsha.dao_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.JDBC4PreparedStatementHelper;
import com.yangsha.dao_interface.IDeptDao;
import com.yangsha.entity.dept;
import com.yangsha.entity.deptitem;
import com.yangsha.util.JdbcHelper;

public class DeptDaoImpl implements IDeptDao {

	@Override
	public int add(deptitem t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(deptitem t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public deptitem getEntityById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from dept where id=?";
		Object[] args=new Object[] {id};
		List<deptitem> list=JdbcHelper.executeQuery(sql,deptitem.class,args);
		return list.size()==0?null:list.get(0);
	}

	@Override
	public List<deptitem> getAll() {
		// TODO Auto-generated method stub
		String sql="select * from dept";
		List<deptitem> list=JdbcHelper.executeQuery(sql, deptitem.class);
		
		return list;
	}

	@Override
	public List<deptitem> getPager(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<deptitem> getItemsBypid(int pid) {
		// TODO Auto-generated method stub
		String sql="select * from dept where pid=?";
		Object[] args=new Object[] {pid};
		List<deptitem> list=JdbcHelper.executeQuery(sql,deptitem.class,args);
		return list;
	}

	@Override
	public List<dept> getDept() {
		// TODO Auto-generated method stub
		List<dept> lists=new ArrayList<dept>();
		
		List<deptitem> top_items=getItemsBypid(0);
		for(int i=0;i<top_items.size();i++) {
			lists.add(getDept(top_items.get(i).getId()));
		}
		
		
		
		return lists;
	}
	
	//ตÝน้
	private dept getDept(int deptid) {
		dept dept_=new dept();
		
		deptitem item=new deptitem();
		List<dept> nodes=new ArrayList<dept>();
		
		item=getEntityById(deptid);
		dept_.setId(item.getId());
		dept_.setPid(item.getPid());
		dept_.setPids(item.getPids());
		dept_.setText(item.getText());
		
		
		
		List<deptitem> childitems=getItemsBypid(deptid);
		if(childitems.size()>0) {
			for(int i=0;i<childitems.size();i++) {
				dept childdept=getDept(childitems.get(i).getId());
				nodes.add(childdept);
			}
			
		}
		
		dept_.setNodes(nodes);
		
		
		return dept_;
	}

	@Override
	public int updateByPrimaryKeySelective(deptitem t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
