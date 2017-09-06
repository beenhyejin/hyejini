package com.newlecture.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.javaweb.dao.NoticeDao;
import com.newlecture.javaweb.entity.Notice;
import com.newlecture.javaweb.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao {
	
	

	public List<NoticeView> getList(int page, String query) {
		List<NoticeView> list= null; 
		String sql = "SELECT * FROM NoticeView WHERE title like ? order by regDate DESC limit ?,10";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		
		int offset= (page-1)*10;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 / 인증
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, offset);

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// Model
			list = new ArrayList<>();

			// 결과 사용하기
			while (rs.next()) {
				NoticeView n = new NoticeView();
				n.setId(rs.getString("ID"));
				n.setTitle(rs.getString("TITLE"));
				n.setWriterId(rs.getString("WRITERID"));
				n.setWriterName(rs.getString("writerID"));
				n.setHit(rs.getInt("HIT"));
				n.setContent(rs.getString("CONTENT"));
				n.setRegDate(rs.getDate("REGDATE"));
				n.setCountCmt(rs.getInt("countCmt"));

				list.add(n);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	} 

	public int getCount() {
		int count= 0;
		String sqlCount = "SELECT COUNT(id) as count FROM Notice";

		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 / 인증
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// 실행
			Statement stCount = con.createStatement();

			// 결과 가져오기
			ResultSet rsCount = stCount.executeQuery(sqlCount);

			rsCount.next();
			
			// Model
			count = rsCount.getInt("count");

			// 결과 사용하기

			rsCount.close();
			stCount.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public NoticeView get(String id) {
			
			//------------------출력-----------------
			NoticeView n= null;


			/*String sql = "SELECT * FROM Notice WHERE id = ?";*/
			String sql = "SELECT * FROM NoticeView WHERE id = ?";
			String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

			// JDBC 드라이버 로드
			try {
			   Class.forName("com.mysql.jdbc.Driver");  

			   // 연결 / 인증
			    Connection con = DriverManager.getConnection(url, "sist", "cclass");

			    // 실행
			    PreparedStatement st = con.prepareStatement(sql);
			    st.setString(1, id);

			    // 결과 가져오기
			    ResultSet rs = st.executeQuery();

			    // 결과 사용하기
			    if (rs.next()) {
			       n = new NoticeView();
			       n.setId(rs.getString("ID"));
			       n.setTitle(rs.getString("TITLE"));
			       n.setHit(rs.getInt("HIT"));
			       n.setContent(rs.getString("CONTENT"));
			       n.setRegDate(rs.getDate("REGDATE"));
			       n.setWriterId(rs.getString("WRITERID"));
			       n.setWriterName(rs.getString("WRITERNAME"));
			       n.setCountCmt(rs.getInt("COUNTCMT"));
			    }

			      rs.close();
			      st.close();
			      con.close();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		return n;
	}

	@Override
	public void edit(String id, String title, String content) {
		  String sql = "UPDATE Notice SET title= ?,content = ? WHERE id = ?";
			String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

			// JDBC 드라이버 로드
			try {
			   Class.forName("com.mysql.jdbc.Driver");  

			   // 연결 / 인증
			    Connection con = DriverManager.getConnection(url, "sist", "cclass");

			    PreparedStatement st = con.prepareStatement(sql);
			    st.setString(1, title);
			    st.setString(2, content);
			    st.setString(3, id);

			    int result = st.executeUpdate();
			    if(result==1)
			    	System.out.println("수정완료");
			      st.close();
			      con.close();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		
		
	}

}
