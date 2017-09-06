package com.newlec.javaweb.controller.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaweb.dao.MemberDao;
import com.newlecture.javaweb.dao.jdbc.JdbcMemberDao;
import com.newlecture.javaweb.entity.Member;


@WebServlet("/member/join")
public class JoinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = 0;

		String id = request.getParameter("mid");
		String[] pwds = request.getParameterValues("pwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String isLunar = request.getParameter("is-lunar");
		String[] birthdays = request.getParameterValues("birthday");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		
		//생일 문자열 합치기
		String birthday = new String();
		for (int i = 0; i < 3; i++)
			birthday = birthday.concat(birthdays[i]);

		Member member = new Member(id, pwds[0], name, gender,birthday, phone, email);

		MemberDao memberDao = new JdbcMemberDao();
		result = memberDao.insert(id, pwds[0], name, phone, email);

		if (result > 0)
			response.sendRedirect("confirm");
		else
			response.sendRedirect("../error?code=1234");
	}
}
