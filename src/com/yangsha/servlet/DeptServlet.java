package com.yangsha.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yangsha.biz_impl.DeptBizImpl;
import com.yangsha.biz_interface.IDeptBiz;
import com.yangsha.entity.deptitem;
@WebServlet("/dept")
public class DeptServlet extends BaseServlet {
    public String list(HttpServletRequest req,HttpServletResponse res) {
    	IDeptBiz biz=new DeptBizImpl();
    	List<deptitem> list=biz.getAll();
    	
    	req.setAttribute("depts",list);
    	return "/pages/dept/index.jsp";
    }
}
