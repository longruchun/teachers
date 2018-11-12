package com.yangsha.util.menu;

/**
 * ≤Àµ•œÓ¿‡
 * @author Administrator
 *
 */
public class menuitem {
   int id;
   int pid;
   String pids;
   
   String clazz;
   
   int ishide;
  
   String permission;
   String text;
   String href;
   
   int sort;
   
   
   
   public int getSort() {
	return sort;
}
public void setSort(int sort) {
	this.sort = sort;
}

boolean rootNode;
   
   
public boolean isRootNode() {
	return pid==0;
}
public void setRootNode(boolean rootNode) {
	this.rootNode = rootNode;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPids() {
	return pids;
}
public void setPids(String pids) {
	this.pids = pids;
}
public String getClazz() {
	return clazz;
}
public void setClazz(String clazz) {
	this.clazz = clazz;
}
public int getIshide() {
	return ishide;
}
public void setIshide(int ishide) {
	this.ishide = ishide;
}
public String getPermission() {
	return permission;
}
public void setPermission(String permission) {
	this.permission = permission;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getHref() {
	return href;
}
public void setHref(String href) {
	this.href = href;
}
/**
 * @param id
 * @param pid
 * @param pids
 * @param clazz
 * @param ishide
 * @param permission
 * @param text
 * @param href
 */
public menuitem(int id, int pid, String pids, String clazz, int ishide, String permission, String text, String href) {
	super();
	this.id = id;
	this.pid = pid;
	this.pids = pids;
	this.clazz = clazz;
	this.ishide = ishide;
	this.permission = permission;
	this.text = text;
	this.href = href;
}
/**
 * @param pid
 * @param pids
 * @param clazz
 * @param ishide
 * @param permission
 * @param text
 * @param href
 */
public menuitem(int pid, String pids, String clazz, int ishide, String permission, String text, String href) {
	super();
	this.pid = pid;
	this.pids = pids;
	this.clazz = clazz;
	this.ishide = ishide;
	this.permission = permission;
	this.text = text;
	this.href = href;
}
/**
 * 
 */
public menuitem() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
   

}
