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

@WebServlet("/customer/notice-detail")
public class NoticeDetailController extends HttpServlet{
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     
       // response.sendRedirect("notice.jsp");
	   
	   
		String  _id = request.getParameter("id"); 
		String id = ""; // 기본값


		if(_id != null && !_id.equals(""))
			id=_id;
		/*System.out.println(id); */

		//------------------출력-----------------
		/*List<Notice> detail= null; */
		Notice n= null;


		String sql = "SELECT *FROM Notice WHERE id like ?";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
		   Class.forName("com.mysql.jdbc.Driver");

		   // 연결 / 인증
		    Connection con = DriverManager.getConnection(url, "sist", "cclass");

		    // 실행
		    /*Statement st = con.createStatement();*/
		    PreparedStatement st = con.prepareStatement(sql);
		    st.setString(1, "%"+id+"%");

		    // 결과 가져오기
		    /*ResultSet rs = st.executeQuery(sql);*/
		    ResultSet rs = st.executeQuery();

		    // Model 
		    /*detail= new ArrayList<>();*/
		      
		    // 결과 사용하기
		    while (rs.next()) {
		       n = new Notice();
		       n.setId(rs.getString("ID"));
		       n.setTitle(rs.getString("TITLE"));
		       //..
		         
		   /*    detail.add(n);*/
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
	   
	   
	   
        request.getRequestDispatcher("/WEB-INF/views/customer/notice/detail.jsp").forward(request, response);
   }
}
