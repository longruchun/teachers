package com.yangsha.biz_interface;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yangsha.util.menu.menu;
import com.yangsha.util.menu.menu2;
import com.yangsha.util.menu.menuitem;

public interface IMenuBiz {
	List<menu> getMenus(Map<String,Integer> map);
	
	List<menu2> getMenus2();
	
	Set<String> getPermission(String roleids);
	
	public List<menuitem> getAll();
	
	menuitem getEntityById(int id);
}
