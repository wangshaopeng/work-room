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
    		<td>����</td>
    		<td>����</td>
    		<td>ʱ��</td>
    		<td>����</td>
    	</tr>
    	<c:if test="${not empty list}">
    	<c:forEach var="s"items="${list}">
    	<tr>
    		<td>${s.id }</td>
    		<td>${s.title }</td>
    		<td>${s.cost }</td>
    		<td>${s.cost_time }</td>
    		<td><a href="SericeServlet?status=update&id=${s.id}">�޸�</a>
    		<a href="SericeServlet?status=delete&id=${s.id}">ɾ��</a>
    		</td>
    	</tr>
    	</c:forEach>
    	</c:if>
    	
    		<tr>
    		<td colspan="2">
    		<a href="SericeServlet?status=list&cp=1">��ҳ</a>
    		<a href="SericeServlet?status=list&cp=${currentPage-1 }" ${currentPage==1?"style='display:none;'":""}>��һҳ</a>
    		<a href="SericeServlet?status=list&cp=${currentPage+1 }" ${currentPage==totalPage?"style='display:none;'":"" } >��һҳ</a>
    		<a href="SericeServlet?status=list&cp=${totalPage }">βҳ</a>
    		</td>
    		<td colsapn="2">
    		��<select onchange="changePage(this.value)">
    			<c:if test="${not empty pages}">
    			<c:forEach var="i" items="${pages}">
    			<option value="${i }"${currentPage==i?"selected":"" }>${i }</option>
    			</c:forEach>
    			</c:if>
    		</select>ҳ
    		ÿҳ��ʾ
    		<select name="lineSzie" onchange="changeLineSize()">
	    		<option ${lineSize==5?"selected":""} value="5">5</option>
	    		<option ${lineSize==10?"selected":""} value="10" >10</option>
	    		<option ${lineSize==15?"selected":""} value="15" >15</option>
	    		<option ${lineSize==20?"selected":""} value="20" >20</option>
    		</select>��
    		</td>
    		
    	</tr>
    	<tr>
    		<td colspan="4"><a href="insert.jsp">���</a></td>
    	</tr>

    </table>
    </form>
  </body>
</html>
