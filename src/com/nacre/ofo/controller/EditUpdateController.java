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

import com.nacre.ofo.dto.AddressDto;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.LoginDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.services.EditUpdateServiceI;
import com.nacre.ofo.services.EditUpdateServiceImpl;
@WebServlet("/EditUpdateController")
public class EditUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		HttpSession hs=null;
		
		String fullname=request.getParameter("fullname");		
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		String cityId=request.getParameter("city");			
		
		RegisterDto dto=new RegisterDto(); 
		dto.setCustFullName(fullname);		
		dto.setMobile(mobile);
		dto.setEmail(email);
		
		CityDto cDto=new CityDto();	
		cDto.setCityId(Integer.parseInt(cityId));
		
		AddressDto aDto=new AddressDto();
		aDto.setAddress(address);
		aDto.setPincode(pincode);
		aDto.setCityId(cDto);	
		
		dto.setAddressId(aDto);
		
		hs=request.getSession();
		int loginId=(int) hs.getAttribute("loginid");
		
		LoginDto ldto=new LoginDto();
		ldto.setLoginId(loginId);
		dto.setLoginId(ldto);
		
		EditUpdateServiceI  editUpdateServiceI=new EditUpdateServiceImpl();
		
		try {
			int i=editUpdateServiceI.editUpdateService(dto);
			
			hs=request.getSession();
			int roleId=(int) hs.getAttribute("roleId");
						
			if(i>0) {
				
				if(roleId==1) {
					pw.println("Sucess");
					RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
					rd.include(request, response);
				}
				else {
					pw.println("Sucess");
					RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
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
