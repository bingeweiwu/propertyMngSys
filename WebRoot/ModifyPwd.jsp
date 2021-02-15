<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ModifyPwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  
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
			var url = "ajax?action=adm&id="+field.value;//去检查学号是否存在
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
  <!--以上是ajax的js代码 -->
  <body>
      
   <form action="AdminManager" method="post" >
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        
        
        <tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1"></div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="password"  placeholder="原密码" name="password" >
            </div></td>           
    		</tr>
    		
    		
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1"></div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="password"  placeholder="新密码" name="newPassword" value="" onblur="validate(this);">
            </div>
            <div id="snodiv"></div></td>           
    		</tr>
    		
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1"></div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="password"  placeholder="确认密码" name="confirmPwd" value="">
            </div></td>           
    		</tr>
    		
    		
    		<tr align="center"> <input type="submit" value="提交" />
		<input type="reset" value="重置" /></tr>
    		
        </table>
        </form>
  </body>
</html>
