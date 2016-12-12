<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  
<%--
String path = request.getContextPath();
response.sendRedirect(path+"/emp_list.action");
--%>

<!-- action只能重定向  不能转发！（即不能用客户端跳转） -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:redirect url="/emp_list.action"></c:redirect>