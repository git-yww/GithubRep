<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
  </head>
  
  <body>
  
  	<jsp:include page="/head.jsp"></jsp:include>
  	<div align="center">
  		<h2>管理员注册</h2>
  	</div>
    <s:form action="admin_register.action" method="post" theme="simple">
    	<table border="1" align="center" cellpadding="5" cellspacing="0">
    		<tr>
    			<td>管理员账号</td>
    			<td>
    				<s:textfield name="name" id="name" value=""/>
    			</td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td>
    				<s:textfield name="password" id="password" value=""/>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<s:submit value="注册"></s:submit>
    			</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
