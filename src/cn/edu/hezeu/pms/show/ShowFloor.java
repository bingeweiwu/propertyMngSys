package cn.edu.hezeu.pms.show;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.hezeu.pms.Service.FloorService;
import cn.edu.hezeu.pms.Service.Impl.FloorServiceImpl;
import cn.edu.hezeu.pms.bean.Floor;

public class ShowFloor extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		doPost(request,response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json");
		PrintWriter out = response.getWriter();
		
		FloorService  fs = new FloorServiceImpl();
		
		List<Floor> listFloor = fs.getAllFloor();
		
		String val = JSON.toJSONString(listFloor);
		
		 out.write(val);
		
		//request.setAttribute("userList", listFloor);
		//request.getRequestDispatcher("web/tab/tab.jsp").forward(request, response);
		
		
	}

}
