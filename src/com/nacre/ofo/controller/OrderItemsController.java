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

import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.dto.LoginDto;
import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.services.EditServiceI;
import com.nacre.ofo.services.EditServiceImpl;
import com.nacre.ofo.services.OrderItemsServiceI;
import com.nacre.ofo.services.OrderItemsServiceImpl;


@WebServlet("/OrderItemsController")
public class OrderItemsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=null;	

		hs=request.getSession();
		int loginId=(int) hs.getAttribute("loginid");		
		String username=(String) hs.getAttribute("name");	
		
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		int quantity=Integer.parseInt(request.getParameter("qty"));
		
		OrderDto dto=new OrderDto();
		ItemsDto iDto=new ItemsDto();
		iDto.setItemId(itemId);
		dto.setItemId(iDto);
		dto.setQuantity(quantity);
		
		hs.setAttribute("itemId",itemId);
		
		RegisterDto rdto=new RegisterDto();
		LoginDto ldto=new LoginDto();
		ldto.setUsername(username);
		ldto.setLoginId(loginId);
		rdto.setLoginId(ldto);
		dto.setRegId(rdto);
		
		OrderItemsServiceI orderItemsServiceI=new OrderItemsServiceImpl();
		
		try {
			OrderDto odto=orderItemsServiceI.orderItemsService(dto)	;			
			if(dto!=null){				
				hs.setAttribute("dto",odto);
				RequestDispatcher rd=request.getRequestDispatcher("payMoney.jsp");
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
