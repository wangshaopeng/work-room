<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
    <form action="SericeServlet?status=change&id=${mySerice.id }" method="post">
    	<table>
    	<tr>
    		<td>ID</td>
    		<td>标题</td>
    		<td>花费</td>
    		<td>时间</td>
    	</tr>
    	<tr>
    		<td>${mySerice.id }</td>
    		<td><input type="text" name="title" value="${mySerice.title }"></td>
    		<td><input type="text" name="cost" value="${mySerice.cost }"></td>
    		<td><input type="text" name="cost_time" value="${mySerice.cost_time }"></td>
    	</tr>
    	<tr>
    		<td colspan="4"><input type="submit" value="提交"></td>
    	</tr>
    	</table>
    </form>
  </body>
</html>
