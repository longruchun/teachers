package com.yangsha.util.menu;


import java.util.List;

/**
 *  �˵���ʵ����
 * @author Administrator
 *
 */
public class menu2 {
  
	   int id;

	   String text;
	   String href;	
   
       List<menu2> nodes;//װ����˵��ļ��ϣ����û������˵���� ����Ϊ��

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<menu2> getNodes() {
		return nodes;
	}

	public void setNodes(List<menu2> nodes) {
		this.nodes = nodes;
	}

	/**
	 * @param id
	 * @param text
	 * @param href
	 * @param nodes
	 */
	public menu2(int id, String text, String href, List<menu2> nodes) {
		super();
		this.id = id;
		this.text = text;
		this.href = href;
		this.nodes = nodes;
	}

	/**
	 * @param text
	 * @param href
	 * @param nodes
	 */
	public menu2(String text, String href, List<menu2> nodes) {
		super();
		this.text = text;
		this.href = href;
		this.nodes = nodes;
	}

	/**
	 * 
	 */
	public menu2() {
		super();
		// TODO Auto-generated constructor stub
	}
       
       


	
   
}
