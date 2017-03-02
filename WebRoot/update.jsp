<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
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
    <h1>修改信息-(UpdateUsers)</h1>
    <hr/>
    <form action="updateUserServlet" method="post">
   		<p><label>编号：</label><input type="text" name="id" readonly="readonly" value="${user.id}"></p>
    	<p><label>名字：</label><input type="text" name="username" value="${user.name}" placeholder="请输入用户名"></p>
    	<p>
    		<label>性别：</label>
    		<input type="radio" name="gender" value="0" <c:if test="${user.gender=='0'}">checked="checked"</c:if> >男
    		<input type="radio" name="gender" value="1" <c:if test="${user.gender=='1'}">checked="checked"</c:if>>女
    	</p>
    	<p><label>年龄：</label><input type="text" name="age" value="${user.age}" placeholder="请输入年龄"></p>
    	<p><label>地址：</label><input type="text" name="address" value="${user.address}" placeholder="请输入详细地址"></p>
    	<p><button type="submit">修改</button></p>
    </form>
  </body>
</html>
