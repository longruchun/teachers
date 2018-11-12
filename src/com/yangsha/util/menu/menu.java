package com.yangsha.util.menu;


import java.util.List;

/**
 *  菜单的实体类
 * @author Administrator
 *
 */
public class menu {
   menuitem item;//当前菜单项---记录得有title,url等信息
   
   List<menu> childitems;//装子孙菜单的集合，如果没有子孙菜单则该 集合为空
   boolean hasChildrens;//这个属性表明当前菜单项是否有子孙菜单
   
   
   

	public menuitem getItem() {
		return item;
	}
	
	public void setItem(menuitem item) {
		this.item = item;
	}
	
	public List<menu> getChilditems() {
		return childitems;
	}
	
	public void setChilditems(List<menu> childitems) {
		this.childitems = childitems;
	}
	
	public boolean isHasChildrens() {
		return hasChildrens;
	}
	
	public void setHasChildrens(boolean hasChildrens) {
		this.hasChildrens = hasChildrens;
	}

	/**
	 * @param item
	 * @param childitems
	 * @param hasChildrens
	 */
	public menu(menuitem item, List<menu> childitems, boolean hasChildrens) {
		super();
		this.item = item;
		this.childitems = childitems;
		this.hasChildrens = hasChildrens;
	}

	/**
	 * @param childitems
	 * @param hasChildrens
	 */
	public menu(List<menu> childitems, boolean hasChildrens) {
		super();
		this.childitems = childitems;
		this.hasChildrens = hasChildrens;
	}

	/**
	 * 
	 */
	public menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
   
   

	
   
}
