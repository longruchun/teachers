package com.yangsha.biz_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yangsha.biz_interface.IDeptBiz;
import com.yangsha.dao_impl.DeptDaoImpl;
import com.yangsha.dao_interface.IDeptDao;
import com.yangsha.entity.dept;
import com.yangsha.entity.deptitem;

public class DeptBizImpl implements IDeptBiz {
    IDeptDao dao=new DeptDaoImpl();

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
		return dao.getEntityById(id);
	}

	@Override
	public List<deptitem> getAll() {
		// TODO Auto-generated method stub
		List<deptitem> result=new ArrayList<deptitem>();
		List<deptitem> all= dao.getAll();
		List<deptitem> work_= new ArrayList<deptitem>();
		for(int i=0;i<all.size();i++) {
		    if(all.get(i).getPid()==0) {
		    	work_.add(all.get(i));
		    }
		}
		
		result=sort(result,work_,all);
		
		return result;
	}
	
	private List<deptitem> sort(List<deptitem> result,List<deptitem> works,List<deptitem> all){

		while(works.size()>0) {
			deptitem item=works.remove(0);
			result.add(item);
			List<deptitem> work_=new ArrayList<deptitem>();
			for(int i=0;i<all.size();i++) {
				if(all.get(i).getPid()==item.getId()) {
					work_.add(all.get(i));
				}
			}
			
			if(work_.size()>0) {
				result=sort(result,work_,all);
			}
		}
		
		return result;

	}
	

	@Override
	public List<deptitem> getPager(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<deptitem> getItemsBypid(int pid) {
		// TODO Auto-generated method stub
		return dao.getItemsBypid(pid);
	}

	@Override
	public List<dept> getDept() {
		// TODO Auto-generated method stub
		return dao.getDept();
	}

	@Override
	public int updateByPrimaryKeySelective(deptitem t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
