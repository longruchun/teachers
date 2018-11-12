package com.yangsha.entity;

import java.util.Date;

public class Account {

	int id;
	int deal_type;
	int pet_Id;
	int sell_Id;
	int buy_Id;
	double price;
	Date deal_Time;
	public Account(int id, int deal_type, int pet_Id, int sell_Id, int buy_Id, double price, Date deal_Time) {
		super();
		this.id = id;
		this.deal_type = deal_type;
		this.pet_Id = pet_Id;
		this.sell_Id = sell_Id;
		this.buy_Id = buy_Id;
		this.price = price;
		this.deal_Time = deal_Time;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeal_type() {
		return deal_type;
	}
	public void setDeal_type(int deal_type) {
		this.deal_type = deal_type;
	}
	public int getPet_Id() {
		return pet_Id;
	}
	public void setPet_Id(int pet_Id) {
		this.pet_Id = pet_Id;
	}
	public int getSell_Id() {
		return sell_Id;
	}
	public void setSell_Id(int sell_Id) {
		this.sell_Id = sell_Id;
	}
	public int getBuy_Id() {
		return buy_Id;
	}
	public void setBuy_Id(int buy_Id) {
		this.buy_Id = buy_Id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDeal_Time() {
		return deal_Time;
	}
	public void setDeal_Time(Date deal_Time) {
		this.deal_Time = deal_Time;
	}
	
}
