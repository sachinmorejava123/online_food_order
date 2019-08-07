package com.nacre.ofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.ofo.dto.ChangePasswordDto;
import com.nacre.ofo.services.ChangePasswordServiceImpl;
import com.nacre.ofo.services.ChangePasswordSeviceI;
import com.nacre.ofo.services.ForgetPasswordSeviceI;
import com.nacre.ofo.services.ForgetPasswordSeviceImpl;

@WebServlet("/ForgetPasswordController")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=null;
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		
		ForgetPasswordSeviceI forgetPasswordSeviceI=new ForgetPasswordSeviceImpl();
		
		try {
			int loginId=forgetPasswordSeviceI.forgetPasswordSevice(username,email);
			
			if(loginId>0) {
				hs=request.getSession();
				hs.setAttribute("Username",username);
				hs.setAttribute("email",email);
				hs.setAttribute("LoginId",loginId);
				pw.println("Sucess");
				RequestDispatcher rd=request.getRequestDispatcher("/SendMailController");
				rd.include(request, response);
			}
			else {
				
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
}
