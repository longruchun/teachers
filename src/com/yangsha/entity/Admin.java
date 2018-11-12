package com.yangsha.entity;

public class Admin {
   long id;
   String name;
   String password;
   String roleid;
   
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param roleid
	 */
	public Admin(long id, String name, String password, String roleid) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.roleid = roleid;
	}
	/**
	 * @param name
	 * @param password
	 * @param roleid
	 */
	public Admin(String name, String password, String roleid) {
		super();
		this.name = name;
		this.password = password;
		this.roleid = roleid;
	}
	/**
	 * 
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param name
	 * @param roleid
	 */
	public Admin(long id, String name, String roleid) {
		super();
		this.id = id;
		this.name = name;
		this.roleid = roleid;
	}

   
   
}
