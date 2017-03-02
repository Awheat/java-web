<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="web.com.entity.users" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  </head>
 
  <body>
    <h1 style="text-align:center;">用户列表</h1>
    <h3 style="text-align:center;"><a href="add.jsp">添加用户</a></h3>
    <div><%=path %>||<%=basePath %></div>
    <hr/>
    
    <table style="margin:0 auto;" border="1">
    	<thead>
    		<tr>
    			<th>编号</th>
    			<th>名字</th>
    			<th>性别</th>
    			<th>年龄</th>
    			<th>地址</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<tbody>
	    	<c:forEach items="${requestScope.userList}" var="u" varStatus="i">
	    		<tr>
	    			<td>${u.id}</td>
	    			<td>${u.name}</td>
	    			<td>${u.gender == 0?"男":"女"}</td>
	    			<td>${u.age}</td>
	    			<td>${u.address}</td>
	    			<td><a class="btn-delete" data-id="${u.id}">删除</a>|<a href="updateUserServlet?id=${u.id}">修改</a></td>
	    		</tr>
	    	</c:forEach>
    	</tbody>
    </table>    
  </body>
  <script type="text/javascript" src="./static/js/jquery.min.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$(".btn-delete").on('click',function(){
  			var result = confirm("确认删除吗？");
	  			if(result){
	  				$.get("deleteUserServlet",{id:$(this).attr('data-id')},function(data){
	  					if(data){
	  						window.location.reload();
	  					}
	  				});
	  			}
  		});
  	});
  </script>
</html>
