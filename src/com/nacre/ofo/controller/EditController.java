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
import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.services.EditServiceI;
import com.nacre.ofo.services.EditServiceImpl;
import com.nacre.ofo.services.LoginServiceI;
import com.nacre.ofo.services.LoginServiceImpl;

@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=null;
		
		String username=request.getParameter("id");		
		EditServiceI editServiceI=new EditServiceImpl();
				
		try {
			RegisterDto dto=editServiceI.editService(username)	;			
			
			hs=request.getSession();
			int roleId=(int) hs.getAttribute("roleId");			
			
			if(dto!=null){
				if(roleId==1) {
					hs.setAttribute("dto",dto);
					RequestDispatcher rd=request.getRequestDispatcher("editProfileAdmin.jsp");
					rd.include(request, response);
				}
				else {
					hs.setAttribute("dto",dto);
					RequestDispatcher rd=request.getRequestDispatcher("editProfile.jsp");
					rd.include(request, response);
				}
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
