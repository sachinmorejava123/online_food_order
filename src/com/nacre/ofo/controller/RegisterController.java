package com.nacre.ofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.ofo.dto.AddressDto;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.LoginDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.services.RegisterServiceI;
import com.nacre.ofo.services.RegisterServiceImpl;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String fullname=request.getParameter("fullname");		
		String dob=request.getParameter("dob");
		Date sdf=null;
		
		try {
			sdf = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		long ms=sdf.getTime();
		java.sql.Date d=new java.sql.Date(ms);
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String re_pass=request.getParameter("re-pass");
		
		String cityId=request.getParameter("city");		
		
		RegisterDto dto=new RegisterDto(); 
		dto.setCustFullName(fullname);
		dto.setDob(d);
		dto.setGender(gender);
		dto.setMobile(mobile);
		dto.setEmail(email);
		
		LoginDto ldto=new LoginDto();
		ldto.setUsername(username);
		ldto.setPassword(password);	
		dto.setLoginId(ldto);
		
		CityDto cDto=new CityDto();	
		cDto.setCityId(Integer.parseInt(cityId));
		
		AddressDto aDto=new AddressDto();
		aDto.setAddress(address);
		aDto.setPincode(pincode);
		aDto.setCityId(cDto);		
		
		dto.setAddressId(aDto);
				
		RegisterServiceI registerServiceI = new RegisterServiceImpl();
		
		try {
			int i=registerServiceI.registerService(dto);
			
			if(i>0) {
				RequestDispatcher rd=request.getRequestDispatcher("signin.jsp");
				rd.include(request, response);
			}
			else {
				
			}		
			
		} catch (SQLException e) {
			request.setAttribute("error","error");
			RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
			rd.include(request, response);
			e.printStackTrace();
		}		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
