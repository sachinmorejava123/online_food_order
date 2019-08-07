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

import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.services.EditItemServiceI;
import com.nacre.ofo.services.EditItemServiceImpl;
import com.nacre.ofo.services.EditServiceI;
import com.nacre.ofo.services.EditServiceImpl;

@WebServlet("/EditItemsController")
public class EditItemsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		int itemID=Integer.parseInt(request.getParameter("itemId"));
		String itemName=request.getParameter("itemName");
		int itemPrice=Integer.parseInt(request.getParameter("price"));
		int deliveryCharge=Integer.parseInt(request.getParameter("deliveryCharge"));
		float discount=Float.parseFloat(request.getParameter("discount"));
		String itemStatus=request.getParameter("itemStatus");
		
		ItemsDto dto=new ItemsDto();
		dto.setItemId(itemID);
		dto.setItemName(itemName);
		dto.setItemPrice(itemPrice);
		dto.setDeliveryCharge(deliveryCharge);
		dto.setDiscount(discount);
		dto.setItemStatus(itemStatus);
		
		EditItemServiceI editItemsServiceI=new EditItemServiceImpl();		
		
		try {
			int edit=editItemsServiceI.EditItemService(dto);				
			
			if(edit>0){
				RequestDispatcher rd=request.getRequestDispatcher("/MenuItemsController");
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
