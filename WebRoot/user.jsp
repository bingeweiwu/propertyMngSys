<%@ page language="java" import="java.util.*,cn.edu.hezeu.pms.bean.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script>
function switchSysBar(){ 
var locate=location.href.replace('center.html','');
var ssrc=document.all("img1").src.replace(locate,'');
if (ssrc=="images/main_18.gif")
{ 
document.all("img1").src="images/main_18_1.gif";
document.all("frmTitle").style.display="none" 
} 
else
{ 
document.all("img1").src="images/main_18.gif";
document.all("frmTitle").style.display="" 
} 
} 
</script>
	
<!--以下是ajax的js代码 -->
<script type="text/javascript">
	var xmlHttp;
	function createXMLHttpRequest(){
		if(window.XMLHttpRequest){
			xmlHttp= new XMLHttpRequest();
		}else if(window.ActiveXObject){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
 
	function validate(field){
		if(field.value.length!=0){
			//创建XMLHttpRequest
			createXMLHttpRequest();
			var url = "ajax?action=validate&id="+field.value;//去检查学号是否存在
			xmlHttp.open("GET",url,true);
			xmlHttp.onreadystatechange=callback;//callback是一个函数地址,回调
			xmlHttp.send(null);
		}else{
			document.getElementById("snodiv").innerHTML="";
		}
	}
</script>

<script type="text/javascript">
	function callback(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				document.getElementById("snodiv").innerHTML="<font color='red'>"
				+xmlHttp.responseText+"</font>";
			}else{
				alert("账号必须全为数字,status="+xmlHttp.status);
			}
		}
	}
</script>
  </head>
  
  <body>
  
  <% String ID = String.valueOf(((User) session.getAttribute("user")).getID());  %>
  
  <form action="userManager?operation=modifyPersonal&id=<%=ID %>" method="post" >
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/huilan.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#c0de98">
  
  			<tr><td><input type="hidden" name="id" value="${person.ID }"></td></tr>
          
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">姓名</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="text" name="username" value="${person.username }">
            </div></td>
    		</tr>
    		
    		 
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">新密码</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="password" name="newPassword" value="init" onblur="validate(this);">
            </div><div id="snodiv"></div></td>           
    		</tr>
    		 
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">确认密码</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="password" name="confirmPwd" value="init">
            </div></td>           
    		</tr>
    		
    		
    		<tr>
    		<td><input type="hidden" name="password" value="${requestScope.person.password }"></td>           
    		</tr>
    		
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">电话</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="text" name="telephone" value="${requestScope.person.telephone }">
            </div></td>           
    		</tr>
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">充值</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="text" name="balance" value="0">
            </div></td>           
    		</tr>
    		
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">应缴物业费</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="text" name="propertyFee" value="${person.propertyFee }" readOnly="true">
            </div></td>           
    		</tr>
    		
    		
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">违约次数</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="text" name="violation" value="${person.violation }" readOnly="true">
            </div></td>           
    		</tr>
    		
    		<tr align="center"> <input type="submit" value="提交" />
		<input type="reset" value="重置" /></tr>
    		
        </table>
        </form>
  
  

</table>
    
    
  </body>
</html>
