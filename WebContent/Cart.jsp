<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*,javax.servlet.*,java.io.*,javax.websocket.Session,com.zgh.Dao.*,com.zgh.Bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="head">		<%@include file="Head.jsp" %>	</div>
	<a href="/bookstore/Home.jsp">返回</a>
	<div id="cart" style="background-color:#99e699;">
		<h1>您已选择的商品</h1>
		<table>
			<%!BookDao bookdao=new BookDao();BookBean bookbean; %>
			<c:forEach var="cart" items="${sessionScope.carts }" varStatus="status">
				<tr>
					<td><a href="/bookstore/displayBook?isbn=${cart.getBookisbn()}">${cart.getBookisbn()}</a></td>
					<td>${cart.getBook().getName() }</td>
					<td>${cart.getCount() }</td>
					<td>${cart.getCost() }</td>
					
			</c:forEach>
		</table>
	</div>
	
	<div id="foot">	<%@include file="Foot.jsp" %></div>
</body>
</html>