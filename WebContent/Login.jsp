<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div id="login" style="text-align:left ;margin:0 auto;width:250px">
		<form action="LoginServlet" method="post">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>记住我</td>
				<td><input type="checkbox" name="remember" value="1"></td>
			</tr>
			<tr> 
				<td></td>
				<td>					
					<input type="submit" value="登录">
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div id="foot">	<%@include file="Foot.jsp" %></div>
</body>
</html>