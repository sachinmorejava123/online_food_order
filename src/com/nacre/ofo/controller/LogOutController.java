package com.nacre.ofo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogOutController")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		RequestDispatcher dispatcher = null;
		HttpSession session=request.getSession();
		try	{
			if(session!=null){
				session.invalidate();
			}
			session=request.getSession(false);
			dispatcher=request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request,response);
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		doGet(request,response);
	}
}
