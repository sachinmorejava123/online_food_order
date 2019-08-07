package com.nacre.ofo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.services.NewAddedOrdersServiceI;
import com.nacre.ofo.services.NewAddedOrdersServiceImpl;


@WebServlet("/NewAddedOrdersController")
public class NewAddedOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs=null;
				
		NewAddedOrdersServiceI newAddedOrdersServiceI=new NewAddedOrdersServiceImpl();	
		try {
			List<OrderDto> list=newAddedOrdersServiceI.newAddedOrdersService();		
			System.out.println(list);
			if(list!=null) {
				hs=request.getSession();
				hs.setAttribute("list",list);		
				RequestDispatcher rd=request.getRequestDispatcher("newAddedOrders.jsp");
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
