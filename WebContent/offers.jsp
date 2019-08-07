<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
     <head>
     <title>Offers</title>
     <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
     <link rel="icon" href="images/favicon.ico">
     <link rel="shortcut icon" href="images/favicon.ico" />
     <link rel="stylesheet" href="css/style.css">
	  <link rel="stylesheet" href="css/zerogrid.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen"> 
     <link rel="stylesheet" href="css/prettyPhoto.css">
     <script src="js/jquery.js"></script>
     <script src="js/jquery-migrate-1.1.1.js"></script>
     <script src="js/superfish.js"></script>
     <script src="js/jquery.easing.1.3.js"></script>
     <script src="js/sForm.js"></script>
     <script src="js/jquery.prettyPhoto.js"></script>
	 <script src="js/css3-mediaqueries.js"></script>
     <script>
     
      
      
        $(document).ready(function(){
    $("a[data-gal^='prettyPhoto']").prettyPhoto({theme:'facebook'});
    
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
                   <li class="with_ul"><a href="#">Order items</a>
				   	<ul>
                         <li><a href="#">Non-Veg</a></li>
                         <li><a href="#">Veg</a></li>
                         <li><a href="#">Services</a></li>
                     </ul>
                  
				   </li>				   
                   <li><a href="./MenuItemsController">Menu</a></li>
                   <li class="current"><a href="offers.jsp">Offers</a></li>                   
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
    <div class="col-full">
      <h2>Offers</h2>
    </div>
    <div class="clear"></div>
	
	<div class="row">
    <div class="portfolio">
      <div class="col-1-2">
	  	<div class="wrap-col">
	  	<a href="images/big3.jpg" data-gal="prettyPhoto[1]"><span><img src="images/page4_img1.jpg" alt=""></span></a>
		</div>
	</div>
      <div class="col-1-2">
	  	<div class="wrap-col">
	  	<a href="images/big2.jpg" data-gal="prettyPhoto[1]"><span><img src="images/page4_img2.jpg" alt=""></span></a>
		</div>
	</div>
      <div class="col-1-2">
	  	<div class="wrap-col">
	  	<a href="images/big4.jpg" data-gal="prettyPhoto[1]"><span><img src="images/page4_img3.jpg" alt=""></span></a>
		</div>
	  </div>
      <div class="col-1-2">
	  <div class="wrap-col">
	  	<a href="images/big1.jpg" data-gal="prettyPhoto[1]"><span><img src="images/page4_img4.jpg" alt=""></span></a>
		</div>
	</div>
    </div>
    </div>
   
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
                   <li><a href="news.jsp">Menu</a></li>
                   <li class="current"><a href="portfolio.jsp">Portfolio</a></li>
                   <li><a href="news.jsp">News </a></li>
                   <li><a href="contact1.jsp">Contacts</a></li>
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
     Food@Order © 2018  &nbsp;&nbsp; |&nbsp;&nbsp;   <a href="#">Privacy Policy</a>    &nbsp;&nbsp;|&nbsp;&nbsp;  Designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster</a> - <a href="https://www.zerotheme.com/" title="free website templates">ZEROTHEME</a>
	 	</div>
    </div>
  </div>
</footer>
</body>
</html>