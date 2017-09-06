package com.newlecture.javaweb.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/admin/notice/reg")
public class NoticeRegController extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
	   
	   response.setContentType("text/html; charset=UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   //사용권한이 있는지 , 인증이 되어있는지
	   PrintWriter out = response.getWriter();
	   HttpSession session = request.getSession();
	   if(session.getAttribute("id")==null)
		   out.write(
				   "<script>alert('로그인이 필요한 요청입니다.');"
				   + "location.href='../../member/login';</script>");
	   else
        request.getRequestDispatcher("/WEB-INF/views/admin/notice/reg.jsp").forward(request, response);
   }
   //----------------------------------------------------------------------------------------------------------------------------------------------------
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("UTF-8");
	   String id = request.getParameter("id");
	   String title = request.getParameter("title");
	   String content = request.getParameter("content");
	   
	   
	   String sql = "INSERT INTO Notice(id,title, content, writerId) VALUES((select ifnull(max(cast(id as signed integer)),0)+1 from Notice as b),?,?,?)";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
		   Class.forName("com.mysql.jdbc.Driver");  

		   // 연결 / 인증
		    Connection con = DriverManager.getConnection(url, "sist", "cclass");

		    // 실행
		    /*Statement st = con.createStatement();*/
		    PreparedStatement st = con.prepareStatement(sql);
		    st.setString(1, title);
		    st.setString(2, content);
		    st.setString(3, "newlec");

		    // 결과 가져오기
		    /*ResultSet rs = st.executeQuery(sql);아니야!!*/
		   /* ResultSet rs = st.executeQuery();*/
		    int result = st.executeUpdate();

		      st.close();
		      con.close();
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		response.sendRedirect("list");
/*		
       request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);*/
/*       request.getRequestDispatcher("/WEB-INF/views/customer/notice/detail.jsp").forward(request, response);
*/	   
	   
	}
}
