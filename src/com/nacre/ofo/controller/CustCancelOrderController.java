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

import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.services.CustCancelOrderServiceI;
import com.nacre.ofo.services.CustCancelOrderServiceImpl;
import com.nacre.ofo.services.YourOrdersServiceI;
import com.nacre.ofo.services.YourOrdersServiceImpl;

@WebServlet("/CustCancelOrderController")
public class CustCancelOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		HttpSession hs=null;
		hs=request.getSession();
		
		String username=(String) hs.getAttribute("name");
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		
		CustCancelOrderServiceI custCancelOrderServiceI=new CustCancelOrderServiceImpl();	
		try {
			int count=custCancelOrderServiceI.custCancelOrderService(username,orderId);		
			
			if(count>0) {		
				RequestDispatcher rd=request.getRequestDispatcher("/YourOrdersController");
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
