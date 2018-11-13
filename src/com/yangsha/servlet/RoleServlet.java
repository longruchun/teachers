package com.yangsha.servlet;

import java.io.UnsupportedEncodingException;

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
   
   public String add_edit(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
	   //������Ϊ"���"�����û����б����ҳ�棬����Ϊ�����û����еı�����
	   //������Ҫ�ֱ�Դ��û��ύ�ķ�ʽ������get�ύ������ֱ�ҳ��
	   //����post �ύ����������ݣ����־û�����
	   //���´��������ύ��������֧:
	   IMenuBiz biz=new MenuBizImpl();
	   if(request.getMethod().equalsIgnoreCase("get")) {
		   //get�ύ������---servlet ����Ӧ��Ϊ�û��������б�
		  // request.setAttribute(arg0, arg1);
		 
		   String id=request.getParameter("id");
		   if (id.equals("0")) {
			   request.setAttribute("role", new role());
			   
			
		} else {
			IroleBiz role_biz=new roleBizImpl();
			request.setAttribute("role", role_biz.getEntityById(Integer.parseInt("id")));

		}
		   
		   
		   
		   request.setAttribute("resoureList", biz.getAll());
		   return "redirect:/pages/role/add_edit.jsp"; 
	   }else if(request.getMethod().equalsIgnoreCase("post")) {
		   //post �ύ�����ı����ݣ����־û������ݿⱣ��
		   request.setCharacterEncoding("utf-8");
		   String id=request.getParameter("id");
		   //System.out.println("id"+id);
		   String rolename=request.getParameter("rolename");
		   String desc=request.getParameter("desc");
		   String resoure_ids=request.getParameter("resoure_ids");
		   
		   role role_=new role();
		   
		   if (!id.equals("0")) {
			role_.setId(Integer.parseInt(id));
		} 
		   
		   
		role_.setRolename(rolename);
		   
		   if (desc!=null) {
			   role_.setDesc(desc);
			
		}
		   
		   
		   
		if (resoure_ids!=null) {
			 role_.setResource_ids(resoure_ids);
			
		}
		   
		   if (id.equals("0")) {
			   //���
			 
			   
			
		}else {
			
			//�޸�
		}
		   
	   }
	   return "/roleServlet?method=list"; 
   }
   
 
}
