package com.yangsha.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yangsha.biz_impl.MenuBizImpl;
import com.yangsha.biz_impl.roleBizImpl;
import com.yangsha.biz_interface.IMenuBiz;
import com.yangsha.biz_interface.IroleBiz;
import com.yangsha.entity.role;

@WebServlet("/roleServlet")
public class RoleServlet extends BaseServlet {
   public String list(HttpServletRequest request,HttpServletResponse response) {
	   IroleBiz biz=new roleBizImpl();
	   request.setAttribute("roles",biz.getAll());
	   return "/pages/role/index.jsp";
   }
   
   public String delete(HttpServletRequest request,HttpServletResponse response) {
	   //To_Do
	   return "/pages/role/index.jsp"; 
   }
   
   public String add_edit(HttpServletRequest request,HttpServletResponse response) {
	   //������Ϊ"���"�����û����б����ҳ�棬����Ϊ�����û����еı�����
	   //������Ҫ�ֱ�Դ��û��ύ�ķ�ʽ������get�ύ������ֱ�ҳ��
	   //����post �ύ����������ݣ����־û�����
	   //���´��������ύ��������֧:
	   IMenuBiz biz=new MenuBizImpl();
	   
	   if(request.getMethod().equalsIgnoreCase("get")) {
		   //get�ύ������---servlet ����Ӧ��Ϊ�û��������б�

		  
		   
		   String id=request.getParameter("id");
		   if(id==null) {
			   //add
			   request.setAttribute("role",new role());
		   }else {
			   //edit
			   IroleBiz role_biz=new roleBizImpl();
			   request.setAttribute("role",role_biz.getEntityById(Integer.parseInt(id)));
		   }
		   
		   
		   request.setAttribute("resourceList",biz.getAll());
		   return "/pages/role/add_edit.jsp"; 
	   }else if(request.getMethod().equalsIgnoreCase("post")) {
		   //post �ύ�����ı����ݣ����־û������ݿⱣ��
		   String id=request.getParameter("id");
		   String name=request.getParameter("rolename");
		   String desc=request.getParameter("desc");
		   
		   if(id.equals("0")) {
			   //���
			   
		   }else {
			   //�޸�
		   }
		   
	   }
	   
	   return "/pages/role/index.jsp"; 
   }
   
   
}
