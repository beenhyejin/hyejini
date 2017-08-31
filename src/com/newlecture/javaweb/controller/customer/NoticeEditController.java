package com.newlecture.javaweb.controller.customer;

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

@WebServlet("/customer/notice-edit")
public class NoticeEditController extends HttpServlet{
	 /*한글깨지는거
   @Override
 	/*service - 무조건 처리. 
   doGet - get만 처리 
   doPost - post만 처리 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
       // response.sendRedirect("notice.jsp");
	   
	   
	   
	   System.out.println("get 수정");
	   String  _id = request.getParameter("id"); 
	   String id = ""; // 기본값
		
		if(_id != null && !_id.equals(""))
			id=_id;
		//------------------출력-----------------
		Notice n= null;
		
		//-------------DB(dao)------------------
		NoticeDao noticeDao = new JdbcNoticeDao();
		n=noticeDao.get(id);
	
		request.setAttribute("detail",n);
        request.getRequestDispatcher("/WEB-INF/views/customer/notice/edit.jsp").forward(request, response);
   }
   //----------------------------------------------------------------------------------------------------------------------------------------------------
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("UTF-8");
	   
	   System.out.println("post!!!!");
	   String id = request.getParameter("id");
	   String title = request.getParameter("title");
	   String content = request.getParameter("content");
	   
	   //-------------------DB(dao)-----------------------------------
	   NoticeDao noticeDao = new JdbcNoticeDao();
	   noticeDao.edit(id,title, content);
	 
		
	   response.sendRedirect("notice-detail?id="+id);
		
	}
}
