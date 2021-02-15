<%@ page language="java" import="java.util.*,cn.edu.hezeu.pms.bean.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">

<!-- <script type="text/javascript">
 function tiaozhuan(){
		
		if(confirm("确定退出吗?")){
		
			return true;
		}else{return false;}
	}
</script>
 -->


<!-- //尚未实现的推出功能的js代码 -->
 <script type="text/javascript">
$(function(){
//顶部导航栏切换
 $(".nav li a").click(function(){
  	$(".nav li a.selected").removeClass("selected")
	$(this).addClass("selected");
      })
	//退出功能
	$("#out").click(function(){
	var flag=window.confirm("你真的要退出吗？");
	alert(flag);
       })

})
</script>


<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE2 {
	font-size: 12px;
	color: #333333;
}
-->
a:link {font-size:12px; color:#000000; text-decoration:none;}
a:visited {font-size:12px; color:#000000; text-decoration:none;}
a:hover {font-size:12px; color:#00CCFF;text-decoration:none;}
.STYLE4 {font-size: 12px}
</style></head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="11" background="web/images/main_03.gif"><img src="web/images/main_01.gif" width="104" height="11"></td>
  </tr>
  <tr>
    <td height="36" background="web/images/main_07.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="282" height="52" background="web/images/main_05.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>
            	<span class="STYLE1"><img src="web/images/home.gif" width="12" height="13"> </span>
            	<span class="STYLE4" ><a href="showUser" target="I2" >回首页</a></span><span class="STYLE1">
            	 <img src="web/images/quit.gif" width="16" height="16"> </span>
            	 <span class="STYLE4">
             	<a href="userManager?operation=out" onclick="return tiaozhuan()" target="_parent">退出系统</a>
             </td>
        </table></td>
        <td width="247" background="web/images/main_08.gif">&nbsp;</td>
        <td width="283" background="web/images/main_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<img src="web/images/uesr.gif" width="14" height="14">
					
					<% 
					boolean flag = session.getAttribute("user") instanceof User; //类判断
					String ID;
					if(flag){
						ID = String.valueOf(((User) session.getAttribute("user")).getID()); //转换为字符串格式
					}
					else{
						ID = ((Administrator)session.getAttribute("user")).getName();
					}
					%>
					
					<span class="STYLE2"> 当前登录 : <%=ID %>	
					</span>
				</td>
			</tr>
		</table>
		</td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
