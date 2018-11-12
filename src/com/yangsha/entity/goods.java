package com.yangsha.entity;

public class goods {
	long id;
	String goods_name;
	double sell_price;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	
	public double getSell_price() {
		return sell_price;
	}
	
	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}
	/**
	 * @param id
	 * @param goods_name
	 * @param store_nums
	 * @param sell_price
	 */
	public goods(long id, String goods_name, double sell_price) {
		super();
		this.id = id;
		this.goods_name = goods_name;
		
		this.sell_price = sell_price;
	}
	/**
	 * 
	 */
	public goods() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	

	
	
}
