<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">	<%@include file="Head.jsp" %></div>
	<div id="update">
		<jsp:useBean id="book" scope="request" class="com.zgh.Bean.BookBean" />
		<form action="updateBook" method="post">
		<table>
			<tr>
				<td>ISBN</td>
				<td>${book.getIsbn() }<input type="hidden" name="bookisbn" value="${book.getIsbn() }" ></td>
			</tr>
			<tr>
				<td>书名</td>
				<td>${book.getName() }</td>
			</tr>
			<tr>
				<td>类别</td>
				<td>${book.getIntro() }</td>
				<td>修改：
					<select name="newintro">
						<option value="小说">小说</option>
						<option value="诗歌散文">诗歌散文</option>
						<option value="程序设计">程序设计</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>单价</td>
				<td>${book.getPrice() }</td>
				<td>修改：<input type="text" name="newprice"></td>
			</tr>
			<tr>
				<td>数量</td>
				<td>${book.getCount() }
				<td>修改：<input type="text" name="newcount"></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><img src="${book.getImage() }" alt="${book.getName()}" width='100' height='100' ></td>
				
			</tr>
			<tr>
				<td><input type="submit" value="确定"></td>
				<td><input type="submit" value="取消"></td>
		</table>
		</form>
	</div>
</body>
</html>