package com.yangsha.dao_impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.yangsha.dao_interface.IMenuDao;
import com.yangsha.dao_interface.IRoleDao;
import com.yangsha.entity.role;
import com.yangsha.util.JdbcHelper;
import com.yangsha.util.menu.menu;
import com.yangsha.util.menu.menu2;
import com.yangsha.util.menu.menuitem;

public class MenuDaoImpl implements IMenuDao {

	@Override
	public List<menu> getMenus(Map<String,Integer> map) {
		// TODO Auto-generated method stub
		List<menu> menus=new ArrayList<menu>();
		
		String Sql="select * from shop_menu where ishide=0 AND pid=?";
		
		Object[] params=new Object[] {0};
		
		List<menuitem> items=JdbcHelper.executeQuery(Sql,menuitem.class,params);
		
				
		for(int i=0;i<items.size();i++) {
			if(map.values().contains(items.get(i).getId())) {
			   menus.add(getMenu(items.get(i).getId(),map));
			}
		}
		
		
		return menus;
	}
	
	
	/**
	 * 
	 * @param menuId---一个菜单项的id,方法将返回这个id 的菜单的所有一级子菜单，二级子菜单......无限级子菜单
	 *                  查询以menuId 为根节点的所有子孙万代子节点
	 * @return
	 * map --- 结构说明:map键 值 对中装的是:键是一个resource_id(就是menuid,之所以做成map,是在运行时，在多个roleid间排重)
	 *         值就是整型 的resource_id
	 */
	private menu getMenu(int menuId,Map<String,Integer> map) {
		//实例化一个以menuId为id 的menu的实例对象
		menu menuNode=new menu();
		
		menuitem item=new menuitem();
		List<menu> childitems=new ArrayList<menu>();
	
		
		//编辑sql语句，查出menuId菜单项的详细信息
		String Sql="select * from shop_menu where ishide=0 AND id=?";
        Object[] params=new Object[] {menuId};
        List<menuitem> menuitems=new ArrayList<menuitem>();
 	    menuitems=JdbcHelper.executeQuery(Sql,menuitem.class,params);
 	    item=menuitems.get(0);
 	    menuNode.setItem(item);
 
 	    String Sql_sub="select * from shop_menu where ishide=0 AND pid=?";
 	    Object[] params_sub=new Object[] {menuId};
 	    List<menuitem> sub_menuitems=new ArrayList<menuitem>(); 
 	    sub_menuitems=JdbcHelper.executeQuery(Sql_sub,menuitem.class,params_sub);//儿子这一层的菜单全部在这里边
 	    for(int i=0;i<sub_menuitems.size();i++) {
 	    	if(map.values().contains(sub_menuitems.get(i).getId())) {
 	    	   childitems.add(getMenu(sub_menuitems.get(i).getId(),map));
 	    	}
 	    }
 	    menuNode.setChilditems(childitems);
 	    menuNode.setHasChildrens(childitems.size()>0);
 		return menuNode;
	}

	@Override
	public List<menu2> getMenus2() {
		// TODO Auto-generated method stub
		List<menu2> menus=new ArrayList<menu2>();
		
		String Sql="select * from shop_menu where pid=?";
		Object[] params=new Object[] {0};
		List<menuitem> items=JdbcHelper.executeQuery(Sql,menuitem.class,params);
		for(int i=0;i<items.size();i++) {
			menus.add(getMenu2(items.get(i).getId()));
		}
		
		
		return menus;
	}
	
	
	/**
	 * 
	 * @param menuId---一个菜单项的id,方法将返回这个id 的菜单的所有一级子菜单，二级子菜单......无限级子菜单
	 *                  查询以menuId 为根节点的所有子孙万代子节点
	 * @return
	 */
	private menu2 getMenu2(int menuId) {
		//实例化一个以menuId为id 的menu的实例对象
		menu2 menuNode=new menu2();
		
		menuitem item=new menuitem();
		List<menu2> nodes=new ArrayList<menu2>();
	
		
		//编辑sql语句，查出menuId菜单项的详细信息
		String Sql="select * from shop_menu where id=?";
        Object[] params=new Object[] {menuId};
        List<menuitem> menuitems=new ArrayList<menuitem>();
 	    menuitems=JdbcHelper.executeQuery(Sql,menuitem.class,params);
 	    item=menuitems.get(0);
 	    
 	    menuNode.setId(item.getId());
 	    menuNode.setText(item.getText());
 	    menuNode.setHref(item.getHref());
 
 	    String Sql_sub="select * from shop_menu where pid=?";
 	    Object[] params_sub=new Object[] {menuId};
 	    List<menuitem> sub_menuitems=new ArrayList<menuitem>(); 
 	    sub_menuitems=JdbcHelper.executeQuery(Sql_sub,menuitem.class,params_sub);//儿子这一层的菜单全部在这里边
 	    for(int i=0;i<sub_menuitems.size();i++) {
 	    	nodes.add(getMenu2(sub_menuitems.get(i).getId()));
 	    	
 	    }
 	    menuNode.setNodes(nodes);
 	   
 		return menuNode;
	}


	@Override
	public Set<String> getPermission(String roleids) {
		// TODO Auto-generated method stub
		//1  声明 Set<String> set
		Set<String> set=new HashSet<String>();
		
		//2 通过roleids获取所有的resource，将其中的permission字段值 装入set
		String[] role_Ids=roleids.split(",");
		IRoleDao role_dao=new RoleDaoImpl();
		
		for(int i=0;i<role_Ids.length;i++) {
			//调用role_dao中的方法，根据一个roleid获取一个role
			role role_=role_dao.getEntityById(Integer.parseInt(role_Ids[i]));
			String resource_ids=role_.getResource_ids();
			String[] R_Ids=resource_ids.split(",");
			
			for(int j=0;j<R_Ids.length;j++) {
				menuitem item=getMenuItemById(Integer.parseInt(R_Ids[j]));
				if(item!=null) {
					set.add(item.getPermission());
				}
			}
		}
		
		
		
		return set;
	}
	
	
	public menuitem getMenuItemById(int resourceid) {
		
		String sql="select * from shop_menu where id=?";
		Object[] args=new Object[] {resourceid};
		List<menuitem> list=JdbcHelper.executeQuery(sql,menuitem.class, args);
		return list.size()==0?null:list.get(0);
	}
	
	public List<menuitem> getAll(){
		String sql="select * from shop_menu order by sort";
		
		List<menuitem> list=JdbcHelper.executeQuery(sql,menuitem.class);
		return list;
	}


	@Override
	public menuitem getEntityById(int id) {
        String sql="select * from shop_menu where id=?";
		Object[] args=new Object[] {id};
		List<menuitem> list=JdbcHelper.executeQuery(sql,menuitem.class,args);
		return list.size()==0?null:list.get(0);
	}


	
}
