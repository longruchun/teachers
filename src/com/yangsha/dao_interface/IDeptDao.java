package com.yangsha.dao_interface;

import java.util.List;

import com.yangsha.entity.dept;
import com.yangsha.entity.deptitem;

public interface IDeptDao extends IBaseDao<deptitem> {
   List<deptitem> getItemsBypid(int pid);
   
   List<dept> getDept();
}
