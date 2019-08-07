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

import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.services.MenuItemsServiceI;
import com.nacre.ofo.services.MenuItemsServiceImpl;

@WebServlet("/MenuItemsController")
public class MenuItemsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs=null;
		
		int recordsPerPage=6;
        int currentPage=1;
		int totalNumberOfRecords=0;
		int numberOfPages=0;
		int startIndex=0;
				
		String sCurrentPage=request.getParameter("currentPage");
		if(sCurrentPage!=null && !"".equals(sCurrentPage)) {
			currentPage=Integer.parseInt(sCurrentPage);
			if(currentPage!=1)
				startIndex=(currentPage*recordsPerPage)-recordsPerPage;
			else 
				startIndex=0;
		}
		else
			startIndex=0;
		
		MenuItemsServiceI menuService=new MenuItemsServiceImpl();		
		
		try {
			List<ItemsDto> list=menuService.menuItemsService(startIndex,recordsPerPage);
			totalNumberOfRecords=menuService.getTotalNumberOfRecords();	
			System.out.println("totalNumberOfRecords"+totalNumberOfRecords);
			
			hs=request.getSession();
			String userName=(String) hs.getAttribute("name");
			
			if(list!=null){					
				request.setAttribute("list",list);
				numberOfPages = totalNumberOfRecords / recordsPerPage;		        		        
			    if(numberOfPages % recordsPerPage > 0) 
			    numberOfPages++;
			    	        
			    request.setAttribute("noOfPages", numberOfPages);
			    request.setAttribute("currentPage", currentPage);
			    request.setAttribute("recordsPerPage", recordsPerPage);
				
				if(userName!=null) {
					int roleId=(int) hs.getAttribute("roleId");	
					if(roleId==1) {	
						RequestDispatcher rd=request.getRequestDispatcher("viewItems.jsp");
						rd.include(request, response);
					}
					else{
						RequestDispatcher rd=request.getRequestDispatcher("menu.jsp");
						rd.include(request, response);
					}
				}
				else {			
					RequestDispatcher rd=request.getRequestDispatcher("menuHome.jsp");
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
