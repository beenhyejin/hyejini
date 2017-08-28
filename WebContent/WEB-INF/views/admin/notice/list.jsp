<%-- <%@page import="com.newlecture.javaweb.entity.Notice"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%> --%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%
String  _title = request.getParameter("title"); 
String title = ""; // 기본값

application.setAttribute("x", "어플");
session.setAttribute("x", "세");
request.setAttribute("x", "리");
pageContext.setAttribute("x", "페");

if(_title != null && !_title.equals(""))
	title=_title;
/*System.out.println(title); */

//------------------출력-----------------
List<Notice> list= null; 

String sql = "SELECT *FROM Notice WHERE title like ?";
String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

// JDBC 드라이버 로드
try {
   Class.forName("com.mysql.jdbc.Driver");

   // 연결 / 인증
    Connection con = DriverManager.getConnection(url, "sist", "cclass");

    // 실행
    /*Statement st = con.createStatement();*/
    PreparedStatement st = con.prepareStatement(sql);
    st.setString(1, "%"+title+"%");

    // 결과 가져오기
    /*ResultSet rs = st.executeQuery(sql);*/
    ResultSet rs = st.executeQuery();

    // Model 
    list= new ArrayList<>();
      
    // 결과 사용하기
    while (rs.next()) {
       Notice n = new Notice();
       n.setId(rs.getString("ID"));
       n.setTitle(rs.getString("TITLE"));
       //..
         
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

pageContext.setAttribute("list", list);
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="notice"  method="get">
		<label>검색어</label>
		<input type="text"  name="title" />
		<input type="submit" />
	</form>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
			<%-- <%for(int i=0; i<list.size(); i++){ %> --%>
			<c:forEach var="n"  items="${list}" begin="0" end="2">
			<tr>
				<td>${n.id}</td>
				<td>${n.title}</td>
				<td>newlec</td>
				<td>${n.regDate}</td>
				<td>${n.hit}</td>
			</tr>
			</c:forEach>
			<%-- <% }%> --%>
		</table>
</body>
</html>

