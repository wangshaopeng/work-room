<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'insert.jsp' starting page</title>
    
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
   <form action="SericeServlet?status=insert" method="post">
   	<table>
    	<tr>
    	
    		<td>����</td>
    		<td>����</td>
    		<td>ʱ��</td>
    	</tr>
    	<tr>
    	 <td><input type="text" name="utitle" ></td>
    		<td><input type="text" name="ucost" ></td>
    		<td><input type="text" name="ucost_time" ></td>
    	</tr>
    	<tr>
    		<td colspan="4"><input type="submit" value="�ύ"></td>
    	</tr>
    	</table>
   	
   </form>
  </body>
</html>
