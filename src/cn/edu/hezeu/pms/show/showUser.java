package cn.edu.hezeu.pms.show;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.hezeu.pms.Service.UserService;
import cn.edu.hezeu.pms.Service.Impl.UserServiceImpl;
import cn.edu.hezeu.pms.bean.User;

public class showUser extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html£»charset=utf-8");
		PrintWriter out = response.getWriter();
		UserService us = new UserServiceImpl();
		List<User> userList = us.getAllUser();
		
	 
		/*
		  for (Object obj : userList) {
			System.out.println(((User)obj).getWater());
			System.out.println(((User)obj).getPassword());
		}
		*/
		
		
		
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("web/tab/tab.jsp").forward(request, response);
		
		
	}

}
