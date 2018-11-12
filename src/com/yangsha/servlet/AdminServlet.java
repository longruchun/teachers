package com.yangsha.servlet;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.yangsha.biz_impl.AdminBizJdbcImpl;
import com.yangsha.biz_impl.MenuBizImpl;
import com.yangsha.biz_impl.roleBizImpl;
import com.yangsha.biz_interface.IAdminBizable;
import com.yangsha.biz_interface.IMenuBiz;
import com.yangsha.biz_interface.IroleBiz;
import com.yangsha.entity.Admin;
import com.yangsha.entity.role;
@WebServlet("/adminServlet")
public class AdminServlet extends BaseServlet {
   
	public String login(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		
		String path="";
	    request.setCharacterEncoding("utf-8");
	    String identify=request.getParameter("identify");
	    System.out.println("identify:"+identify);
	    if(identify.equals("0")){
	        path="/adminServlet?method=adminlogin";
	    }else if(identify.equals("1")){
	    	path="/adminServlet?method=ownerlogin";
	    }else if(identify.equals("2")){
	    	path="/adminServlet?method=storelogin";
	    }
	    return path;
	}
	
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().setAttribute("userKey",null);
		return "redirect:"+request.getContextPath()+"/login.jsp";
		
	}
	
	public String adminlogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
	   
	    String return_path="";
	   
	    request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	  
	    PrintWriter out= response.getWriter();
	   
	   String name=request.getParameter("name");
	   String password=request.getParameter("password");
	   
	   
	   
	  if(name==null||password==null){
		   out.print("<script>alert('name or password not allow empty');</script>");
		   return_path="redirect:"+request.getContextPath()+"/login.jsp";
	  }
	   
	   
	   IAdminBizable biz=new AdminBizJdbcImpl();
	   
	   Admin admin=biz.login(name, password);
	   if(admin!=null){
		   request.getSession().setAttribute("userKey",admin);
           //��¼�ɹ�������Ҫȡ���� �û����е�Ȩ�ޣ�����һ��Set<String>�����У��ٰ�������Ϸ���session
		   Set<String> set=getPermission(admin.getRoleid());
		   request.getSession().setAttribute("permissions",set);
		   
		   return_path="redirect:"+request.getContextPath()+"/index.jsp";
	   }else{
		   
		   return_path="redirect:"+request.getContextPath()+"/login.jsp";
	   }
	   
	   return return_path;
   }

	private Set<String> getPermission(String roleids) {
		// TODO Auto-generated method stub
		IMenuBiz biz=new MenuBizImpl();
		
		Set<String> set=biz.getPermission(roleids);
		return set;
	}

    public String index(HttpServletRequest request,HttpServletResponse response) {
    	
    	IAdminBizable biz=new AdminBizJdbcImpl();
    	request.setAttribute("admins",biz.getAll());
    	return "/pages/admin/index.jsp";
    }

    public String add(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
    	
    	if(request.getMethod().equalsIgnoreCase("get")) {
    	    //get ��ʽ��������ģ���Ҫ������ʾ��
    		//���ͽ�ɫ�б�
    		IroleBiz biz=new roleBizImpl();
    		request.setAttribute("roles",biz.getAll());
    		return "/pages/admin/add.jsp";
    	}else {
    		//post �����ı����ݣ����־û������ݿ�
    		request.setCharacterEncoding("utf-8");
    		response.setCharacterEncoding("utf-8");
    		
    		String name=request.getParameter("name");
    		
    		String password=request.getParameter("password");
    		password=new Md5Hash(password,name,2).toString();
    		
    		
    		String[] roles=request.getParameterValues("roles");
    		
    		StringBuffer sb=new StringBuffer();
    		for(int i=0;i<roles.length;i++) {
    			sb.append(roles[i]);
    			sb.append(",");
    			
    		}
    		
    		String roles_=sb.deleteCharAt(sb.length()-1).toString();
    		
    		Admin admin=new Admin(name,password,roles_);
    		IAdminBizable biz=new AdminBizJdbcImpl();
    		biz.add(admin);
    		
    		return "/adminServlet?method=index";
    	}
    }
    
    
    public String edit(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
    	IAdminBizable biz=new AdminBizJdbcImpl();
    	if(request.getMethod().equalsIgnoreCase("get")) {
    	    //get ��ʽ��������ģ���Ҫ������ʾ��
    		//���ͽ�ɫ�б�
    		//edit ��  add ����ͬ�ĵ㣺edit Ҫ���ݴ��ݹ�����admin_id,��ѯ����Ӧ��admin���󣬴��ؿͻ��ˣ��������Ҫ�޸ĵ�admin
    		String id=request.getParameter("id");
    		int int_id=Integer.parseInt(id);
    		Admin admin=biz.getEntityById(int_id);
    		request.setAttribute("admin",admin);
    		
    		IroleBiz role_biz=new roleBizImpl();
    		request.setAttribute("roles",role_biz.getAll());
    		return "/pages/admin/edit.jsp";
    	}else {
    		//post �����ı����ݣ����־û������ݿ�
    		request.setCharacterEncoding("utf-8");
    		response.setCharacterEncoding("utf-8");
    		
    		String id=request.getParameter("id");
    		String name=request.getParameter("name");
    		
    		
    		
    		
    		String[] roles=request.getParameterValues("roles");
    		
    		StringBuffer sb=new StringBuffer();
    		for(int i=0;i<roles.length;i++) {
    			sb.append(roles[i]);
    			sb.append(",");
    			
    		}
    		
    		String roles_=sb.deleteCharAt(sb.length()-1).toString();
    		
    		Admin admin=new Admin(Integer.parseInt(id),name,roles_);
    		
    		biz.updateByPrimaryKeySelective(admin);
    		
    		return "/adminServlet?method=index";
    	}
    }

}
