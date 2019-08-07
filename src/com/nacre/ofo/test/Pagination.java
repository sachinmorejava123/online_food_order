package com.nacre.ofo.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pagination")
public class Pagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SELECT_ITEMS_QUERY="SELECT ITEM_ID,ITEM_NAME,ITEM_PRICE,DELIVERY_CHARGE,DISCOUNT,ITEM_STATUS FROM ITEMS";
	public static final String COUNT_ITEMS_QUERY="SELECT COUNT(*) FROM ITEMS";
	
	Connection con=null;
	Statement ps=null,ps1=null;
	ResultSet rs1=null,rs=null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Akram");
			*/Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","root");
			ps=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);		
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}	
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		
		try {		
			int pageNumber=0;
			int totalNumberOfRecord=0;
			int recordPerPage=4;
			int startIndex=0;
			int numberOfPage=0;
			String sPageNumber=req.getParameter("pageNo");
			if(sPageNumber!=null && !"".equals(sPageNumber)) 
				pageNumber=Integer.parseInt(sPageNumber);
			else
				pageNumber=1;
			
			rs1=ps.executeQuery(COUNT_ITEMS_QUERY);
			rs1.next();
			totalNumberOfRecord=rs1.getInt(1);
			rs1.close();
			
			rs=ps.executeQuery(SELECT_ITEMS_QUERY);
			startIndex=(pageNumber*recordPerPage)-recordPerPage+1;
			pw.println("<center><table border=1>");
			rs.absolute(startIndex);
			int i=0;
			do {
				i++;
				pw.print("<tr><td>"+rs.getInt(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getInt(3)+"</td>");
				pw.print("<td>"+rs.getInt(4)+"</td>");
				pw.print("<td>"+rs.getFloat(5)+"</td>");
				pw.print("<td>"+rs.getString(6)+"</td></tr>");
			}while(rs.next() && i!=recordPerPage);
			
			pw.println("</table><br>");
			numberOfPage=totalNumberOfRecord/recordPerPage;
			if(totalNumberOfRecord>numberOfPage*recordPerPage)
				numberOfPage+=1;
			for(int k=1;k<=numberOfPage;k++)
				pw.print("<a href=?pageNo="+k+">"+k+" "+"</a>");
			pw.println("</center>");
			pw.close();
			rs.close();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
