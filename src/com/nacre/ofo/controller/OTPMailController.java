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


@WebServlet("/SendMailController")
public class OTPMailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final String from = "sachinamore.sm.97@gmail.com";
	
		
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession hs=null;
        hs=request.getSession();    
        
        // Sender's email ID needs to be mentioned
        String to = (String) hs.getAttribute("email");
             
        // Get system properties
       // Properties properties = System.getProperties();
        Properties properties = new Properties();
       // Setup mail server
       /* properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
*/
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
         message.setSubject("OTP from Delivered&Oredered Restourent!");
         
         
         Random generator = new Random();
         generator.setSeed(System.currentTimeMillis());
 		  
         int num = generator.nextInt(99999) + 99999;
         if (num < 100000 || num > 999999) {
        	 num = generator.nextInt(99999) + 99999;
        	 if (num < 100000 || num > 999999) {
        		 throw new Exception("Unable to generate PIN at this time..");
        	 }
         }
         String pin=Integer.toString(num);
         
         
         hs.setAttribute("otp",pin);
         // Now set the actual message
         message.setText("Send the OTP to get New Password "+pin);
         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
         
         RequestDispatcher rd=request.getRequestDispatcher("forgetUpdatePassword.jsp");
		 rd.forward(request, response);
      }catch (MessagingException mex) {
         mex.printStackTrace();
      } catch (Exception e) {
		e.printStackTrace();
      }
    }
}

