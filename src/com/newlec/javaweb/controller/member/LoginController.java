package com.newlec.javaweb.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaweb.dao.MemberDao;
import com.newlecture.javaweb.dao.jdbc.JdbcMemberDao;
import com.newlecture.javaweb.entity.Member;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {

   
    protected void doGet(  HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException{

             request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
       /*   url에 표시된 페이지를 주는 역할 */
      }
    
    
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
       
    
       String id=request.getParameter("id");
       String pwd=request.getParameter("pwd");
       
       MemberDao memberDao = new JdbcMemberDao();
       Member member=memberDao.get(id);
       
       if(member==null)
          response.sendRedirect("login?error");
       else if(!member.getPwd().equals(pwd))
          response.sendRedirect("login?error");
       else //인증이 성공
       {
          //현재 사용자의 상태 정보를 저장하는 저장소
          //세션 저장소
          request.getSession().setAttribute("id",id);
          response.sendRedirect("../index");
          //쿠키 저장소
          
          //모든 사용자의 상태정보를..
          //app6
          
       }
       /*System.out.println("ddd");*/
       /*redirect는 위에 webServlet주소를 기반으로.*/
    
      }
 
     
}