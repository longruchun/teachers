package com.yangsha.entity;

public class PetOwner {

	int id;
	String name;
	String password;
	int money;
	public PetOwner(int id, String name, String password, int money) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.money = money;
	}
	public PetOwner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
