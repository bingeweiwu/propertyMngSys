package cn.edu.hezeu.pms.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.hezeu.pms.Service.AdmService;
import cn.edu.hezeu.pms.Service.FloorService;
import cn.edu.hezeu.pms.Service.UserService;
import cn.edu.hezeu.pms.Service.Impl.AdmServiceImpl;
import cn.edu.hezeu.pms.Service.Impl.FloorServiceImpl;
import cn.edu.hezeu.pms.Service.Impl.UserServiceImpl;
import cn.edu.hezeu.pms.bean.Administrator;
import cn.edu.hezeu.pms.bean.User;

public class userManager extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String operation = request.getParameter("operation");
		AdmService as = new AdmServiceImpl();
		UserService us = new UserServiceImpl();
		FloorService fs = new FloorServiceImpl();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(date);

		if (operation.equals("out")) {

			session.invalidate();
			out.println("<script languague='javascript'>location='login.jsp';</script>");
			// response.sendRedirect("login.jsp");

		} else if (operation.equals("modify")) {

			String id = request.getParameter("id");
			User user = us.getOneUser(id);
			request.setAttribute("modifyuser", user);
			request.getRequestDispatcher("web/userMng/modify.jsp").forward(
					request, response);

		} else if (operation.equals("update")) {

			User user = new User();
			user.setID(request.getParameter("id"));
			System.out.println("qwerqwer"+request.getParameter("username"));
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));

			user.setHouseNumber(request.getParameter("houseNumber"));

			user.setPropertyFee(Integer.parseInt(request
					.getParameter("propertyFee")));
			user.setViolation(Integer.parseInt(request
					.getParameter("violation")));
			user.setTelephone(Long.parseLong(request.getParameter("telephone")));

			int result = us.updateUser(user);
			if (result > 0) {
				out.println("<script languague='javascript'>alert('更新成功');location='showUser';</script>");
			} else {
				out.println("<script languague='javascript'>alert('更新失败');location='javascript:history.go(-2)';</script>");
			}

		} else if (operation.equals("delete")) {
			String id = request.getParameter("id");
			
			User user = us.getOneUser(id);
			
			System.out.println(user.getUsername());
			
			String uname = new String(user.getUsername().getBytes("utf-8"),"utf-8");
			
			user.setUsername(uname);

			int recycle = us.backup(user);//备份用户数据
			
			
			int x = us.deleteUser(id);
			if (x > 0) {
				fs.removeUser(id);
				out.println("<script languague='javascript'>alert('删除成功');location='showUser';</script>");
			} else {
				out.println("<script languague='javascript'>alert('删除失败');location='javascript:history.go(-2)';</script>");
			}
		} else if (operation.equals("add")) {

			User user = new User();

			String ID = request.getParameter("ID");

			if (ID.length() != 18) {

				out.println("<script languague='javascript'>alert('身份证号必须为18位');location='javascript:history.go(-1)';</script>");

			} else {

				user.setID(ID);
				user.setHouseNumber(request.getParameter("houseNumber"));
				user.setUsername(request.getParameter("username"));
				System.out.println("request.getparameter"+request.getParameter("username"));
				user.setPassword(ID.substring(12)); // 截取身份证号后六位为用户的初始密码
				user.setTelephone(Long.parseLong(request
						.getParameter("telephone")));

				if (us.checkUser(user) != null) {
					out.println("<script languague='javascript'>alert('用户名已存在');location='javascript:history.go(-2)';</script>");
				}
				int result = us.addUser(user);
				if (result > 0) {
					fs.AddUser(user, request.getParameter("houseNumber")); // 将新用户添加到房间中
					out.println("<script languague='javascript'>alert('添加成功');location='showUser';</script>");

				} else {
					out.println("<script languague='javascript'>alert('添加失败');location='javascript:history.go(-2)';</script>");
				}
			}
		} else if (operation.equals("reset")) {

			int account = 0;
			for (int i = 1; i <= 10; i++) {
				String mid = "checkbox" + i;
				if (request.getParameter(mid) != null) {
					account += us.resetPassword(request.getParameter(mid));
				}
			}
			if (account > 0) {
				out.println("<script languague='javascript'>alert('密码初始化成功');location='javascript:history.go(-1)';</script>");
			} else {
				out.println("<script languague='javascript'>alert('初始化失败');location='javascript:history.go(-1)';</script>");
			}

		} else if (operation.equals("modifyPersonal")) {
			User user = new User();
			String id = request.getParameter("id");
			String money = request.getParameter("balance");
			String newPassword = request.getParameter("newPassword");

			user.setID(id);
			user.setTelephone(Long.parseLong(request.getParameter("telephone")));
			user.setPropertyFee(Integer.parseInt(request
					.getParameter("propertyFee")));
			user.setViolation(Integer.parseInt(request
					.getParameter("violation")));

			int mid = 0; // �����޸�������м����

			if (!newPassword.equals("init")) {
				String confirmPwd = request.getParameter("confirmPwd");
				if (newPassword.equals(confirmPwd)) {
					user.setPassword(newPassword);
					session.invalidate();
					out.println("<script languague='javascript'>alert('�����޸ĳɹ�,�����µ�¼');location='javascript:history.go(-2);self.location=document.referrer;';</script>");
					mid = 1;
				} else {
					out.println("<script languague='javascript'>alert('������������벻һ��,����������');location='javascript:history.go(-1)';</script>");
				}
			} else {
				user.setPassword(request.getParameter("password"));
			}

			int result = us.PersonalOperation(user, Integer.parseInt(money));
			if (Integer.parseInt(money) < Integer.parseInt(request
					.getParameter("propertyFee"))) {
				out.println("<script languague='javascript'>alert('����');location='javascript:history.go(-1)';</script>");
			} else if (result > 0 && mid == 0) {
				out.println("<script languague='javascript'>alert('�������');location='javascript:history.go(-1);self.location=document.referrer;';</script>");
			}

		} else if (operation.equals("showPersonalInfo")) {

			String id = request.getParameter("id");
			User person = us.getOneUser(id);
			request.setAttribute("person", person);
			request.getRequestDispatcher("user.jsp").forward(request, response);

		}

	}

}
