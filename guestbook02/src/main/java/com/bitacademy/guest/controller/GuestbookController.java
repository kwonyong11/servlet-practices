package com.bitacademy.guest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.guest.dao.GuestbookDao;
import com.bitacademy.guest.vo.GuestbookVo;
import com.bitacademy.web.mvc.WebUtil;


public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String actionName=request.getParameter("a");
		if("form".equals(actionName)) {
			WebUtil.forward(request, response, "/WEB-INF/views/index.jsp");
		}else if("add".equals(actionName)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			new GuestbookDao().insert(vo);
			WebUtil.redirect(request, response, request.getContextPath()+"/gl");
		}
		else if("deleteform".equals(actionName)) {
			WebUtil.forward(request, response, "/WEB-INF/views/deleteform.jsp");
		}
		else if("delete".equals(actionName)) {
			Long no=Long.parseLong(request.getParameter("no"));
			String password=request.getParameter("password");
			
			new GuestbookDao().delete(no, password);
			WebUtil.redirect(request, response, request.getContextPath()+"/gl");
		}
		
		else {
			List<GuestbookVo> list = new GuestbookDao().findAll();
			
			request.setAttribute("list", list);
			WebUtil.forward(request, response, "/WEB-INF/views/index.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}