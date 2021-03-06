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
	public String list(HttpServletRequest request, HttpServletResponse response) {
		IroleBiz biz = new roleBizImpl();
		request.setAttribute("roles", biz.getAll());
		return "/pages/role/index.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {
		// To_Do
		return "/pages/role/index.jsp";
	}

	public String add_edit(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {//添加和编辑
		// 不管是为"添加"呈现用户填列表单项的页面，还是为接收用户填列的表单数据
		// 我们需要分别对待用户提交的方式：若是get提交，则呈现表单页面
		// 若是post 提交，则处理表单数据，做持久化处理
		// 以下代码依据提交方法做分支:
		IMenuBiz biz = new MenuBizImpl();
		IroleBiz role_biz = new roleBizImpl();
		if (request.getMethod().equalsIgnoreCase("get")) {
			// get提交的请求---servlet 的响应是为用户呈现填列表单

			String id = request.getParameter("id");
			if (id == null) {
				// add
				request.setAttribute("role", new role());
			} else {
				// edit

				request.setAttribute("role", role_biz.getEntityById(Integer.parseInt(id)));
			}

			request.setAttribute("resourceList", biz.getAll());
			return "/pages/role/add_edit.jsp";
		} else if (request.getMethod().equalsIgnoreCase("post")) {
			// post 提交过来的表单数据，做持久化到数据库保存
			request.setCharacterEncoding("UTF-8");

			String id = request.getParameter("id");
			String rolename = request.getParameter("rolename");
			String desc = request.getParameter("desc");
			String resource_ids = request.getParameter("resource_ids");

			role role_ = new role();

			if (!id.equals("0")) {
				role_.setId(Integer.parseInt(id));
			}
			role_.setRolename(rolename);
			if (desc != null) {
				role_.setDesc(desc);
			}
			if (resource_ids != null) {
				role_.setResource_ids(resource_ids);
			}

			if (id.equals("0")) {
				// 添加
				role_biz.add(role_);
			} else {
				// 修改
				role_biz.updateByPrimaryKeySelective(role_);
			}

		}

		return "/roleServlet?method=list";
	}

}
