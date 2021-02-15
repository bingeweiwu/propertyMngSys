package cn.edu.hezeu.pms.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hezeu.pms.Service.AdmService;
import cn.edu.hezeu.pms.Service.Impl.AdmServiceImpl;
import cn.edu.hezeu.pms.bean.Administrator;

public class AdminManager extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		AdmService as = new AdmServiceImpl();
		String password = request.getParameter("password");

		String newPwd = request.getParameter("newPassword");
		String confirmPwd = request.getParameter("confirmPwd");

		String name = ((Administrator) session.getAttribute("user")).getName();

		String originalPassword = as.getPwd(name);
		if (originalPassword.equals(password)) {//原始密码
			if (!newPwd.equals("")) {
				System.out.println("########################+");
				if (newPwd.equals(confirmPwd)) {//确认密码和新密码要一致
					System.out.println("*****************************");
					int x = as.changePwd(name, newPwd);
					if (x > 0) {
						session.invalidate();
						out.println("<script languague='javascript'>alert('密码修改成功，请重新登录');location='javascript:history.go(-2);self.location=document.referrer;';</script>");
						// out.println("<script languague='javascript'>alert('�����޸ĳɹ�,�����µ�¼');location='target='parent';login.jsp;';</script>");
						// out.println("<script languague='javascript'>location='self.location=document.referrer;';</script>");
						// response.sendRedirect("login.jsp");
					} else {
						out.println("<script languague='javascript'>alert('密码修改失败');location='javascript:history.go(-1)';</script>");
					}
				} else {
					out.println("<script languague='javascript'>alert('两次输入的密码必须一致');location='javascript:history.go(-1)';</script>");
				}

			} else {
				out.println("<script languague='javascript'>alert('密码不能为空');location='javascript:history.go(-1)';</script>");
			}

		} else {
			out.println("<script languague='javascript'>alert('原密码输入错误，请输入正确的原是密码');location='javascript:history.go(-1)';</script>");
		}
	}
}
