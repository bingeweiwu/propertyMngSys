<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<!-- <style type="text/css"> -->

<script type="text/javascript" src="js/dtree.js"></script>
<style type="text/css"> 
.STYLE2 {font-size: 14px}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.dtree a 
{
	font-size: 14px;
}
p{
   font-size: 14px;
   line-height:16px
}
 
</style>

</style>
</head>
<body>
<table width="173" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;">
<table width="173" border="0" cellspacing="0" cellpadding="0" style="table-layout: fixed;" height="87" target="rightFrame">
      <tr>
        <td height="26" background="images/main_21.gif">&nbsp;</td>
      </tr>      
      <tr>
        <td  style="line-height:4px; background:url(images/main_38.gif)"></td>
      </tr>
      <tr>
        <td>
        <div class="dtree">
        	 <p><a href="javascript: d.openAll();">打开所有</a>|<a href="javascript: d.closeAll();">关闭所有</a></p>					
				<p>
				<script type="text/javascript">					
					d = new dTree('d');
					d.add(0,-1,'管理选项');
					
					d.add(1,0,'用户信息','','I1','I1');
					d.add(11,1,'查看用户信息','showUser','I1','I2');
					d.add(12,1,'添加住户','web/userMng/addUser.jsp','I1','I2');
					d.add(13,1,'修改密码','ModifyPwd.jsp','I1','I2');
										
					d.add(2,0,'员工管理','','I1','I2');
					d.add(21,2,'员工信息管理','admin/studentMaintain.jsp','I1','I2');
					
					d.add(3,0,'消防管理','','I1','I2');
					d.add(31,3,'消防器材管理','','I1','I2');
					
					d.add(4,0,'合同管理','','I1','I2');
					d.add(41,4,'决策支持','','I1','I2');
					d.add(5,0,'修改密码','ModifyPwd.jsp','I1','I2');
					d.add(6,0,'回收站','ShowRecycle','I1','I2');
				
					document.write(d);
				</script>
				</p>
			</div>	
        </td>
      </tr>
</table>

   
   
</table>
</body>
</html>
