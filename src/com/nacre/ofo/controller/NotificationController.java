package com.nacre.ofo.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/notification")
public class NotificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx=null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("applicationn/json");
		response.getWriter();		
				
		/*NotificationServiceI notificationServiceI=new NotificationServiceImpl();	*/
		try {
			/*int count=notificationServiceI.notificationService();*/
			ctx=getServletContext();
			int count=(int) ctx.getAttribute("newOrderCount");			
			Gson g= new Gson();				
			String s=g.toJson(count);
			response.getWriter().write(s);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
