package com.nacre.ofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.ofo.dto.LoginDto;
import com.nacre.ofo.services.LoginServiceI;
import com.nacre.ofo.services.LoginServiceImpl;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=null;
		int loginId=0;
		int roleId=0;
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		LoginDto dto=new LoginDto(); 
		dto.setUsername(username);
		dto.setPassword(password);
		
		LoginServiceI loginServiceI=new LoginServiceImpl();
		
		try {
			LoginDto loginDto=loginServiceI.loginService(dto);
			
			int newOrderCount=loginDto.getCountNewOrderLogin();
			ctx=getServletContext();
			ctx.setAttribute("newOrderCount",newOrderCount);
			
			if(loginDto!=null) {
				 loginId=loginDto.getLoginId();
				 roleId=loginDto.getRoleId().getRoleId();
				hs=request.getSession();
				hs.setAttribute("loginid",loginId);				
				hs.setAttribute("name",username);
				hs.setAttribute("roleId",roleId);
				hs.setAttribute("reg_id",loginDto.getReg_Id());
			}
				if(roleId==1) {	
					RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
					rd.include(request, response);
				}
				else if(roleId==2){
					RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
					rd.include(request, response);
				}else if(roleId==0) {
					RequestDispatcher rd=request.getRequestDispatcher("signinerror.jsp");
					rd.include(request, response);
				}
			
		
				
	
			
			
		} catch (SQLException e) {
			//request.setAttribute("error","error");
			
		}		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
}
