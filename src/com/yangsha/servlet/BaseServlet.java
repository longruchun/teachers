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
	   
	   //根据提取的查询字符串"method"的值 ，创建 一个方法类的对象---此处的运行机制，就是使用的java 当中的反射机制
	   try {
			Method m=this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
		    
			//****************************************
			//加入提取方法上面的annotation的代码
			Haspermission hasPermission=m.getAnnotation(Haspermission.class);
			if (hasPermission!=null) {
				
				//System.out.println("@Haspermission  annotation 设定的当前值是: "+hasPermission.value());
				//从session 中取出权限集合，若无，报异常
				Object o=req.getSession().getAttribute("permissions");
				if(o!=null) {
					Set<String> set=(Set<String>)o;
					if(!set.contains(hasPermission.value())) {
						try {
							throw new Exception("不具备相应操作权限.");
							
							
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
			
			
			
			
			
			//以上实例化出来的这个m,就是我们的功能servlet当中对应的要执行的方法；我们就可以通过反射语法，执行这个方法
			//而这个方法执行完毕返回的字符串，代表一个跳转路径或是一个ajax请求
			String returnVal=(String) m.invoke(this,req,res);
			
			if(returnVal.equals("ajax")) {
				//Ajax调用，不用做任何跳转
			}else {
				if(returnVal.startsWith(REDIRECTPATH)) {
					//说明是做重定向
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
