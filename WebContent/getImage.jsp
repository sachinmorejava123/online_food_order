<%-- <%@page import="java.io.FileOutputStream"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.*" %>
<%@page import="javax.imageio.ImageIO" %>
<%
String id = request.getParameter("id"); 
Connection con = null;
ServletOutputStream out1=null;
 
try{
    Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Akram");
    PreparedStatement ps = con.prepareStatement("SELECT PHOTO FROM STUDENT WHERE SNO=?");
    ps.setString(1, id);
    ResultSet rs = ps.executeQuery();
    out1 = response.getOutputStream();
 
    if(rs.next()){
        while(rs.next()){	
				int sno=rs.getInt("SNO");
				String name=rs.getString("SNAME");
				System.out.println(sno +"  "+name);
				Blob image = rs.getBlob("PHOTO");
				int len = (int)image.length();
				byte [] img = new byte[len];
				InputStream readImg = image.getBinaryStream();
				int index=readImg.read(img, 0, len);
				readImg.close();
				response.resetBuffer();
				response.reset();
				out.write(img,0,len);
				out.flush();
			}
    }
}
catch(Exception e){
    e.printStackTrace();
}   
finally{
    if(con != null){
        try{
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
%> --%>

<%@page import="java.io.OutputStream"%>

<%@page import="java.sql.Blob"%>

<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose...">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>

<body>

<%

Connection con=null;
byte[] img = null;

try{
	int id=Integer.parseInt(request.getParameter("id"));

	Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Akram");
    PreparedStatement ps = con.prepareStatement("SELECT PHOTO FROM STUDENT WHERE SNO=?");
	ps.setInt(1,id );
	ResultSet rs=ps.executeQuery();

	if (rs.next()){
		Blob image = rs.getBlob(1);
		img = image.getBytes(1,(int)image.length());
	}
	response.setContentType("image/png");
	OutputStream o = response.getOutputStream();
	o.flush();
	o.write(img);
	o.close();
	rs.close();
	ps.close();
	con.close();
}

catch (Exception e){
	System.out.println(e);
}

%>

</body>

</html>