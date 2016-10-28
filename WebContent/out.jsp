<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//处理退出页面
	session.invalidate();

	response.sendRedirect("index.jsp");


%>