package com.nacre.ofo.controller;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.com.test.Code;
import mail.com.test.Constants;


@WebServlet("/PayOrderMailController")
public class PayOrderMailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final String from = "sachinamore.sm.97@gmail.com";	
		
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          
        // Sender's email ID needs to be mentioned
        String to =request.getParameter("emailPay");
             
        // Get system properties
       // Properties properties = System.getProperties();

        // Setup mail server
       /* properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "27");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");*/
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
       // Get the default Session object. 
       Session session ; 
           session = Session.getInstance(properties,new javax.mail.Authenticator() {
        	   protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(from,Code.getDecryptPassword(Constants.GMAIL_PASSWORD));
               }
           });
        session.setDebug(true);
        try{
         // Create a default MimeMessage object.
          MimeMessage  message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("From Delivered&Oredered Restourant!");              
        
         // Now set the actual message
         message.setText("Your Order Successfully accepted,  Within Half an Hour  we will deliver your Item."
         		+ "\n Thanks! for visiting our Restourant..");
         // Send message
         Transport.send(message);

         RequestDispatcher rd=request.getRequestDispatcher("/YourOrdersController");
		 rd.forward(request, response);
      }catch (MessagingException mex) {
         mex.printStackTrace();
      } catch (Exception e) {
		e.printStackTrace();
      }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}

