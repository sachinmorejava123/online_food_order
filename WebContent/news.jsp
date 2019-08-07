<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
     <head>
     <title>News</title>
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
     
     </head>
     <body>
       <div class="main">
<!--==============================header=================================-->
 <header>  
  <div class="zerogrid">  
    <div class="col-full">    
	<div class="wrap-col">
    <a href="index.jsp"><img src="images/logo.png" width="190" height="155" alt="EXTERIOR"></a>
    
         <div class="menu_block">
           <nav>
            <ul class="sf-menu">
                   <li class="current"><a href="welcome.jsp">Home</a></li>
                   <li class="with_ul"><a href="#">Order items</a>
				   	<ul>
                         <li><a href="#">Non-Veg</a></li>
                         <li><a href="#">Veg</a></li>
                         <li><a href="#">Services</a></li>
                     </ul>
                  
				   </li>				   
                   <li><a href="./MenuItemsController">Menu</a></li>
                   <li><a href="offers.jsp">Offers</a></li>                   
                   <li><a href="contact.jsp">Contacts</a></li>
				   <li><a href="welcome.jsp">Hi!..  <%=session.getAttribute("name")%> </a>
				   		<ul>
				   		 <li><a href="#">Your Orders</a></li>
                         <li><a href="./EditController?id=<%=session.getAttribute("name")%>">Edit Profile</a></li>
                         <li><a href="changePasswordAdmin.jsp">Change Password</a></li>
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
  	<div class="row">
    <div class="col-3-6">
		<div class="wrap-col">
      <h2 class="head2">Latest News</h2>
      <div class="news">
        <img src="images/page5_img1.jpg" alt="" class="img_inner fleft">
        <div class="extra_wrapper">
          <div class="col1">Aenean nonummy hendrerit mau rellus porta. Fusce suscipit varius m sociis natoque penaibet mapaturent. </div>
          <p>Montes nasetur ridiculumula dui. Fusce feugiatlesuada o krjg fdio. Morbi nusem. GIoadscs lkierhdc v hfrjgDuis ultricies pharetra magna. Donec accusan mal esuada orcec sit amet eros.   </p>
          <p>Lorem ipsum dolor sit amet consectetuer adipiscing elit. Mauris fermentum dictum magna. Sed oreetliquam tellus dolor elementum vel cursus eleife. agna. Donec accumsan malesuada orcec sit amet </p>
          <a href="#" class="btn">More</a>
        </div>
      </div>
      <div class="news mb0">
        <img src="images/page5_img2.jpg" alt="" class="img_inner fleft">
        <div class="extra_wrapper">
          <div class="col1">Nuinean nonummy hendrerit mau rellus porta. Fusce varius m sociis natoque penaibet magni partur.</div>
          <p>Ent montes nasetur ridiculumula dui. KHgsce feugiat malesuada o krjg fdio. Joorbi nusem. GIoadscs lkierdc vhfrujgDuis ultricies pharetra magna. Donec accumsan masuada orcec sit amet eros.   </p>
          <p>Hioasrem ipsum dolor sit amet consectetuer adiscing elit. Mauris fermentum dictum magna. Ed oreetliquam tellus dolor dapibus eget elementum vel cursus eleife. agna. Donec accumsan malesuada orcec sit amrbi. </p>
          <a href="#" class="btn">More</a>
        </div>
      </div>
	  </div>
    </div>
	<div class="col-1-6"><div class="wrap-col"><!--empty--></div></div>
    <div class="col-2-6">
		<div class="wrap-col">
      <h2 class="head2">Categories</h2>
      <ul class="list l1">
        <li><a href="#">Vivamus vulputate est</a></li>
        <li><a href="#">Aniivamus vulputate </a></li>
        <li><a href="#">Nam blandit metus</a></li>
        <li><a href="#">Mltam blandit metuju</a></li>
        <li><a href="#">Pellentesque vitae sem odio</a></li>
        <li><a href="#">Pellen miofju </a></li>
        <li><a href="#">Lorem ipsum </a></li>
        <li><a href="#">Nam at neque dictum</a></li>
        <li><a href="#">Mloam at neque </a></li>
      </ul>
      <h2 class="head2">Archive</h2>
      <ul class="list">
        <li><a href="#">September 2012</a></li>
        <li><a href="#">August 2012</a></li>
        <li><a href="#">July 2012</a></li>
        <li><a href="#">June 2012</a></li>
        <li><a href="#">May 2012</a></li>
        <li><a href="#">April 2012</a></li>
        <li><a href="#">March 2012</a></li>
        <li><a href="#">February 2012</a></li>
        <li><a href="#">January 2012</a></li>
      </ul>
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
                   <li><a href="menu.jsp">Menu</a></li>
                   <li><a href="portfolio.jsp">Portfolio</a></li>
                   <li class="current"><a href="news.jsp">News </a></li>
                   <li><a href="conttact.jsp">Contacts</a></li>
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
     Odered&Delivered © 2013  &nbsp;&nbsp; |&nbsp;&nbsp;   <a href="#">Privacy Policy</a>    &nbsp;&nbsp;|&nbsp;&nbsp;  Designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster</a> - <a href="https://www.zerotheme.com/" title="free website templates">ZEROTHEME</a>
	 	</div>
    </div>
  </div>
</footer>
</body>
</html>