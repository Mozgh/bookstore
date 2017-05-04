<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="Head"><%@ include file="Head.jsp" %></div>
	
	<div id="add">
		<form action="addBook" enctype="multipart/form-data" method="post">
		<table border="0">
			<tr>
				<td>ISBN</td>
				<td><input type="text" name="bookisbn"></td>
			</tr>
			<tr>
				<td>书名</td>
				<td><input type="text" name="bookname"></td>
			</tr>
			<tr>
				<td>类别</td>
				<td><select name="bookintro">
						<option value="小说">小说</option>
						<option value="诗歌散文">诗歌散文</option>
						<option value="程序设计">程序设计</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>上传图片</td>
				<td><input type="file" name="bookimage"></td>
			<tr>
				<td>单价（元）</td>
				<td><input type="text" name="bookprice"></td>
			</tr>
			<tr>
				<td>数量</td>
				<td><input type="text" name="bookcount"></td>
			</tr>
			<tr>
				<td><input type="submit" value="确定"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>