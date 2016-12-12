<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  
<base href="<%=basePath%>">

<title>员工列表展示</title>
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
	
	<table border="1" align="center" bgcolor="#E0E0E0" width="80%"
		cellpadding="5" cellspacing="0">
		<tr>
			<th>序号</th>
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>员工薪水</th>
			<th>员工部门</th>
			<th>操作</th>
		</tr>

		<s:if test="#request.listEmp1 != null">
			<s:iterator var="emp" value="#request.listEmp1" status="st">
				<tr>
					<td align="center"><s:property value="#st.count"/></td>
					<td align="center"><s:property value="#emp.id"/></td>
					<td align="center"><s:property value="#emp.name"/></td>
					<td align="center"><s:property value="#emp.salary"/></td>
					<td align="center"><s:property value="#emp.dept.name"/></td>
					<td align="center">
					<s:a href="emp_updateView.action?id=%{#emp.id}">修改</s:a>
					<s:a href="emp_delete.action?id=%{#emp.id}">删除</s:a>
					</td>
				</tr>
			</s:iterator>
		</s:if>
		
		<s:else>
			<tr>
				<td colspan="5">对不起！请先录入员工信息！</td>
			</tr>
		</s:else>

	</table>
</body>
</html>
