package com.nacre.ofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.ofo.services.AddressServiceI;
import com.nacre.ofo.services.AddressServiceImpl;
import com.nacre.ofo.services.StatusServiceI;
import com.nacre.ofo.services.StatusServiceImpl;

@WebServlet("/StatusController")
public class StatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("applicationn/json");
		PrintWriter pw=response.getWriter();		
		StatusServiceI statusServiceI=new StatusServiceImpl();	
		try {
			List l=statusServiceI.statusService();		
			Gson g= new Gson();		
			
			String s=g.toJson(l);
			pw.print(s);				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
}
