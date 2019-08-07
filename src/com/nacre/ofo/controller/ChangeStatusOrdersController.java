package com.nacre.ofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.services.ChangeStatusOrdersServiceI;
import com.nacre.ofo.services.ChangeStatusOrdersServiceImpl;
import com.nacre.ofo.services.CustCancelOrderServiceI;
import com.nacre.ofo.services.CustCancelOrderServiceImpl;
import com.nacre.ofo.services.YourOrdersServiceI;
import com.nacre.ofo.services.YourOrdersServiceImpl;

@WebServlet("/ChangeStatusOrdersController")
public class ChangeStatusOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		HttpSession hs=null;
		hs=request.getSession();
		
		int status=Integer.parseInt(request.getParameter("status"));
		int orderId=Integer.parseInt(request.getParameter("orderId"));
		
				
		ChangeStatusOrdersServiceI changeStatusOrdersServiceI=new ChangeStatusOrdersServiceImpl();	
		try {
			OrderDto dto=changeStatusOrdersServiceI.changeStatusOrdersService(status,orderId);		
			String email=dto.getRegId().getEmail();
			int countNewOrder=dto.getCountNewOrder();
			ctx=getServletContext();
			ctx.setAttribute("newOrderCount",countNewOrder);
			if(email!=null) {
				if(status==2) {
					hs.setAttribute("emailCancel",email);
					RequestDispatcher rd=request.getRequestDispatcher("/CancelOrderMailController");
					rd.include(request, response);
				}
				else if(status==1) {
					RequestDispatcher rd=request.getRequestDispatcher("/NewAddedOrdersController");
					rd.include(request, response);
				}
				else {
					RequestDispatcher rd=request.getRequestDispatcher("/ViewOrdersController");
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
