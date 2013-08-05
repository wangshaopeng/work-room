 <%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	<script language="javascript">
	function changePage(pageNo)
	{
		document.myform.cp.value=pageNo;
		document.myform.submit();
	}
	function changeLineSize()
	{
		document.myform.submit();
	}
	</script>
  </head>
  
  <body>
     <form action="SericeServlet?status=list" method="post" name="myform">
    <input type="hidden" name="cp" value/>
    <table border="1">
    	<tr>
    		<td>ID</td>
    		<td>标题</td>
    		<td>花费</td>
    		<td>时间</td>
    		<td>操作</td>
    	</tr>
    	<c:if test="${not empty list}">
    	<c:forEach var="s"items="${list}">
    	<tr>
    		<td>${s.id }</td>
    		<td>${s.title }</td>
    		<td>${s.cost }</td>
    		<td>${s.cost_time }</td>
    		<td><a href="SericeServlet?status=update&id=${s.id}">修改</a>
    		<a href="SericeServlet?status=delete&id=${s.id}">删除</a>
    		</td>
    	</tr>
    	</c:forEach>
    	</c:if>
    	
    		<tr>
    		<td colspan="2">
    		<a href="SericeServlet?status=list&cp=1">首页</a>
    		<a href="SericeServlet?status=list&cp=${currentPage-1 }" ${currentPage==1?"style='display:none;'":""}>上一页</a>
    		<a href="SericeServlet?status=list&cp=${currentPage+1 }" ${currentPage==totalPage?"style='display:none;'":"" } >下一页</a>
    		<a href="SericeServlet?status=list&cp=${totalPage }">尾页</a>
    		</td>
    		<td colsapn="2">
    		第<select onchange="changePage(this.value)">
    			<c:if test="${not empty pages}">
    			<c:forEach var="i" items="${pages}">
    			<option value="${i }"${currentPage==i?"selected":"" }>${i }</option>
    			</c:forEach>
    			</c:if>
    		</select>页
    		每页显示
    		<select name="lineSzie" onchange="changeLineSize()">
	    		<option ${lineSize==5?"selected":""} value="5">5</option>
	    		<option ${lineSize==10?"selected":""} value="10" >10</option>
	    		<option ${lineSize==15?"selected":""} value="15" >15</option>
	    		<option ${lineSize==20?"selected":""} value="20" >20</option>
    		</select>条
    		</td>
    		
    	</tr>
    	<tr>
    		<td colspan="4"><a href="insert.jsp">添加</a></td>
    	</tr>

    </table>
    </form>
  </body>
</html>
