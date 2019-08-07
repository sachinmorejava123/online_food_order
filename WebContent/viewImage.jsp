<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
   <%@page import="java.util.*,com.nacre.ofo.dto.*" %>
<html>
    <head>
        <title>View Image</title>
    </head>    
    <body>    
        <b>View </b><br/><br/>        
		<%
		String id = request.getParameter("id");
		%>
		
		<img src="getImage.jsp?id=<%=id%>" height="200" width="300px"/>
    </body>
</html>