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
			<input type="submit" value="退出">
		</c:if>
	</div>