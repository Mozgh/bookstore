<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
	<div id="head" style="text-align:left;background-color: #99bbff">
		<h1 style="margin-botton:0">欢迎光临书店</h1>
		<c:if test="${user==null }" scope="session" var="userIsEmpty">
			<form action="Login.jsp" ><input type="submit" value="登陆"></form>
		</c:if>
		<c:if test="${user!=null }" scope="session" var="userIsEmpty">
			当前用户:${user.getName()}
			<c:if test="${user.getName()=='admin' }">
				<form action="management" method="post">
					<input type="submit" value="管理">
				</form>
			</c:if>
			<c:if test="${user.getName()!='admin' }">
				用户名：${user.getName() }
				ID:${user.getId() }
				<a href="/bookstore/ToCart">购物车</a>
				<form action="ToCart" method="get">
					<input type="hidden" name="user" value="${user.getId()}">
					<input type="submit" value="购物车">
				</form>
 			</c:if>
			<a href="/bookstore/ToHome?userid=${user.getId() }">退出</a>
		</c:if>
	</div>