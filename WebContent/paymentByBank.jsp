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
	<!--  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> --> 
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
	 <link rel="stylesheet" type="text/css" href="css/errorColor.css">
	 <script type="text/javascript">
	 	$(document).ready(function () {
 		 $('#myform').validate({	  
	  		errorClass:'errors',   
	  		rules: {
		  		"bankmode": {
			 		 required: true,
		  		},  		  		
  		  		"bank": {
			 		 required: true,
		  		},
		  		"pin": {
  			  		required: true,
  		  		},
  		  		"card": {
  			  		required: true,
  			  		number: true,
  			  		maxlength:16,
  			  		minlength:11
  		  		},
  		  	},
  		  	messages :{
  	 		"bankmode":{
  	 			required: "Payment mode must be select"
  	 		},
  	 		"bank": {
			 	required: "Bank name must be select",
		  	},
		  	"pin": {
  			  	required: "Pin/Password/CVV number must be required",
  		  	},
  		  	"card": {
  			  	required: "Card number must be required",
  			  	number: "Card number must be number only.",
  			  	maxlength:"Card number must contain at almost {0} characters",
  			  	minlength:"Card number must contain at least {0} characters"
  		  	},
  	 	}
	 });
	 });
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

<div class="content" >
  <div class="zerogrid">
  <h2>Payment System...</h2>
 
  	<div ><form method='post' id="myform" action="./PayOrderMailController?emailPay=<%=session.getAttribute("emailPay")%>">
  	<center>
  	<table style="background-color: white; width:75%;height:250px;font-size:20px;" border="1" >  		
  		<tr>
  			<td style="padding-left:30px;padding-top:20px">Select Payment mode :</td>
  			<td style="padding-top:20px"><select name="bankmode" id="modeid">
  				<option disabled="disabled" selected="selected" style="font-size:20px">Peyment Mode</option>
  				<option  style="font-size:20px">Debit Card</option>
  				<option  style="font-size:20px">Credit Card</option>
  				<option  style="font-size:20px">Net Banking</option>
  			</select></td>
  		</tr>
  		<tr>
  			<td style="padding-left:30px">Select Bank Name:</td>
  			<td><select  name="bank" id="bankid" >
  				<option disabled='disabled' selected='selected' style="font-size:20px">Select Bank</option>
  				<option style="font-size:20px">SBI Bank</option>
  				<option style="font-size:20px">HDFC Bank</option>
  				<option style="font-size:20px">KOTAK Bank</option>
  			</select></td>
  		</tr>
  		<tr>
  			<td style="padding-left:30px;">Pass your Card Number :</td>
  			<td><input type="text" name="card" style="font-size:18px"  placeholder="Type your card Nimber"/></td>
  		</tr>
  		<tr>
  			<td style="padding-left:30px">Pass your CVV/Password/Pin Number :</td>
  			<td><input type="password" name="pin" style="font-size:18px" placeholder="Type your pin/cvv/password"/></td>
  		</tr>
  		<tr>
  			<td style="padding-left:30px">Total Amount :</td>
  			<td>Rs:-<input type="text" name="totalAmount" readonly="readonly" style="font-size:20px" size="4" value="<%=session.getAttribute("totalAmount")%>"/> /-</td>
  		</tr>
  		<tr>
  			<td  colspan="2" style="text-align:center;">   			
	        	<input type="submit" value="Pay Amount" alt="Submit"class="form-submit-button" /></td>  			
  		</tr>
  	</table></center></form> </div>
     
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