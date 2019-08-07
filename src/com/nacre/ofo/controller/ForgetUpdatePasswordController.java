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
import com.nacre.ofo.dto.LoginDto;
import com.nacre.ofo.services.ForgetUpdatePasswordSeviceI;
import com.nacre.ofo.services.ForgetUpdatePasswordSeviceImpl;

@WebServlet("/ForgetUpdatePasswordController")
public class ForgetUpdatePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=null;		
		
		hs=request.getSession();
		String username=(String) hs.getAttribute("Username");
		int loginId=(int) hs.getAttribute("LoginId");
		String otpRan=(String) hs.getAttribute("otp");
		int otpr=Integer.parseInt(otpRan);
		
		String password=request.getParameter("password");
		String otp=request.getParameter("otp");
		int otp1=Integer.parseInt(otp);
		
		LoginDto dto=new LoginDto();
		dto.setUsername(username);
		dto.setLoginId(loginId);
		dto.setPassword(password);
		
		ForgetUpdatePasswordSeviceI forgetUpdatePasswordSeviceI=null;
		if(otp1==otpr) {
		  dto.setOtp(otp);		
		  forgetUpdatePasswordSeviceI=new ForgetUpdatePasswordSeviceImpl();
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("forgetUpdatePassword.jsp");
			rd.include(request, response);
		}
		try {
			int i=forgetUpdatePasswordSeviceI.forgetUpdatePasswordSevice(dto);
			
			if(i>0) {				
				pw.println("Sucess");
				RequestDispatcher rd=request.getRequestDispatcher("signin.jsp");
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
