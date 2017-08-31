package com.newlecture.javaweb.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.newlecture.javaweb.dao.NoticeDao;
import com.newlecture.javaweb.dao.jdbc.*;
import com.newlecture.javaweb.entity.Notice;

@WebServlet("/customer/notice-list")
public class NoticeListController extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*		application.setAttribute("x", "어플");
		session.setAttribute("x", "세");e
		request.setAttribute("x", "리");
		pageContext.setAttribute("x", "페");*/
		
		/*페이지 번호 값 구하기*/
		int page = 1; //기본값
		int pageSize=5;
		
		String  _page = request.getParameter("p"); 	
		if(_page != null && !_page.equals(""))
			page=Integer.parseInt(_page);
		
		 
		/*int startNum= ((page-1)/pageSize)*pageSize+1;*/
		int startNum= page-(page-1)%pageSize;

		/* title 값 가져오기*/
		String  _query = request.getParameter("title"); 
		String query = ""; // 기본값
		if(_query != null && !_query.equals(""))
			query=_query;
		/*System.out.println(query); */

		//------------------출력-----------------
		List<Notice> list= null; 
		int count=0;
		
		//---------------DB(DAO)--------------------
		NoticeDao noticeDao = new JdbcNoticeDao();
		list = noticeDao.getList(page, query);
		count = noticeDao.getCount();
		
		request.setAttribute("list", list);
		
		/*pageContext.setAttribute("list", list);*/
		//response.sendRedirect("notice.jsp");
		request.getRequestDispatcher("/WEB-INF/views/customer/notice/list.jsp").forward(request, response);
	}
}
