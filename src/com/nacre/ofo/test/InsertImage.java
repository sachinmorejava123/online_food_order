package com.nacre.ofo.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/InsertImage")
@MultipartConfig
public class InsertImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String INSERT_QUERY="UPDATE ITEMS SET ITEM_IMAGE=? WHERE ITEM_ID=?";
	//ServletConfig arg=null;
	Connection con=null;
	PreparedStatement ps=null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Akram");*/
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","root");
					
			} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}	
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=res.getWriter();
		int sno=Integer.parseInt(req.getParameter("sno"));
		//String name=req.getParameter("name");
		Part p=req.getPart("image");
		if(p!=null) {
		try {			
			ps=con.prepareStatement(INSERT_QUERY);
		//	ps.setString(2,name);
			InputStream is=p.getInputStream();
			ps.setBlob(1,is);
			ps.setInt(2,sno);
			int insert=ps.executeUpdate();
			
			if(insert>0) {				
				System.out.println("Insertion Successfully");
				pw.println("<html>");
				pw.println("<body bgcolor=orange>");
				pw.println("<h1> !you are inserted Image successfully. </h1>");
				pw.println("</body>");
				pw.println("</html>");
				res.sendRedirect("imageinsert.html");
			}
			else {
				System.out.println("Insertion not Success");
				pw.println("<html>");
				pw.println("<body bgcolor=orange>");
				pw.println("<h1> !you are not inserted Image successfully. </h1>");
				pw.println("</body>");
				pw.println("</html>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}}
		pw.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
