package com.nacre.ofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.services.YourOrdersServiceI;
import com.nacre.ofo.services.YourOrdersServiceImpl;

@WebServlet("/YourOrdersController")
public class YourOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		HttpSession hs=null;
		hs=request.getSession();
		
		String username=(String) hs.getAttribute("name");
		
		YourOrdersServiceI yourOrdersServiceI=new YourOrdersServiceImpl();	
		try {
			List<OrderDto> list=yourOrdersServiceI.yourOrdersService(username);		
		
			if(list!=null) {
				hs.setAttribute("list",list);		
				RequestDispatcher rd=request.getRequestDispatcher("yourOrders.jsp");
				rd.include(request, response);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
}
