<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="/springmvc_02/add.action" method="POST">
    	<table border="2" align="center">
    		<tr>
    			<th>姓名</th>
    			<td><input type="text" name="name"></td>
    		</tr>
    		<tr>
    			<th>性别</th>
    			<td><input type="radio" name="gender" value="男" checked="checked">男
    			<input type="radio" name="gender" value="女">女</td>
    		</tr>
    		<tr>
    			<th>薪水</th>
    			<td><input type="text" name="salary" value="3000"></td>
    		</tr>
    		<tr>
    			<th>雇佣日期</th>
    			<td><input type="text" name="hiredate" value="2017-10-10"></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit" value="提交"></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
