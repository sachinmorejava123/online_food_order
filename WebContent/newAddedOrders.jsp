<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
   <%@page import="java.util.*,com.nacre.ofo.dto.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
     <head>
     <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
     <script src="./js/notification.js"></script>

     <title>Menu</title>
     <meta charset="utf-8">
     
     <meta name="viewport" content="width=device-width, initial-scale=1">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
          
	 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
     <link rel="icon" href="images/favicon.ico">
     <link rel="shortcut icon" href="images/favicon.ico" />
     <link rel="stylesheet" href="css/style.css">
	 <link rel="stylesheet" href="css/zerogrid.css" type="text/css" media="screen">
	 <link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen"> 
     <script src="js/jquery.js"></script>
     <script src="js/jquery-migrate-1.1.1.js"></script>
     <script src="js/superfish.js"></script>
     <script src="js/jquery.easing.1.3.js"></script>
     <script src="js/sForm.js"></script>
	 <script src="js/css3-mediaqueries.js"></script>
	 
	 <style type="text/css">
	 	.ancher {
			background:#ba4a00;
			color: white;
			border-style: outset;
			border-color: #0066A2;
			height: 30px;
			width: 140px;
			font: bold 16px arial, sans-serif;
			text-shadow:green;
			}
	 </style>
		
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/errorColor.css">
	<script>
	
	function validateForm(orderId){
		var id=document.getElementById(orderId).value;
		if (id=="" || id=="Select-Status") { 
			  document.getElementById("msg").innerHTML = 'Status must be select'; 
		      return false;             
        }	
    }
 	</script> 	
     
     </head>
     <body>
       <div class="main">
<!--==============================header=================================-->
 <header> 
  <div class="zerogrid">
    <div class="col-full">
	<div class="wrap-col">
    <a href="admin.jsp"><img src="images/logo.png" width="180" height="100" alt="EXTERIOR"></a>
    
         <div class="menu_block">
           <nav>
            <ul class="sf-menu">
                   <li><a href="admin.jsp">Home</a></li>
                   <li class="with_ul"><a href="addItems.jsp">Add Items</a>
				   	
				   </li>
                   <li><a href="./MenuItemsController">View Items</a></li>                   
                   <li><a href="./ViewOrdersController">View Orders</a>
                   </li>
				   <li><a href="admin.jsp">Hi!..  <%=session.getAttribute("name")%> </a>
				   		<ul>
                         <li><a href="./EditController?id=<%=session.getAttribute("name")%>">Edit Profile</a></li>
                         <li><a href="changePasswordAdmin.jsp">Change Password</a></li>
                         <li><a href="./LogOutController">Sign Out</a></li>
                     </ul>
				   </li>
				     <li style="padding-left:5px" class="current"> <a href="./NewAddedOrdersController"> <i class="fa fa-bell" style="font-size:22px;color:blue;"><sup style="font-size:18px; line-height: 0; vertical-align: 3px"><span class="num" id="count"/></sup></i></a></li>
                 </ul>
                 
                 <div class="col-1-2"> <br>       
       			 <form id="newsletter">
                  <div class="success">Your subscribe request has been sent!</div>
                  <label class="email">
                       <input type="text" placeholder="search foods">
                       <a href="#" class="btn" data-type="submit">Search</a> 
                        <span class="error">*This is not a valid food name</span>
                  </label> 
              	</form> 
          		</div>
                 
           </nav>
           <div class="clear"></div>
           </div>
           <div class="clear"></div>
		</div>
      </div>
    </div>
</header>

<!--=======content================================-->

<div class="content">
  <div class="zerogrid">
  
  	<h2>Our Items..</h2>
  <center>	<span style="color: red;font-size:18px;" > <b id="msg"></b></span></center>
  	 <table style="width: 100%">
  		<tr>
  		<%! int i=1; %>
  		<c:forEach items="${list}" var="list1">   
  					 
  		<%if(i%2==1){ %>
  			<td style="padding-right:30px;padding-bottom:15px;width:590px;height:80px;">  
  			<div class="row" style="background-color: white;">
	        <div class="col-1-2">
				<div class="wrap-col">
	          	<img src="images/img${list1.itemId.itemId}.png" width="209px" height="170px" alt="" class="img_inner">
			  	</div>
	        </div>
	        <div class="col-1-2">
				<div class="wrap-col">
	          	 	<b><div style="font-size:20px;color:red; margin-bottom:10px;"><a href="#">${list1.itemId.itemName}</a></div></b>   
	          	    <div style="font-size:large;margin-bottom:8px;"> Address : ${list1.regId.addressId.address}.  </div>
	          	  	<div style="font-size:large;margin-bottom:8px;"> City : ${list1.regId.addressId.cityId.cityName}.  </div>
	          	  	<div style="font-size:large;margin-bottom:8px;"> Price : Rs:- ${list1.itemId.itemPrice}/-</div>
	          	  	<div style="font-size:large;margin-bottom:8px;"> Quantity : ${list1.quantity}.  </div> 	
	          	  	<div style="font-size:large;margin-bottom:8px;"> Total Amount :Rs:- ${list1.itemId.totalAmount}.  </div> 
	          	  	<div style="font-size:large;margin-bottom:8px;"> Date of Orders : ${list1.orderDate}.  </div>	          	  	  
    			</div>
	        </div>
	        <form action="ChangeStatusOrdersController" method="post" class="mystatus" onsubmit="return validateForm(${list1.orderId})">
	        <div  style="font-size:large;padding-left:30px;margin-bottom:7px;">  Status of Orders : 
	        	<select name="status" class="statusid" style="font-size:18px" id="${list1.orderId}">	               
	               <option value="">${list1.orderStatusName}</option></select>                    
                   <input type="hidden" name="orderId" value="${list1.orderId}">
                   <input type="submit" value="Change Status" class="ancher"/>
                   <span style="color: red;font-size:18px;" > <b id="msg"></b></span>
             </div></form>
		</div>			  
		</td>
		<%} else{ %>
		
		<td style="padding-left:30px;padding-bottom:15px;width:590px;height:80px">  
		<div class="row" style="background-color: white;">
	        <div class="col-1-2">
				<div class="wrap-col">
	          		<img src="images/img${list1.itemId.itemId}.png" width="209px" height="170px" alt="" class="img_inner">
			  	</div>
	        </div>
	        <div class="col-1-2">
				<div class="wrap-col">
	          	 	<b><div style="font-size:20px;color:red; margin-bottom:10px;"><a href="#">${list1.itemId.itemName}</a></div></b>   
	          	  	<div style="font-size:large;margin-bottom:8px;"> Address : ${list1.regId.addressId.address}.  </div>
	          	  	<div style="font-size:large;margin-bottom:8px;"> City : ${list1.regId.addressId.cityId.cityName}.  </div>
	          	  	<div style="font-size:large;margin-bottom:8px;"> Price : Rs:- ${list1.itemId.itemPrice} /-</div>
	          	  	<div style="font-size:large;margin-bottom:8px;"> Quantity : ${list1.quantity}.  </div> 	
	          	  	<div style="font-size:large;margin-bottom:8px;"> Total Amount : Rs:- ${list1.itemId.totalAmount} /-  </div> 
	          	  	<div style="font-size:large;margin-bottom:8px;"> Date of Orders : ${list1.orderDate}.  </div>    	  
	          	    		
    			</div>
		</div>
		<form action="ChangeStatusOrdersController" method="post" class="mystatus" onsubmit="return validateForm(${list1.orderId})">
	        <div  style="font-size:large;padding-left:30px;margin-bottom:7px;">  Status of Orders : 
	        <select name="status" class="statusid" style="font-size:18px" id="${list1.orderId}"> 
	               <option value="">${list1.orderStatusName}</option></select>
                   <input type="hidden" name="orderId" value="${list1.orderId}">
                   <input type="submit" value="Change Status" class="ancher"/>
             </div></form>  
		</div></td> </tr>		
	<%}
	i++; %>	
	</c:forEach>
	</tr>  		
  	  		
  	
  	</table>	 
  
     
	<div class="row">
    <div class="bottom_block">
      <div class="col-1-2">
        <h3>Follow Us</h3>
        <div class="socials">
          <a href="#"></a>
          <a href="#"></a>
          <a href="#"></a>
        </div>
        <nav><ul>
                   
                   <li><a href="index.jsp">Home</a></li>
                   <li><a href="about.jsp">About Us</a></li>
                   <li class="current"><a href="menu.jsp">Menu</a></li>
                   <li><a href="portfolio.jsp">Offers</a></li>
                   <li><a href="news.jsp">News </a></li>
                   <li><a href="contact.jsp">Contacts</a></li>
                 </ul></nav>
      </div>
      <div class="col-1-2">
        <h3>Email Updates</h3>
        <p class="col1">Join our digital mailing list and get news<br> deals and be first to know about events</p>
        <form id="newsletter">
                  <div class="success">Your subscribe request has been sent!</div>
                  <label class="email">
                       <input type="email" value="Enter e-mail address" >
                       <a href="#" class="btn" data-type="submit">subscribe</a> 
                        <span class="error">*This is not a valid email address.</span>
                  </label> 
              </form> 
          </div>
      </div>
	  </div>
    </div>
  </div>
</div>
<!--==============================footer=================================-->

<footer>    
  <div class="zerogrid">
    <div class="col-full">
		<div class="wrap-col">
     Ordered&Delivered © 2018  &nbsp;&nbsp; |&nbsp;&nbsp;   <a href="#">Privacy Policy</a>    &nbsp;&nbsp;|&nbsp;&nbsp;  Designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster</a> - <a href="https://www.zerotheme.com/" title="free website templates">ZEROTHEME</a>
	 	</div>
    </div>
  </div>
</footer>

<!--===============================================================================================-->
	<!-- <!-- <script src="vendor/jquery/jquery-3.2.1.min.js"></script> --> -->
<!--===============================================================================================-->
	<!-- <!-- <script src="vendor/animsition/js/animsition.min.js"></script> --> -->
<!--===============================================================================================-->
	<!-- <script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script> -->
<!--===============================================================================================-->
	<!-- <script src="vendor/select2/select2.min.js"></script> -->
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>


</body>
</html>