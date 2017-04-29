<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="head">		<%@include file="Head.jsp" %>	</div>
	<a href="/bookstore/Cart.jsp">购物车</a>
	<div id="BookList" style="background-color:#99e699;">
		<table>
			<tr>
				<th>ISBN</th>
				<th>Name</th>
				<th>Intro</th>
				<th>price</th>
			</tr>
			
			<c:forEach var="book" items="${sessionScope.books }" varStatus="status">
			<tr>
				<td>
					<a href="/bookstore/displayBook?isbn=${book.getIsbn()}">${book.getIsbn()}</a>
				</td>
				<td>${book.getName() }</td>
				<td>${book.getIntro() }</td>
				<td>${book.getPrice() }</td>
				
			</tr>
			
			</c:forEach>
		</table>
	
	
	</div>
	
	<div id="foot">	<%@include file="Foot.jsp" %></div>
</body>
</html>