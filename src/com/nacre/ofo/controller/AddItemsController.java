package com.nacre.ofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.services.AddItemsServiceI;
import com.nacre.ofo.services.AddItemsServiceImpl;

@WebServlet("/AddItemsController")
@MultipartConfig
public class AddItemsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		HttpSession hs=null;
		
		String itemName=request.getParameter("itemname");
		int price=Integer.parseInt(request.getParameter("price"));
		int delCharge=Integer.parseInt(request.getParameter("de_charge"));
		float discount=Float.parseFloat(request.getParameter("discount"));
		String itemStatus=request.getParameter("itemStatus");
		Part image=request.getPart("image");
		
		ItemsDto dto=new ItemsDto();
		dto.setItemName(itemName);
		dto.setItemPrice(price);
		dto.setDeliveryCharge(delCharge);
		dto.setDiscount(discount);
		dto.setItemStatus(itemStatus);
		dto.setItemImage(image);
		
		
		AddItemsServiceI addItemsServiceI=new AddItemsServiceImpl();	
		try {
			int itemId=addItemsServiceI.addItemsService(dto);	
			if(itemId>0) {

				hs=request.getSession();
				hs.setAttribute("itemId",itemId);
				RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
				rd.include(request, response);
			}
			else{
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
}
