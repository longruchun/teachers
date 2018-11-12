package com.yangsha.entity;

public class Subject {
    int id;
    String name;
    int score;
    
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @param id
	 * @param name
	 * @param score
	 */
	public Subject(int id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	/**
	 * @param name
	 * @param score
	 */
	public Subject(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	/**
	 * 
	 */
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    
}
