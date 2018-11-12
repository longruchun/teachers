package com.yangsha.entity;

public class role {
   int id;
   String rolename;
   String desc;
   String resource_ids;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRolename() {
	return rolename;
}
public void setRolename(String rolename) {
	this.rolename = rolename;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getResource_ids() {
	return resource_ids;
}
public void setResource_ids(String resource_ids) {
	this.resource_ids = resource_ids;
}
/**
 * @param id
 * @param rolename
 * @param desc
 * @param resource_ids
 */
public role(int id, String rolename, String desc, String resource_ids) {
	super();
	this.id = id;
	this.rolename = rolename;
	this.desc = desc;
	this.resource_ids = resource_ids;
}
/**
 * @param rolename
 * @param desc
 * @param resource_ids
 */
public role(String rolename, String desc, String resource_ids) {
	super();
	this.rolename = rolename;
	this.desc = desc;
	this.resource_ids = resource_ids;
}
/**
 * 
 */
public role() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
	
}
