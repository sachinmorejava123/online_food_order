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

@WebServlet("/ChangePasswordController")
public class ChangePasswordController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=null;
		
		String username=request.getParameter("username");
		String oldPassword=request.getParameter("oldPassword");
		String newPassword=request.getParameter("newPassword");
		String reNewPassword=request.getParameter("reNewPassword");
		
		ChangePasswordDto dto=new ChangePasswordDto(); 
		dto.setUsername(username);
		dto.setOldPassword(oldPassword);
		dto.setNewPassword(newPassword);
		dto.setReNewPassword(reNewPassword);
		
		ChangePasswordSeviceI changePasswordSeviceI=new ChangePasswordServiceImpl();
		
		hs=request.getSession();
		int roleId=(int) hs.getAttribute("roleId");
		
		try {
			int i=changePasswordSeviceI.changePasswordService(dto);
			
			if(i>0) {
				RequestDispatcher rd=request.getRequestDispatcher("signin.jsp");
				rd.include(request, response);
			}
			else {
				request.setAttribute("error","error");
				if(roleId==1) {
					RequestDispatcher rd=request.getRequestDispatcher("changePasswordAdmin.jsp");
					rd.include(request, response);
				}
				if(roleId==2) {
					RequestDispatcher rd=request.getRequestDispatcher("changePassword.jsp");
					rd.include(request, response);
				}
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
}
