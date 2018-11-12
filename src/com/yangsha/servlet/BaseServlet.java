package com.yangsha.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yangsha.util.Haspermission;

public class BaseServlet extends HttpServlet {
   public static String REDIRECTPATH = "redirect:";
   
   public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	   req.setCharacterEncoding("utf-8");
	   res.setCharacterEncoding("utf-8");
	   
	   String method=req.getParameter("method");
	   
	   //������ȡ�Ĳ�ѯ�ַ���"method"��ֵ ������ һ��������Ķ���---�˴������л��ƣ�����ʹ�õ�java ���еķ������
	   try {
			Method m=this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
		    
			//****************************************
			//������ȡ���������annotation�Ĵ���
			Haspermission hasPermission=m.getAnnotation(Haspermission.class);
			if (hasPermission!=null) {
				
				//System.out.println("@Haspermission  annotation �趨�ĵ�ǰֵ��: "+hasPermission.value());
				//��session ��ȡ��Ȩ�޼��ϣ����ޣ����쳣
				Object o=req.getSession().getAttribute("permissions");
				if(o!=null) {
					Set<String> set=(Set<String>)o;
					if(!set.contains(hasPermission.value())) {
						try {
							throw new Exception("���߱���Ӧ����Ȩ��.");
							
							
						} catch (Exception e) {
							e.printStackTrace();
							res.sendRedirect(req.getContextPath()+"/login.jsp");
							return;
							
						}finally {
							
						}
					}
				}else {
					
				}
			}
			//****************************************
			
			
			
			
			
			//����ʵ�������������m,�������ǵĹ���servlet���ж�Ӧ��Ҫִ�еķ��������ǾͿ���ͨ�������﷨��ִ���������
			//���������ִ����Ϸ��ص��ַ���������һ����ת·������һ��ajax����
			String returnVal=(String) m.invoke(this,req,res);
			
			if(returnVal.equals("ajax")) {
				//Ajax���ã��������κ���ת
			}else {
				if(returnVal.startsWith(REDIRECTPATH)) {
					//˵�������ض���
					res.sendRedirect(returnVal.substring(REDIRECTPATH.length()));
				}else {
					req.getRequestDispatcher(returnVal).forward(req,res);
				}
			}
	   } catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	   
	   
   }
}
