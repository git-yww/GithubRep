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
    
    <title>添加员工</title>
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
  		<h2>添加员工信息</h2>
  	</div>

    <s:form action="emp_save.action" method="post" theme="simple">
    	<table border="1" align="center" cellpadding="5" cellspacing="0">
    		<tr>
    			<td>员工姓名</td>
    			<td><s:textfield name="name" id="name" value=""/></td>
    		</tr>
    		<tr>
    			<td>员工薪水</td>
    			<td><s:textfield name="salary" id="salary" value=""/></td>
    		</tr>
    		<tr>
    			<td>所属部门</td>
    			<td>
    			<!-- 传统的html标签 -->
    			<!--  
    			<select name="deptId">
    				<option value="-1" selected="selected" style="width: 80%">请选择</option>
    				<s:iterator var="dept" value="#request.listDept">
    					<option value="${dept.id}" style="width: 80%">
    						<s:property value="#dept.name"/>
    					</option>
    				</s:iterator>
    			</select>
    			-->
    			<!-- 
    				Struts下拉列表标签：
    					name:下拉列表标签的名称（服务器根据这个名称获取选择的项 的实际的值）
    					list:下拉列表显示数据的集合
    					headerValue:默认下拉列表显示的内容
    					headerKey:默认选择项的实际的值
    					listKey:集合对象的那个属性作为下拉列表的实际的值
    					listValue:集合对象的那个属性作为下拉列表显示的值
    					value:默认选择的项的设置
    			 -->
    			 
    				<s:select 
    					name="deptId"
    					list="#request.listDept"
    					headerValue="请选择"
    					headerKey="-1"
    					listKey="id"
    					listValue="name"
    					></s:select>
    				
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    				<s:submit value="添加员工"></s:submit>
    			</td>
    		</tr>
    	</table>
    </s:form>
  </body>
</html>
