package com.newlec.javaweb.controller.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaweb.dao.NoticeDao;
import com.newlecture.javaweb.dao.jdbc.JdbcNoticeDao;
import com.newlecture.javaweb.entity.Notice;

@WebServlet("/member/agree")
public class AgreeController extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
        request.getRequestDispatcher("/WEB-INF/views/member/agree.jsp").forward(request, response);   
   }
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String  _agree = request.getParameter("agree"); 
	   String agree = "no"; // 기본값	
		if(_agree != null && !_agree.equals(""))
			agree=_agree;
		
	   if(!agree.equals("ok"))
		   response.sendRedirect("agree?error=1");
	   else
		   //동의한 것을 새로요청을 받아 뿌려줘야함
		   response.sendRedirect("join");
	 
	}
}
