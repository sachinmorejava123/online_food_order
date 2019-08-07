package com.nacre.ofo.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {
	public static Connection getConnection() {
		Connection con= null;
		try	{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","root");
			System.out.println("conn at Utility	:"+con);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}