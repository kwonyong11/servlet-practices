<%@page import="com.bitacademy.guest.vo.GuestbookVo"%>
<%@page import="com.bitacademy.guest.dao.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String message = request.getParameter("message");
	
	GuestbookVo vo = new GuestbookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setMessage(message);
	new GuestbookDao().insert(vo);
	
	response.sendRedirect("/guestbook01");
%>