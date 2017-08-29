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

import com.newlecture.javaweb.entity.Notice;

@WebServlet("/customer/notice-reg")
public class NoticeRegController extends HttpServlet{
   @Override
 /*  service - 무조건 처리. 
   doGet - get만 처리 
   doPost - post만 처리 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
       // response.sendRedirect("notice.jsp");
		String  _id = request.getParameter("id"); 
		String id = ""; // 기본값
		
		if(_id != null && !_id.equals(""))
			id=_id;
		//------------------출력-----------------
		Notice n= null;
		String sql = "INSERT INTO NOTICE(id, title, content, writerId) VALUES(?,?,?,?)";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
		   Class.forName("com.mysql.jdbc.Driver");  

		   // 연결 / 인증
		    Connection con = DriverManager.getConnection(url, "sist", "cclass");

		    // 실행
		    /*Statement st = con.createStatement();*/
		    PreparedStatement st = con.prepareStatement(sql);
		    st.setString(1, id);

		    // 결과 가져오기
		    /*ResultSet rs = st.executeQuery(sql);*/
		    ResultSet rs = st.executeQuery();

		    // Model 
		    /*detail= new ArrayList<>();*/
		      
		    // 결과 사용하기
		    if (rs.next()) {
		       n = new Notice();
		       n.setId(rs.getString("ID"));
		       n.setTitle(rs.getString("TITLE"));
		       n.setHit(rs.getInt("HIT"));
		       n.setContent(rs.getString("CONTENT"));
		       n.setRegDate(rs.getDate("REGDATE"));
		       n.setWriterId(rs.getString("WRITERID"));
		    }

		      rs.close();
		      st.close();
		      con.close();
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		request.setAttribute("detail",n);
        request.getRequestDispatcher("/WEB-INF/views/customer/notice/edit.jsp").forward(request, response);
   }
   //----------------------------------------------------------------------------------------------------------------------------------------------------
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  System.out.println("post!!!!");
	   String id = request.getParameter("id");
	   String title = request.getParameter("title");
	   String content = request.getParameter("content");
	   
	   
	   String sql = "UPDATE Notice SET title= ?,content = ? WHERE id = ?";
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
		    st.setString(3, id);

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
		
		response.sendRedirect("notice-detail?id="+id);
/*		
       request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);*/
/*       request.getRequestDispatcher("/WEB-INF/views/customer/notice/detail.jsp").forward(request, response);
*/	   
	   
	   
	   

	}
}
