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
import cn.edu.hezeu.pms.Service.UserService;
import cn.edu.hezeu.pms.Service.Impl.AdmServiceImpl;
import cn.edu.hezeu.pms.Service.Impl.UserServiceImpl;
import cn.edu.hezeu.pms.bean.Administrator;
import cn.edu.hezeu.pms.bean.User;

public class LoginServer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String operation = request.getParameter("operation");
		UserService us = new UserServiceImpl();
		AdmService as = new AdmServiceImpl();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNowStr = sdf.format(date);
		
		
		
		if (operation.equals("login")) {

			String name = request.getParameter("ID");
			int length = name.length();// 获取用户名的长度，用用户名判断身份
			Object obj = null;
			if (length == 18) { // 等于18位是普通用户登录

				obj = new User();
				((User) obj).setID(name);
				((User) obj).setPassword(request.getParameter("password"));
				if (us.checkUser(((User) obj)) != null) {
					session.setAttribute("user", us.checkUser(((User) obj)));
					session.setAttribute("date", dateNowStr);
					out.println("<script languague='javascript'>location='web/main.jsp';</script>");
				} else {
					out.println("<script languague='javascript'>alert('�û������������');location='login.jsp';</script>");
				}

			} else { // 不是18位为管理员登录
				obj = new Administrator();
				((Administrator) obj).setName(name);
				((Administrator) obj).setPassword(request
						.getParameter("password"));

				if (as.checkAdm(((Administrator) obj)) != null) {
					session.setAttribute("user",as.checkAdm(((Administrator) obj)));
					//以此在页面中判断登陆身份，呈现不同的界面
					Date frontDate = as.getFrontDate();
					session.setAttribute("date", dateNowStr);
					String[] frontDateArray = String.valueOf(frontDate).split(
							"-");
					String[] nowDateArray = dateNowStr.split("-");

					int year, month, day, frontYear, frontMonth, frontDay, dayNum;

					frontYear = Integer.parseInt(frontDateArray[0]);
					frontMonth = Integer.parseInt(frontDateArray[1]);
					frontDay = Integer.parseInt(frontDateArray[2]);
					
					year = Integer.parseInt(nowDateArray[0]);
					month = Integer.parseInt(nowDateArray[1]);
					day = Integer.parseInt(nowDateArray[2]);

					dayNum = ((year - frontYear) * 12 + month - frontMonth)
							* 30 + day - frontDay; //获取两次登陆相隔的天数
					List<User> userList = us.getAllUser();
					for (Object o : userList) {
						us.charging((User) o, dayNum);
					}
					as.rightNow(name);     //更新管理员登录日期

					out.println("<script languague='javascript'>location='web/main.jsp';</script>");
				} else {
					out.println("<script languague='javascript'>alert('用户名不存在');location='login.jsp';</script>");
				}
			}

		}
		
	}

}
