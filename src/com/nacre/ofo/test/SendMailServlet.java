package com.nacre.ofo.test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final String from = "akramxyz1234@gmail.com";
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          // Recipient's email ID needs to be mentioned.
      String to = "akramrz12@gmail.com";
     // Sender's email ID needs to be mentioned
      
          // Get system properties
        Properties properties = System.getProperties();

      // Setup mail server
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

      // Get the default Session object. 
       Session session ;
           session = Session.getInstance(properties,new javax.mail.Authenticator() {
        	   protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(from,"Allah@90");
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
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText("This is actual message");

         // Send message
         Transport.send(message);
        // System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
    }
}

