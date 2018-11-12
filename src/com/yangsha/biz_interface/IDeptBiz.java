package com.yangsha.biz_interface;

import java.util.List;

import com.yangsha.entity.dept;
import com.yangsha.entity.deptitem;

public interface IDeptBiz extends IBaseBizable<deptitem>{
	List<deptitem> getItemsBypid(int pid);
	List<dept> getDept();
}
