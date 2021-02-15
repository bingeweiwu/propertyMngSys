<%@ page language="java" import="java.util.*,cn.edu.hezeu.pms.bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>物业管理系统</title>
</head>

<%if(session.getAttribute("user")!=null){ %>
<frameset rows="63,*,23" frameborder="no" border="0" framespacing="0">
  <frame src="web/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
  
  <%  if(session.getAttribute("user") instanceof Administrator){   //此处为管理员登陆界面   %>
  <frame src="web/center.jsp" name="mainFrame" id="mainFrame" />
  <%} else{	
	 String ID = String.valueOf(((User) session.getAttribute("user")).getID()); //此处为普通用户登陆界面 
	   %>
  <frame src="userManager?operation=showPersonalInfo&id=<%=ID %>" name="mainFrame" id="mainFrame"  />
  <%} %>
  
  <frame src="web/down.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" />
</frameset>

<%}else{
	out.println("<script languague='javascript'>alert('您需要先登录');location='login.jsp';</script>");
} %>


<noframes><body>
</body>
</noframes></html>
