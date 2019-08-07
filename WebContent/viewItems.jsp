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
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
	 
	 <script type="text/javascript">
	 $(document).ready(function () {
		    $("form").submit(function () {

		      var clikedForm = $(this);// Select Form
		       if (clikedForm.find("[name='itemName']").val() == '') {
		       	document.getElementById("msg").innerHTML = 'Please enter item name'; 
		        return false;
		      }
		      var price=clikedForm.find("[name='price']").val();
		      if (price == '' ||!/^[0-9]+$/.test(price)) {
		        document.getElementById("msg").innerHTML = 'Price must be number only'; 
		        return false;
		      }
		      var deliveryCharge=clikedForm.find("[name='deliveryCharge']").val();
		      if (deliveryCharge== '' || !/^[0-9]+$/.test(deliveryCharge)) {
		        document.getElementById("msg").innerHTML = 'Please enter delivery Charge';
		        return false;
		      }
		      var discount=clikedForm.find("[name='discount']").val();
		      if (discount== '' || !/^-?\d*[.,]?\d{0,2}$/.test(discount)) {
		         document.getElementById("msg").innerHTML = 'Please enter discount amt';
		        return false;
		      }
		      if (clikedForm.find("[name='itemStatus']").val() == '') {
		        document.getElementById("msg").innerHTML = 'Enter valid Status';
		        return false;
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
    <a href="admin.jsp"><img src="images/logo.png" width="180" height="100" alt="EXTERIOR"></a>
    
         <div class="menu_block">
           <nav>
            <ul class="sf-menu">
                   <li><a href="admin.jsp">Home</a></li>
                   <li class="with_ul"><a href="addItems.jsp">Add Items</a>
				   	
				   </li>
                   <li class="current"><a href="./MenuItemsController">View Items</a></li>                   
                   <li><a href="./ViewOrdersController">View Orders</a>
                   </li>
				   <li><a href="admin.jsp">Hi!..  <%=session.getAttribute("name")%> </a>
				   		<ul>
                         <li><a href="./EditController?id=<%=session.getAttribute("name")%>">Edit Profile</a></li>
                         <li><a href="changePasswordAdmin.jsp">Change Password</a></li>
                         <li><a href="./LogOutController">Sign Out</a></li>
                     </ul>
				   </li>
				  	<li style="padding-left:5px"> <a href="./NewAddedOrdersController"> <i class="fa fa-bell" style="font-size:22px;color:blue;"><sup style="font-size:18px; line-height: 0; vertical-align: 3px"><span class="num" id="count"/></sup></i></a></li>
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
  	<center><span style="color: red;font-size:20px;" > <b id="msg"></b></span> </center>	          	  	
  	<table style="width: 100%">
  		<tr>
  		<c:forEach items="${list}" var="list1">  
  			 
  		<c:if test="${(list1.itemId mod 2) eq 1}"> 
  			<td style="padding-right:30px;padding-bottom:15px;width:590px;height:50px;">  
  			<div class="row" style="background-color: white;">
	        <div class="col-1-2">
				<div class="wrap-col">
	          	<img src="images/img${list1.itemId}.png" width="209px" alt="" class="img_inner">
			  	</div>
	        </div>
	        <div class="col-1-2">
				<div class="wrap-col">
				<form method='post' action='EditItemsController?itemId=${list1.itemId}' >
	          	 	<b><div style="font-size:20px;color:red; margin-bottom:12px;">Food Name : <input type="text" value="${list1.itemName}" name="itemName" size="10" ></div></b>  
	          	 	<div style="font-size:large;margin-bottom:8px;"> Price    : Rs:-<input type="text" value="${list1.itemPrice}" name="price" size="4"> /-</div>
	          	  	<div style="font-size:large;margin-bottom:8px;"> Discount : <input type="text" value="${list1.discount}" name="discount" size="4"> %.  </div>   
	          	  	<div style="font-size:large;margin-bottom:8px;"> Delivery Charge : Rs:-<input type="text" value="${list1.deliveryCharge}" name="deliveryCharge" size="3"> /-</div>
	          	  	<div style="font-size:large;margin-bottom:8px;"> Item Status : <input type="text" value="${list1.itemStatus}" name="itemStatus" size="13"></div>
	          	  	<div style="text-align:center;margin-bottom:5px;" ><input type="submit" value="Edit Food" alt="Submit"class="form-submit-button" /></div>
				</form>
			  	</div>
	        </div>
		</div></td>
		
		</c:if>
		
		<c:if test="${(list1.itemId mod 2) eq 0}"> 
		
		<td style="padding-left:30px;padding-bottom:15px;width:590px;height:50px">  
		<div class="row" style="background-color: white;">
	        <div class="col-1-2">
				<div class="wrap-col">
	          	<img src="images/img${list1.itemId}.png" width="209px" alt="" class="img_inner">
			  	</div>
	        </div>
	        <div class="col-1-2">
				<div class="wrap-col">
				<form method='post' action='EditItemsController?itemId=${list1.itemId}' >
	          	 	<b><div style="font-size:20px;color:red; margin-bottom:12px;">Food Name : <input type="text" value="${list1.itemName}" name="itemName" size="10"></div></b>   
	          	  	<span style="color: red;font-size:16px;" > <b id="msg"></b></span> 
	          	  	<div style="font-size:large;margin-bottom:8px;"> Price    : Rs:-<input type="text" value="${list1.itemPrice}" name="price" size="4"> /-</div>
	          	  	<div style="font-size:large;margin-bottom:8px;"> Discount : <input type="text" value="${list1.discount}" name="discount" size="4"> %.  </div>   
	          	  	<div style="font-size:large;margin-bottom:8px;"> Delivery Charge : Rs:-<input type="text" value="${list1.deliveryCharge}" name="deliveryCharge" size="3"> /-</div>
	          	  	<div style="font-size:large;margin-bottom:8px;"> Item Status : <input type="text" value="${list1.itemStatus}" name="itemStatus" size="13"></div>
	          	  	<div style="text-align:center;margin-bottom:5px;" ><input type="submit" value="Edit Food" alt="Submit"class="form-submit-button" /></div>
				</form>
			  	</div>
	        </div>
		</div> </td>  </tr>		
	</c:if>
					
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