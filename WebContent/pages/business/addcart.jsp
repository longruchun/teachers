<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    //添加ajax传递 来的数据到购物车
    String petid=request.getParameter("petid");
    
    //我用一个HashMap 结构存储购物车数据 HashMap 键=>值   petid = > 1  
    //整个表示已选择宠物的hashMap 存入session 当中
    Map<String,Integer> map=(HashMap)session.getAttribute("CartList");
    if(map==null){
    	map=new HashMap<String,Integer>();
    }
    
    if(map.containsKey(petid)){
    	Integer num=map.get(petid)+1;
    	map.put(petid,num);
    }else{
    	map.put(petid,1);
    }
    
    session.setAttribute("CartList",map);
    
    for(String s:map.keySet()){
    	System.out.println(s+"==>"+map.get(s));
    }
    


    out.print(1);
%>