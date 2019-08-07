<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
   <%@page import="java.util.*,com.nacre.ofo.dto.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
     <head>
     <title>Menu</title>
     <meta charset="utf-8">
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
	 	.form-submit-button {
			background:green;
			color: white;
			border-style: outset;
			border-color: #0066A2;
			height: 33px;
			width: 128px;
			font: bold 16px arial, sans-serif;
			text-shadow:green;
			}
			
			#form-plus {
			background:green;
			color: white;
			border-style: outset;
			border-color: #0066A2;
			height: 25px;
			width: 30px;
			font: bold 18px arial, sans-serif;
			text-shadow:green;
			}
			
			#form-minus{
			background:red;
			color: white;
			border-style: outset;
			border-color: #0066A2;
			height: 25px;
			width: 30px;
			font: bold 18px arial, sans-serif;
			text-shadow:green;
			}
			
			
			.pagination {
  				display: inline-block;
			}	
			.pagination a {
  				color: black;
  				float: left;
  				padding: 8px 16px;
  				text-decoration: none;
			}
			.pagination a.active {
  				background-color: #4CAF50;
  				color: white;
			}
			.pagination a:hover:not(.active) {background-color: #ddd;}
	 </style>
	 
	<script>	
	function validateForm(itemId){
		var id=document.getElementById(itemId).value;
		if (isNaN(id) || id=="") { 
			  document.getElementById("msg").innerHTML = 'Value must be number'; 
		      return false;             
        }
		if(id==0 || id>5){	
			 document.getElementById("msg").innerHTML = 'Number must be 1 to 5';
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
    <a href="welcome.jsp"><img src="images/logo.png" width="190" height="155" alt="EXTERIOR"></a>
    
         <div class="menu_block">
           <nav>
            <ul class="sf-menu">
                   <li><a href="welcome.jsp">Home</a></li>
                   <li class="with_ul"><a href="#">Food items</a>
				   	<ul>
                         <li><a href="./MenuItemsController">Non-Veg</a></li>
                         <li><a href="./MenuItemsController">Veg</a></li>
                         <li><a href="#">Services</a></li>
                     </ul>
                  
				   </li>				   
                   <li class="current"><a href="./MenuItemsController">Menu</a></li>
                   <li><a href="offers.jsp">Offers</a></li>                   
                   <li><a href="contact.jsp">Contacts</a></li>
				   <li><a href="welcome.jsp">Hi!..  <%=session.getAttribute("name")%> </a>
				   		<ul>
				   		 <li><a href="./YourOrdersController?username=<%=session.getAttribute("name")%>">Your Orders</a></li>
                         <li><a href="./EditController?id=<%=session.getAttribute("name")%>">Edit Profile</a></li>
                         <li><a href="changePassword.jsp">Change Password</a></li>
                         <li><a href="./LogOutController">Sign Out</a></li>
                     </ul>
				   </li>
                 </ul>
                 
                  <div class="col-1-2"> <br>       
       			 <form id="newsletter">
                 <!--  <div class="success">Your subscribe request has been sent!</div> -->
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
  	<center><span style="color: red;font-size:20px;" > <b id="msg"></b></span></center>
  	<table style="width: 100%">
  		
  		<%! int i=1; %>	
  		<tr>
  		<c:forEach items="${list}" var="list1">  
  		
  		<% if(i%2==1) { %>
  			<td style="padding-right:30px;padding-bottom:15px;width:590px;height:50px;">  
  			<div class="row" style="background-color: white;">
	        <div class="col-1-2">
				<div class="wrap-col">
	          	<img src="images/img${list1.itemId}.png" width="209px" height="150px" alt="" class="img_inner">
			  	</div>
	        </div>
	        <div class="col-1-2">
				<div class="wrap-col">
				<form method='POST' action='./OrderItemsController?itemId=${list1.itemId}'  onsubmit="return validateForm(${list1.itemId})">
	          	 	<b><div style="font-size:20px;color:red; margin-bottom:13px;"><a href="#">${list1.itemName}</a></div></b>   
	          	  	<div style="font-size:large;margin-bottom:10px;"> Price : Rs:- ${list1.itemPrice}/-</div>
	          	  	<div style="font-size:large;margin-bottom:10px;"> Offer : ${list1.discount} %.  </div>   
	          	<div class="container"  style="font-size:large;margin-bottom:10px;">
					<div class="button-container"> Quantity :
					<button class="cart-qty-minus" type="button" value="-" id="form-minus">-</button>		
					<input type="text" name="qty" class="qty" maxlength="5" size="1"  value="0" class="input-text qty" style="font-size:16px"  id="${list1.itemId}"/>
					<button class="cart-qty-plus" type="button" value="+" id="form-plus">+<span></span></button>
				<!-- 	<span style="color: red;font-size:16px;" > <b id="msg"></b></span> -->
				</div></div>
    				<div style="text-align:center;margin-bottom:5px;" ><input type="submit" value="Online Order" alt="Submit"class="form-submit-button""/></div>
				</form>
			  	</div>
	        </div>
		</div></td>
		<%}else{%>
				
		<td style="padding-left:30px;padding-bottom:15px;width:590px;height:50px">  
		<div class="row" style="background-color: white;">
	        <div class="col-1-2">
				<div class="wrap-col">
	          		<img src="images/img${list1.itemId}.png" width="209px" height="150px" alt="" class="img_inner">
			  	</div>
	        </div>
	        <div class="col-1-2">
				<div class="wrap-col">
				<form method='POST' action='./OrderItemsController?itemId=${list1.itemId}'  onsubmit="return validateForm(${list1.itemId})">
	          	 	<b><div style="font-size:20px;color:red; margin-bottom:13px;"><a href="#">${list1.itemName}</a></div></b>   
	          	  	<div style="font-size:large;margin-bottom:10px;"> Price : Rs:- ${list1.itemPrice}/-</div>
	          	  	<div style="font-size:large;margin-bottom:10px;"> Offer : ${list1.discount} %.  </div>   
	          	  	<div class="container"  style="font-size:large;margin-bottom:10px;">
					<div class="button-container"> Quantity :
					<button class="cart-qty-minus" type="button" value="-" id="form-minus">-</button>		
					<input type="text" name="qty" class="qty" maxlength="5" size="1" value="0" class="input-text qty" style="font-size:16px" id="${list1.itemId}"/>
					<button class="cart-qty-plus" type="button" value="+" id="form-plus">+</button>
					<!-- <span style="color: red;font-size:16px;" > <b id="msg"></b></span> -->
				</div></div>
    				<div style="text-align:center;margin-bottom:5px;" ><input type="submit" value="Online Order" alt="Submit"class="form-submit-button"/></div>
				</form>
			  	</div>
	        </div>
		</div> </td> </tr> 		
	
	<%}
	i++; %>	
		</c:forEach>  		
	</tr>  
  	</table>	 
  
  
     
<div class="zerogrid">  
    <div class="col-full">    
	<div class="pagination">
	<nav>
    <ul class="sf-menu">
    <c:if test="${currentPage != 1}">
            <li><a href="MenuItemsController?currentPage=${currentPage-1}">Previous</a>
            </li>
        </c:if>
        <c:forEach begin="1" end="${noOfPages}" var="i">
           <c:choose>
                <c:when test="${currentPage eq i}">
                    <li><a class="active" >${i}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a href="MenuItemsController?currentPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
       <c:if test="${currentPage lt noOfPages}">
            <li><a href="MenuItemsController?currentPage=${currentPage+1}">Next</a>
            </li>
        </c:if>         
    </ul>
	</nav></div>
</div></div>
  
     
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
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>