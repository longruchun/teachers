package com.yangsha.util.menu;


import java.util.List;

/**
 *  �˵���ʵ����
 * @author Administrator
 *
 */
public class menu {
   menuitem item;//��ǰ�˵���---��¼����title,url����Ϣ
   
   List<menu> childitems;//װ����˵��ļ��ϣ����û������˵���� ����Ϊ��
   boolean hasChildrens;//������Ա�����ǰ�˵����Ƿ�������˵�
   
   
   

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
