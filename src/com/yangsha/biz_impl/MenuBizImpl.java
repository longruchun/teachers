package com.yangsha.biz_impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yangsha.biz_interface.IMenuBiz;
import com.yangsha.dao_impl.MenuDaoImpl;
import com.yangsha.dao_interface.IMenuDao;
import com.yangsha.util.menu.menu;
import com.yangsha.util.menu.menu2;
import com.yangsha.util.menu.menuitem;

public class MenuBizImpl implements IMenuBiz {
    IMenuDao dao=new MenuDaoImpl();
	@Override
	public List<menu> getMenus(Map<String,Integer> map) {
		// TODO Auto-generated method stub
		return dao.getMenus(map);
	}
	@Override
	public List<menu2> getMenus2() {
		// TODO Auto-generated method stub
		return dao.getMenus2();
	}
	@Override
	public Set<String> getPermission(String roleids) {
		// TODO Auto-generated method stub
		return dao.getPermission(roleids);
	}
	
	public List<menuitem> getAll(){
		return dao.getAll();
	}
	@Override
	public menuitem getEntityById(int id) {
		// TODO Auto-generated method stub
		return dao.getEntityById(id);
	}

}
