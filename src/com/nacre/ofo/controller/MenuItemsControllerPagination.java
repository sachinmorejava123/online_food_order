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

import com.nacre.ofo.dao.MenuItemsPaginationDAOImpl;
import com.nacre.ofo.dto.ItemsDto;

@WebServlet("/MenuItemsControllerPagination")
public class MenuItemsControllerPagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=null;
		
		int recordsPerPage=6;
        int currentPage=0;
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
		
		MenuItemsPaginationDAOImpl dao=new MenuItemsPaginationDAOImpl();		
		
		try {
			List<ItemsDto> list=dao.menuItemsPaginationDAO(startIndex,recordsPerPage);				
			hs=request.getSession();
			hs.setAttribute("list",list);
			
			totalNumberOfRecords=dao.getTotalNumberOfRecords();
			numberOfPages = totalNumberOfRecords / recordsPerPage;		        		        
		    if(numberOfPages % recordsPerPage > 0) {
		    	numberOfPages++;
		    }		        
		    request.setAttribute("noOfPages", numberOfPages);
		    request.setAttribute("currentPage", currentPage);
		    request.setAttribute("recordsPerPage", recordsPerPage);
			
			if(list!=null){									
				RequestDispatcher rd=request.getRequestDispatcher("menuHomePagination.jsp");
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
