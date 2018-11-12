package com.yangsha.entity;

public class deptitem {
    //×Ö¶Î±äÁ¿
	int id;
    int pid;
    String pids;
    String text;
    
    public boolean isRootNode() {
		return pid==0;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @param id
	 * @param pid
	 * @param pids
	 * @param text
	 */
	public deptitem(int id, int pid, String pids, String text) {
		super();
		this.id = id;
		this.pid = pid;
		this.pids = pids;
		this.text = text;
	}

	/**
	 * @param pid
	 * @param pids
	 * @param text
	 */
	public deptitem(int pid, String pids, String text) {
		super();
		this.pid = pid;
		this.pids = pids;
		this.text = text;
	}

	/**
	 * 
	 */
	public deptitem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
