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
	 
	 <script src="js/signup.js"></script>
	 <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
	  <link rel="stylesheet" type="text/css" href="css/errorColor.css">
	 
	 <style type="text/css">
	 	.form-submit-button {
			background:green;
			color: white;
			border-style: outset;
			border-color: #0066A2;
			height: 31px;
			width: 120px;
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

<div class="content" >
  <div class="zerogrid">
  <h2>Payment System...</h2>
  <center>
  	<h5 style="padding-right:50px;">Your Order Items</h4>
  	<div ><form method='post' id="myform" action="./PaymentController?itemId=<%=session.getAttribute("itemId")%>">
  	<table style="background-color: white;font-size:20px;width:100%;height:500px;border:2px;border-color:red" >
  		
  		<div><tr>
  			<div><th width="100%" colspan="3" style="font-size:30px;color:red;padding-top:20px";text-align:center;"><b><u>${dto.itemId.itemName}</u></b></th></div>
  		</tr></div>
		
		<div><tr>
  			<div><td width="40%" style="padding-left:50px;margin-bottom:15px;margin-top:30px;">Name : <b><input style="font-size:16px" type="text" name="fullname" value="${dto.regId.custFullName}"></b></td></div>
  			<div style="margin-bottom:11px;"></div><td width="60%" style="padding-left:50px; margin-left:30px">Email : <input style="font-size:16px" type="email" name="email" value="${dto.regId.email}"> </td></div>
		</tr></div>
		
		<div><tr>
  			<div style="font-size:large;margin-bottom:11px;"><td width="40%" rowspan="4" style="padding-left:50px; margin-left:30px"> Order Place :  </td></div>
  			<tr>	
  				<td width="30%" style="padding-left:50px; margin-left:30px">Address : <textarea rows="1" cols="15" name="address" id="address" style="font-size:16px">${dto.regId.addressId.address}</textarea></td>
  				<td width="30%" >Country : <select name="country" id="conid" style="margin-right: 150px">
                                        <option style="font-size:16px">${dto.regId.addressId.cityId.stateId.countryId.countryName}</option>   
                                        </select></td>
  			</tr>
  			<tr>	
  				<td width="30%" style="padding-left:50px; margin-left:30px">State : <select name="state" id="sid">
                                        <option value="" style="font-size:16px">${dto.regId.addressId.cityId.stateId.stateName}</option>   
                                        </select></td>
  				<td width="30%" >City : <select name="city" id="cityid">
                                        <option value="" style="font-size:18px">${dto.regId.addressId.cityId.cityName}</option>   
                                        </select></td>
  			</tr>
  			<tr>	
  				<td width="30%" style="padding-left:50px;">Pincode : <input type="text" size="8" name="pincode" value="${dto.regId.addressId.pincode}" style="font-size:16px"></td>  				
  				<td width="30%">Mobile Number : <input type="text" size="10" name="mobile" value="${dto.regId.mobile}" style="font-size:16px"></td>  				
  			</tr>
		</tr></div>
  		
  		<div><tr>
  			<div style="font-size:large;margin-bottom:11px;"><td width="40%" style="padding-left:50px; margin-left:30px"> Price  :</td>
  			<td width="60%" style="padding-left:50px; margin-left:30px">Rs:-${dto.itemId.itemPrice} /-</td>
		</tr></div>
		
		<div><tr>
  			<div style="font-size:large;margin-bottom:11px;"> <td width="40%" style="padding-left:50px; margin-left:30px">Discount :</td></div>
  			<div><td width="60%" style="padding-left:50px; margin-left:30px">${dto.itemId.discount} %</td></div>
		</tr></div>		
			
		<div><tr>
  			<div style="font-size:large;margin-bottom:11px;"><td width="40%" style="padding-left:50px; margin-left:30px">Delivery Charge :</td></div>
  			<div><td width="60%" style="padding-left:50px; margin-left:30px">Rs:-${dto.itemId.deliveryCharge} /-</td></div>
		</tr></div>
		
		<div><tr>
  			<div style="font-size:large;margin-bottom:11px;"><td width="40%" style="padding-left:50px; margin-left:30px">No. of Quantity :</td></div>
  			<div><td width="60%" style="padding-left:50px; margin-left:30px"><input name="quantity" value="${dto.quantity}" readonly="readonly" size="2" style="font-size:15px;">.</td></div>
		</tr></div>
		
		<div><tr>
  			<div style="font-size:large;margin-bottom:11px;"><td width="40%" style="padding-left:50px; margin-left:30px">Total Amount :</td></div>
  			<div><td width="60%" style="padding-left:50px; margin-left:30px">Rs:- <input type="text" name="totalAmount" value="${dto.itemId.totalAmount}" readonly="readonly" size="3" style="font-size:17px;"> /-</td></div>
		</tr></div>  		
  		
  		<div><tr>
  			<div>
  			<td colspan="3" style="text-align:center;">   			
	        	<input type="submit" value="Pay Amount" alt="Submit"class="form-submit-button" />	
			</td></div>	
  		
  		</tr></div>
  		
  		
  	</table>	</form> </div>
  	</center>
     
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
	<!-- <script src="vendor/jquery/jquery-3.2.1.min.js"></script> -->
<!--===============================================================================================-->
	<!-- <script src="vendor/animsition/js/animsition.min.js"></script> -->
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