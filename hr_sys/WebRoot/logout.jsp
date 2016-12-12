<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head></head>
<body>
	<%
		response.setHeader("refresh", "2;URL=index.jsp");
		session.invalidate();
	%>
	<h3>您已成功退出，两秒后跳回主页！</h3>
<body>
</html>

