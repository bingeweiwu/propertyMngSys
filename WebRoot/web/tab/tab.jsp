<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<base href="<%=basePath%>">




<script src="jQuery/jquery-3.4.0.min.map"></script>  


<script type="text/javascript">
 function tiaozhuan(){
		if(confirm("您要注销该住户吗？")){
			return true;
		}else{return false;}
	}
</script>







<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
.STYLE1 {font-size: 12px}
.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;

}
a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}
a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

-->
</style>


   <meta charset="gbk">
   <!-- 引入JQuery -->
   <script src="jquery-1.3.1.js" type="text/javascript"></script>


</head>
<form action="userManager?operation=reset" method="post">
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="web/tab/images/tab_03.gif" width="15" height="30" /></td>
        <td background="web/tab/images/tab_05.gif"><img src="web/tab/images/311.gif" width="16" height="16" /> <span class="STYLE4">服务器进程配置列表</span></td>
        <td width="14"><img src="web/tab/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="web/tab/images/tab_12.gif">&nbsp;</td>
        <td bgcolor="e5f1d6"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CECECE">
          <tr>
            <td width="8%" height="26" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">选择</div></td>
            <td width="22%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">ID</div></td>
            <td width="8%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">门牌号</div></td>
            <td width="10%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">用户名</div></td>
            <td width="14%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">户主电话</div></td>
            <td width="12%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">物业费</div></td>
            <td width="12%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">违约次数</div></td>
            <td width="7%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">修改信息</div></td>
            <td width="7%" height="18" background="web/tab/images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">用户销户</div></td>
          </tr>
          
          <%int i=1; %>
        <c:forEach var="list" items="${userList }">
          <tr>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <input name="checkbox<%=i %>" type="checkbox" class="STYLE2" value="${list.ID }" />
            </div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${list.ID }</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${list.houseNumber }</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${list.username }</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${list.telephone }</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${list.propertyFee }</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${list.violation }</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center"><img src="web/tab/images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="userManager?id=${list.ID }&operation=modify">编辑</a>  <span class="STYLE1">]</span></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center"><span class="STYLE2"><img src="web/tab/images/010.gif" width="9" height="9" /> </span><span class="STYLE1">[</span><a href="userManager?id=${list.ID }&operation=delete" onclick="return tiaozhuan()">注销</a><span class="STYLE1">]</span></div></td>
          </tr>
          <% i++; %>
        </c:forEach>
        
          <!-- <tr><td><a href="web/userMng/addUser.jsp">添加用户</a></td></tr> -->
          
        </table></td>
        <td width="9" background="web/tab/images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="web/tab/images/tab_20.gif" width="15" height="29" /></td>
        <td background="web/tab/images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="40%"><div align="left"><span class="STYLE1">共<%=i-1 %>条纪录，当前第1页，每页10条纪录</span></div></td>
            <td width="60%" class="STYLE1">&nbsp;</td>
          </tr>
        </table></td>
        <td width="14"><img src="web/tab/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>

<tr><td><input type="submit" value="初始化密码"/></td></tr>

</form>

</body>
</html>
