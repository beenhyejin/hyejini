package com.newlecture.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.javaweb.dao.MemberDao;
import com.newlecture.javaweb.entity.Member;
import com.newlecture.javaweb.entity.NoticeView;

public class JdbcMemberDao implements MemberDao {

	@Override
	public int insert(String id, String pwd, String name, String phone, String email) {
		return insert(new Member(id, pwd, name, null, null, phone, email));

	}

	// 회원가입
	@Override
	public int insert(Member member) {
		System.out.println("1. insert입성");

		String sql = "INSERT INTO Notice(id,pwd,name,gender,birthday,phone,email) VALUES(?,?,?,?,?,?,?)";
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 연결 / 인증
			Connection con = DriverManager.getConnection(url, "sist", "cclass");

			// 실행
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member.getId());
			st.setString(2, member.getPwd());
			st.setString(3, member.getName());
			st.setString(4, member.getGender());
			st.setString(5, member.getBirthday());
			st.setString(6, member.getPhone());
			st.setString(7, member.getEmail());

			// 결과 가져오기
			ResultSet rs = st.executeQuery();
			int result = 0;
			result = st.executeUpdate();
			if (result == 0)
				System.out.println("실패");
			if (result == 1)
				System.out.println("실패");

			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Member get(String id) {

		Member m = new Member();

		String sql = "SELECT * FROM Member WHERE id = ?";
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
				m = new Member();
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("pwd"));
				m.setGender(rs.getString("gender"));
				m.setBirthday(rs.getString("birthday"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				m.setRegDate(rs.getDate("regDate"));
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

}
