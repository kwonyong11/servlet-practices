<%@page import="com.bitacademy.guest.dao.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	Long no = Long.parseLong(request.getParameter("id"));
	String password = request.getParameter("password");
	
	new GuestbookDao().delete(no,password);
	
	response.sendRedirect("/guestbook01");
	
	
%>