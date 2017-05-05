<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div id="foot" >
    	<c:forEach var="s" items="${applicationScope.sessionList }">
    	<p align="center">当前在线人数：${s.id }</p>
    	</c:forEach>
    	<p align="center" 当前在线人数：${applicationScope.count }></p>
   	 	<p align="center">没有内容</p>
    </div>
