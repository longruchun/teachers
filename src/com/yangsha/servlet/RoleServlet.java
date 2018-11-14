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
			throws UnsupportedEncodingException {//��Ӻͱ༭
		// ������Ϊ"���"�����û����б����ҳ�棬����Ϊ�����û����еı�����
		// ������Ҫ�ֱ�Դ��û��ύ�ķ�ʽ������get�ύ������ֱ�ҳ��
		// ����post �ύ����������ݣ����־û�����
		// ���´��������ύ��������֧:
		IMenuBiz biz = new MenuBizImpl();
		IroleBiz role_biz = new roleBizImpl();
		if (request.getMethod().equalsIgnoreCase("get")) {
			// get�ύ������---servlet ����Ӧ��Ϊ�û��������б�

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
			// post �ύ�����ı����ݣ����־û������ݿⱣ��
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
				// ���
				role_biz.add(role_);
			} else {
				// �޸�
				role_biz.updateByPrimaryKeySelective(role_);
			}

		}

		return "/roleServlet?method=list";
	}

}
