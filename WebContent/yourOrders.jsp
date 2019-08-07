<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
	 	.ancher {
			background:#ba4a00;
			color: white;
			border-style: outset;
			border-color: #0066A2;
			height: 30px;
			width: 132px;
			font: bold 16px arial, sans-serif;
			text-shadow:green;
			}
	 </style>
     
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
                   <li><a href="./MenuItemsController">Menu</a></li>
                   <li><a href="offers.jsp">Offers</a></li>                   
                   <li><a href="contact.jsp">Contacts</a></li>
				   <li class="current"><a href="welcome.jsp">Hi!..  <%=session.getAttribute("name")%> </a>
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

<div class="content" >
  <div class="zerogrid">
  <h2>Your Orders ...</h2>
  
 
  <table style="width: 100%">
  		<tr>
  		<%! int i=1; %>
  		<c:forEach items="${list}" var="list1">  
			<% if(i%2==1) {%>
  			<td style="padding-right:30px;padding-bottom:15px;width:590px;height:80px;">  
  			<div class="row" style="background-color: white;">
	        <div class="col-1-2">
				<div class="wrap-col">
	          	<img src="images/img1.png" width="209px" height="170px" alt="" class="img_inner">
			  	</div>
	        </div>
	        <div class="col-1-2">
				<div class="wrap-col">
	          	 	<b><div style="font-size:20px;color:red; margin-bottom:8px;"><a href="#">${list1.itemId.itemName}</a></div></b>   
	          	  	<div style="font-size:large;margin-bottom:5px"> Price : Rs:- ${list1.itemId.itemPrice}/-</div>
	          	  	<div style="font-size:large;margin-bottom:5px;"> Offer : ${list1.itemId.discount} %.  </div>   
	          	  	<div style="font-size:large;margin-bottom:5px;"> Quantity : ${list1.quantity}.  </div> 	
	            	<div style="font-size:large;margin-bottom:5px;"> Delivery Charge : Rs:- ${list1.itemId.deliveryCharge} /-.  </div>
	          	  	<div style="font-size:large;margin-bottom:5px;"> Total Amount : Rs:- ${list1.itemId.totalAmount} /-.  </div> 
	          	  	<div style="font-size:large;margin-bottom:5px;"> Date of Orders : ${list1.orderDate}.  </div>
	          	  	<div style="font-size:large;margin-bottom:5px;"> Status of Orders :<b style="color:red"> ${list1.orderStatusName}</b>. </div> 	          	  	
    			</div>
	        </div>
	        <div style="font-size:large;padding-left:30px;margin-bottom:5px;"> If you want to Cancel Order : <a href="./CustCancelOrderController?orderId=${list1.orderId}"><input type="submit" value="Cancel Order" class="ancher"/></a> </div>   
		</div></td>
		<%} else { %>
			
		<td style="padding-left:30px;padding-bottom:15px;width:590px;height:80px">  
		<div class="row" style="background-color: white;">
	        <div class="col-1-2">
				<div class="wrap-col">
	          		<img src="images/img${list1.orderId}.png" width="209px" height="170px" alt="" class="img_inner">
			  	</div>
	        </div>
	        <div class="col-1-2">
				<div class="wrap-col">
	          	 	<b><div style="font-size:20px;color:red; margin-bottom:8px;"><a href="#">${list1.itemId.itemName}</a></div></b>   
	          	  	<div style="font-size:large;margin-bottom:5px;"> Price : Rs:- ${list1.itemId.itemPrice} /-</div>
	          	  	<div style="font-size:large;margin-bottom:5px;"> Offer : ${list1.itemId.discount} %.  </div>   
	          	  	<div style="font-size:large;margin-bottom:5px;"> Quantity : ${list1.quantity}.  </div> 
	          	  	<div style="font-size:large;margin-bottom:5px;"> Delivery Charge : Rs:- ${list1.itemId.deliveryCharge} /-.  </div>	
	          	  	<div style="font-size:large;margin-bottom:5px;"> Total Amount : Rs:- ${list1.itemId.totalAmount} /-  </div> 
	          	  	<div style="font-size:large;margin-bottom:5px;"> Date of Orders : ${list1.orderDate}.  </div>    	  
	          	  	<div style="font-size:large;margin-bottom:5px;"> Status of Orders :<b style="color:red"> ${list1.orderStatusName}</b>. </div>    	  
    			</div>
		</div> 
		 <div style="font-size:large;padding-left:30px;margin-bottom:5px;"> If you want to Cancel Order : <a href="./CustCancelOrderController?orderId=${list1.orderId}"><input type="submit" value="Cancel Order" class="ancher"/></a> </div>
		</div>
		</td> </tr> 
		<% }
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


</body>
</html>