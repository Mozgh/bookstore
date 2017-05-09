<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="head">	<%@include file="Head.jsp" %>	</div>
	<a href="/bookstore/Home.jsp">返回</a>
	<div id="OneBook" style="background-color:#99e699;width: 800" >
		<h1>${book.getName() }</h1>
		<div id="bookimage"><img src="${book.getImage() }" alt="${book.getName() }" width="100" height="100" ></div>
		<div id="bookinfo1">
			<form action="addCart" method="post">
			<input type="hidden" name="bookisbn" value="${book.getIsbn() }">
			<table border="0" style="width:400;height:100">
				<tr>
					<td>价格</td>
					<td>${book.getPrice() }</td>
				</tr>
				<tr>
					<td>库存</td>
					<td>${book.getCount() }</td>
				</tr>
				<tr>
					<td>输入数量</td>
					<td><input type="text" name="buycount"></td>
					<td><input type="submit" value="加入购物车"></td>
				</tr>
			</table>
			</form>
		</div>
	
		<div id="bookinfo2" style="background-color:#99e699;">
			<table >
				<tr>
					<td>ISBN</td>
					<td>${book.getIsbn() }</td>
				</tr>
				<tr>
					<td>简介</td>
					<td>${book.getIntro() }</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>