package com.yangsha.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class checklogin
 */
@WebFilter("/*")
public class checklogin implements Filter {

	public static Set<String> Allow_Paths=new HashSet<String>(Arrays.asList("/Public","/adminServlet","/login.jsp"));
	
    /**
     * Default constructor. 
     */
    public checklogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");
        
		boolean allowedPath = Allow_Paths.contains(path);


		
		if(req.getSession().getAttribute("userKey")!=null) {
		   chain.doFilter(request, response);
		}else if(allowedPath) {
		   chain.doFilter(request, response);
		}else {
			res.sendRedirect(req.getContextPath()+"/login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
