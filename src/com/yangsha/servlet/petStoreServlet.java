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
	   
	    return "ajax";//˵���� ������ֻ���ṩ��ajax����
   }
   
   public String storePet(HttpServletRequest request,HttpServletResponse response) throws Exception {
	        //����ʵ����һ��biz,�Ϳ���ȡ������---List<Pet>
	 		//����Ҫ���ͻ�����Ⱦ�����ܹ�ֱ����List<Pet>���ͻ��ˣ���Ϊ�ͻ��˲�����ʶJava��List<>���ݽṹ
	 		//���ԣ�������Ҫ����ת��JSON��ʽ������---�����ù���ת
	 		
	 		IpetBiz biz=new petBiz_jdbcImpl();
	 		
	 		String _store_Id=request.getParameter("store_Id");
	 		
	 		List<Pet> list=null;
	 		if(_store_Id!=null) {
	 		   list=biz.getPetByStoreId(Integer.parseInt(_store_Id));
	 		}
	 		
	          ObjectMapper mapper=new ObjectMapper();
	 		 
	 		 String myJson=mapper.writeValueAsString(list);
	 		
	 		//����������Ҫһ����������java �ļ���ת��JSON����
	 		//System.out.println(myJson);
	 		response.setCharacterEncoding("utf-8");
	 		response.setContentType("text/json;charset=utf-8");
	 		response.getWriter().print(myJson);
	 		
	 		return "ajax";//˵���� ������ֻ���ṩ��ajax����
   }
   
   
   @Haspermission("petStore:*")
   public String petStoreList(HttpServletRequest req,HttpServletResponse res) {
	        //ʵ�ַ�ҳ�߼�
	 		PetStoreBiz_interface  biz =new PetStoreBiz_impl();
	         
	         //˫��ѯ����ȡ����������ÿҳ����  ����������
	         int pageOffset=req.getParameter("pager.offset")==null?0:Integer.parseInt(req.getParameter("pager.offset"));
	         int pageSize=req.getParameter("pageSize")==null?4:Integer.parseInt(req.getParameter("pageSize"));
	         
	         Map<String,Integer> map=new HashMap<String,Integer>();
	         map.put("pageOffset", pageOffset);
	         map.put("pageSize",pageSize);
	         
	         List<PetStore> petStorelist=biz.getPager(map);//��ǰ��ҳҪ��Ⱦ������
	         List<PetStore> totallist=biz.getAll();
	         
	         pager pager1=new pager();
	         pager1.setDatas(petStorelist);
	         pager1.setTotalRecord(totallist.size());
	         
	         req.setAttribute("pagers",pager1);
	         
	         return "/pages/petstore/petStorelist.jsp";
	         
	        
   }
}
