package com.nacre.ofo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.ofo.dto.AddressDto;
import com.nacre.ofo.dto.CityDto;
import com.nacre.ofo.dto.ItemsDto;
import com.nacre.ofo.dto.LoginDto;
import com.nacre.ofo.dto.OrderDto;
import com.nacre.ofo.dto.RegisterDto;
import com.nacre.ofo.services.PaymentServiceI;
import com.nacre.ofo.services.PaymentServiceImpl;

@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();		
		
		HttpSession hs=null;
		
		String fullname=request.getParameter("fullname");		
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
		String cityId=request.getParameter("city");	
		
		hs=request.getSession();
		int itemId=(int) hs.getAttribute("itemId");
		/*int itemId=Integer.parseInt(request.getParameter("itemId"));*/
		
		float totalAmount=Float.parseFloat(request.getParameter("totalAmount"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		OrderDto dto=new OrderDto();
		dto.setQuantity(quantity);
		
		ItemsDto idto=new ItemsDto();
		idto.setItemId(itemId);
		idto.setTotalAmount(totalAmount);
		dto.setItemId(idto); 
		
		RegisterDto rdto=new RegisterDto();
		int regId=(int) hs.getAttribute("reg_id");
		rdto.setCustFullName(fullname);		
		rdto.setMobile(mobile);
		rdto.setEmail(email);
		rdto.setRegisterId(regId);		
		
		CityDto cDto=new CityDto();	
		cDto.setCityId(Integer.parseInt(cityId));
		
		AddressDto aDto=new AddressDto();
		aDto.setAddress(address);
		aDto.setPincode(pincode);
		aDto.setCityId(cDto);	
		
		rdto.setAddressId(aDto);
		
		int loginId=(int) hs.getAttribute("loginid");
		
		LoginDto ldto=new LoginDto();
		ldto.setLoginId(loginId);
		rdto.setLoginId(ldto);
		dto.setRegId(rdto);
		
		PaymentServiceI  paymentServiceI=new PaymentServiceImpl();
		
		try {
			int newOrderCount=paymentServiceI.paymentService(dto);
			
			ctx=getServletContext();
			ctx.setAttribute("newOrderCount",newOrderCount);
			
			if(newOrderCount>0) {	
				hs.setAttribute("totalAmount",totalAmount);
				hs.setAttribute("emailPay",email);
				pw.println("Sucess Your payment");
				RequestDispatcher rd=request.getRequestDispatcher("paymentByBank.jsp");
				rd.forward(request, response);				
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
