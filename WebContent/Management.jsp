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
	<div id="menage">
	<form action="addBook" method="post">
		<input type="submit" value="添加图书">
	</form>
	<table border="1">
		<tr>
			<th>IDBN</th>
			<th>书名</th>
			<th>库存量（本）</th>
			<th>类别</th>
			<th>单价（元）</th>
		</tr>
		<jsp:useBean id="booklist" scope="request" class="com.zgh.Bean.BookListBean" />
		
		<c:forEach var="book" items="${booklist.getBooklist() }" varStatus="status">
		<tr>
			<td>${book.getIsbn() }</td>
			<td>${book.getName() }</td>
			<td>${book.getCount() }</td>
			<td>${book.getIntro() }</td>
			<td>${book.getPrice() }</td>
			<td>
				<form action="updateBook" method="get" >
					<input type="hidden" name="bookisbn" value="${book.getIsbn() }">
					<input type="submit" value="修改">
				</form>
			</td>
			<td>
				<form action="deleteBook" method="post">
					<input type="hidden" name="bookisbn" value="${book.getIsbn() }">
					<input type="submit" value="删除">
				</form>
			</td>
		</c:forEach>
	</table>
	
	</div>
</body>
</html>