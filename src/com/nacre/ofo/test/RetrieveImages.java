package com.nacre.ofo.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/retrieve1")
public class RetrieveImages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String SELECT_QUERY="SELECT PHOTO FROM STUDENT WHERE SNO=?";
	Connection con=null;
	PreparedStatement ps=null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Akram");
			*/Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc26","root","root");
					
			} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}	
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		byte[] img = null;
        int id =Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
		try	{
			ps=con.prepareStatement(SELECT_QUERY);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Blob image = rs.getBlob(1);
					img = image.getBytes(1,(int)image.length());
			}
			res.setContentType("image/png");
			OutputStream o=res.getOutputStream();
			o.flush();
			o.write(img);
			o.close();
			rs.close();
			ps.close();
			con.close();			
		}
		catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
