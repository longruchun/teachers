package com.yangsha.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangsha.biz_impl.MenuBizImpl;
import com.yangsha.biz_impl.roleBizImpl;
import com.yangsha.biz_interface.IMenuBiz;
import com.yangsha.biz_interface.IroleBiz;
import com.yangsha.entity.Admin;
import com.yangsha.entity.role;
import com.yangsha.util.menu.menu;
import com.yangsha.util.menu.menu2;
import com.yangsha.util.menu.menuitem;

@WebServlet("/resourceServlet")
public class resourceServlet extends BaseServlet {
   public String getMenu(HttpServletRequest request,HttpServletResponse response) throws Exception {
	   
	   //************************************
	   //通过request得session,取session中userKey,得当前用户
	   
	   //通过request可以得到session,从session中就可直接取出roleid
	   //我们用roleid 去实施过滤
	   String roleIds=((Admin)request.getSession().getAttribute("userKey")).getRoleid();
	   String[] role_ids=roleIds.split(",");
	   int[] _int_role_ids=new int[role_ids.length];
	   for(int i=0;i<role_ids.length;i++) {
		   _int_role_ids[i]=Integer.parseInt(role_ids[i]);
	   }
	   
	   Map<String,Integer> resource_Ids=new HashMap<String,Integer>();
	   
	   IroleBiz role_biz=new roleBizImpl();
	   
	   for(int i=0;i<_int_role_ids.length;i++) {
		   //遍历该数组，取出每一个roleid对应的resourceIds
		   //需要根据一个roleid 取出这个roleid对应的resource_ids,将这些resource_ids 放入集合
		   //供我们过滤权限时使用
		   //To-Do
		   //实例化roleBiz ,通过roleId 取出 resourceId 
		   role role_=role_biz.getEntityById(_int_role_ids[i]);
		   String[] resource_ids=role_.getResource_ids().split(",");
		   for(int j=0;j<resource_ids.length;j++) {
			   resource_Ids.put(resource_ids[j],Integer.parseInt(resource_ids[j]));
		   }
	   }
	   
	   //经过第43行构造的循环出来，resource_Ids中装载的就是当前登录用户拥有的全部权限,
	   //我们用它去过滤传入的List<menu>菜单集合
	   
	   //************************************
	   
	   
	   
	   
	    IMenuBiz biz=new MenuBizImpl();
		List<menu> list=biz.getMenus(resource_Ids);
		
		
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		response.getWriter().print(json);
		
		return "ajax";
   }
   
  
   public String menulist(HttpServletRequest request,HttpServletResponse response){
	   IMenuBiz biz=new MenuBizImpl();
	   List<menuitem> list=biz.getAll();
	   request.setAttribute("menus",list);
 
	   return "/pages/resource/index.jsp";
   }
   
   public String getMenu2(HttpServletRequest request,HttpServletResponse response) throws Exception {
	    IMenuBiz biz=new MenuBizImpl();
		List<menu2> list=biz.getMenus2();
		
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		response.getWriter().print(json);
		
		return "ajax";
  }
}
