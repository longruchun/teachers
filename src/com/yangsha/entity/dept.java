package com.yangsha.entity;

import java.util.List;

public class dept {
	int id;
    int pid;
    String pids;
    String text;
    
    List<dept> nodes;
    
    
  

	

	

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

	public List<dept> getNodes() {
		return nodes;
	}

	public void setNodes(List<dept> nodes) {
		this.nodes = nodes;
	}

	
	

	/**
	 * 
	 */
	public dept() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
