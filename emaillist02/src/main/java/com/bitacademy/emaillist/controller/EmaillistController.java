package com.bitacademy.emaillist.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		
		String actionName=request.getParameter("a");
		if("list".equals(actionName)) {
			
		}else if("form".equals(actionName)) {
			
		}else {
			List<EmaillistVo> list = new EmaillistDao().findAll();
		}
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw=response.getWriter();
		pw.println("<h1>Emaillist!</h1>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
