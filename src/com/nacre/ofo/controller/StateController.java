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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.ofo.dto.CountryDto;
import com.nacre.ofo.dto.StateDto;
import com.nacre.ofo.services.AddressServiceI;
import com.nacre.ofo.services.AddressServiceImpl;


@WebServlet("/StateController")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("applicationn/json");
		PrintWriter pw=response.getWriter();
		
		int sid=Integer.parseInt(request.getParameter("stateid"));
		
		CountryDto cdto=new CountryDto();
		cdto.setCid(sid);
		StateDto dto=new StateDto();
		dto.setCountryId(cdto);
		
		AddressServiceI addressServiceI=new AddressServiceImpl();	
		try {
			List l=addressServiceI.StateService(sid);
			Gson g= new Gson();				
			String s=g.toJson(l);
			pw.print(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
}
