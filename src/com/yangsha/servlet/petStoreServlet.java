package com.yangsha.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangsha.biz_impl.PetStoreBiz_impl;
import com.yangsha.biz_impl.petBiz_jdbcImpl;
import com.yangsha.biz_interface.IpetBiz;
import com.yangsha.biz_interface.PetStoreBiz_interface;
import com.yangsha.entity.Pet;
import com.yangsha.entity.PetStore;
import com.yangsha.util.Haspermission;
import com.yangsha.util.pager;

@WebServlet("/petStoreServlet")
public class petStoreServlet extends BaseServlet {
   public String checkPetStoreName(HttpServletRequest request,HttpServletResponse response) throws Exception {
	    request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		String name=request.getParameter("uname");
		
		if(name==null) {
			return null;
		}
		
		PetStoreBiz_interface biz=new PetStoreBiz_impl();
		
		boolean flag=biz.hasName(name);
		
		response.getWriter().print(flag);
	   
	    return "ajax";//说明该 方法是只能提供给ajax调用
   }
   
   public String storePet(HttpServletRequest request,HttpServletResponse response) throws Exception {
	        //我们实例化一个biz,就可以取出数据---List<Pet>
	 		//我们要做客户端渲染，不能够直接送List<Pet>到客户端，因为客户端并不认识Java的List<>数据结构
	 		//所以，我们需要把它转成JSON格式，再送---我们用工具转
	 		
	 		IpetBiz biz=new petBiz_jdbcImpl();
	 		
	 		String _store_Id=request.getParameter("store_Id");
	 		
	 		List<Pet> list=null;
	 		if(_store_Id!=null) {
	 		   list=biz.getPetByStoreId(Integer.parseInt(_store_Id));
	 		}
	 		
	          ObjectMapper mapper=new ObjectMapper();
	 		 
	 		 String myJson=mapper.writeValueAsString(list);
	 		
	 		//我们现在需要一个工具来将java 的集合转成JSON数组
	 		//System.out.println(myJson);
	 		response.setCharacterEncoding("utf-8");
	 		response.setContentType("text/json;charset=utf-8");
	 		response.getWriter().print(myJson);
	 		
	 		return "ajax";//说明该 方法是只能提供给ajax调用
   }
   
   
   @Haspermission("petStore:*")
   public String petStoreList(HttpServletRequest req,HttpServletResponse res) {
	        //实现分页逻辑
	 		PetStoreBiz_interface  biz =new PetStoreBiz_impl();
	         
	         //双查询参数取跳过条数及每页条数  这两个参数
	         int pageOffset=req.getParameter("pager.offset")==null?0:Integer.parseInt(req.getParameter("pager.offset"));
	         int pageSize=req.getParameter("pageSize")==null?4:Integer.parseInt(req.getParameter("pageSize"));
	         
	         Map<String,Integer> map=new HashMap<String,Integer>();
	         map.put("pageOffset", pageOffset);
	         map.put("pageSize",pageSize);
	         
	         List<PetStore> petStorelist=biz.getPager(map);//当前分页要渲染的数据
	         List<PetStore> totallist=biz.getAll();
	         
	         pager pager1=new pager();
	         pager1.setDatas(petStorelist);
	         pager1.setTotalRecord(totallist.size());
	         
	         req.setAttribute("pagers",pager1);
	         
	         return "/pages/petstore/petStorelist.jsp";
	         
	        
   }
}
