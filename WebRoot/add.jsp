<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <h1>添加用户-(AddUsers)</h1>
    <hr/>
    <form action="addUserServlet" method="post">
    	<p><label>名字：</label><input type="text" name="username" placeholder="请输入用户名"></p>
    	<p>
    		<label>性别：</label>
    		<input type="radio" name="gender" value="0" checked="checked">男
    		<input type="radio" name="gender" value="1">女
    	</p>
    	<p><label>年龄：</label><input type="text" name="age" placeholder="请输入年龄"></p>
    	<p><label>地址：</label><input type="text" name="address" placeholder="请输入详细地址"></p>
    	<p><button type="submit">添加</button></p>
    </form>
  </body>
</html>
