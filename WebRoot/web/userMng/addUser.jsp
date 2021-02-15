<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'modify.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script src="https://code.jquery.com/jquery-3.1.1.min.js" ></script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$.post({
					url : "/propertyMngSys/ShowFloor",
					//告知参数类型为JSON，不能缺少
					contentType : "application/json",
					//将JSON转化为字符串传递
					data : {},
					success : function(msg) {
						$("#rlist").prepend("<option value='0'>请选择</option>");
						for (var i = 0; i < msg.length; i++) {
							var val = msg[i].HouseNumber;
							$("#rlist").append(
									"<option value='" + val + "'>" + val
											+ "</option>");
						}
					}
				});
			});
</script>




</head>
<body>

	<form action="userManager?operation=add" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="9" background="images/huilan.gif">&nbsp;</td>
				<td bgcolor="#f3ffe3">
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#c0de98">

						<tr>
							<td height="18" bgcolor="#FFFFFF"><div align="center"
									class="STYLE1">用户ID</div></td>
							<td height="18" bgcolor="#FFFFFF" class="STYLE2">
								<div align="left" class="STYLE2 STYLE1">
									&nbsp;&nbsp;<input type="text" name="ID">
								</div>
							</td>
						</tr>

						<tr>
							<td height="18" bgcolor="#FFFFFF"><div align="center"
									class="STYLE1">用户名</div></td>
							<td height="18" bgcolor="#FFFFFF" class="STYLE2">
								<div align="left" class="STYLE2 STYLE1">
									&nbsp;&nbsp;<input type="text" name="username">
								</div>
							</td>
						</tr>

						<tr>
							<td height="18" bgcolor="#FFFFFF"><div align="center"
									class="STYLE1">门牌号</div></td>
							<td height="18" bgcolor="#FFFFFF" class="STYLE2">
								<div align="left" class="STYLE2 STYLE1">
									&nbsp;&nbsp; <select name="houseNumber" id="rlist">	</select>

								</div>
							</td>
						</tr>



						<tr>
							<td height="18" bgcolor="#FFFFFF"><div align="center"
									class="STYLE1">电话</div></td>
							<td height="18" bgcolor="#FFFFFF" class="STYLE2">
								<div align="left" class="STYLE2 STYLE1">
									&nbsp;&nbsp;<input type="text" name="telephone">
								</div>
							</td>
						</tr>

						<tr align="center">
							<input type="submit" value="提交" />
							<input type="reset" value="重置" />
						</tr>

					</table>
					</form>
</body>
</html>