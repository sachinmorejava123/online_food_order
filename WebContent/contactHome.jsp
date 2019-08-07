<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
     <head>
     <title>Contacts</title>
     <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
     <link rel="icon" href="images/favicon.ico">
     <link rel="shortcut icon" href="images/favicon.ico" />
     <link rel="stylesheet" href="css/style.css">
	 <link rel="stylesheet" href="css/zerogrid.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen"> 
     <link rel="stylesheet" href="css/form.css">
     <script src="js/jquery.js"></script>
     <script src="js/jquery-migrate-1.1.1.js"></script>
     <script src="js/superfish.js"></script>
     <script src="js/jquery.easing.1.3.js"></script>
     <script src="js/sForm.js"></script>
     <script src="js/Forms.js"></script>
	 <script src="js/css3-mediaqueries.js"></script>
     
     <script>
            function resetForm(){
                  document.getElementById("form").reset();
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
    <a href="index.jsp"><img src="images/logo.png" width="180" height="100" alt="EXTERIOR"></a>
    
         <div class="menu_block">
           <nav>
            <ul class="sf-menu">
                   <li><a href="index.jsp">Home</a></li>
                   <li><a href="about.jsp">About Us</a> </li>
                   <li><a href="./MenuItemsController">Menu</a></li>
                   <li><a href="offersHome.jsp">Offers</a></li>                   
                   <li class="current"><a href="contactHome.jsp">Contacts</a></li>
				   <li class="with_ul"><a href="signin.jsp">SignIn </a></li>
				   <li><a href="signup.jsp">Sign Up</a></li>
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
    <div class="col-2-5">
		<div class="wrap-col">
      <h2>Find Us</h2>
            <div class="map">
            <figure class="img_inner">
                          <iframe src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Brooklyn,+New+York,+NY,+United+States&amp;aq=0&amp;sll=37.0625,-95.677068&amp;sspn=61.282355,146.513672&amp;ie=UTF8&amp;hq=&amp;hnear=Brooklyn,+Kings,+New+York&amp;ll=40.649974,-73.950005&amp;spn=0.01628,0.025663&amp;z=14&amp;iwloc=A&amp;output=embed"></iframe>
               </figure>
              <address>
                            <dl>
                                <dt><p>The Company Name Nacre Software Services.<br>
                                    500016 Ameerpet,<br>
                                    Hyderabad, D04 89GR.</p>
                                </dt>
                                <dd><span>Freephone:</span>+1 800 559 6580</dd>
                                <dd><span>Telephone:</span>+1 800 603 6035</dd>
                                <dd><span>FAX:</span>+1 800 889 9898</dd>
                            </dl>
                         </address>
 
          </div>
	</div>
    </div>
	<div class="col-1-5"><div class="wrap-col"><!--empty--></div></div>
    <div class="col-2-5">
	<div class="wrap-col">
      <h2>Contact Us</h2>
      <form id="form">
      <div class="success_wrapper">
      <div class="success">Contact form submitted!<br>
      <strong>We will be in touch soon.</strong> </div></div>
      <fieldset>
      <label class="name">
      <input type="text" name="name" placeholder="Type your name:">
      <br class="clear">
      <span class="error error-empty">*This is not a valid name.</span><span class="empty error-empty">*This field is required.</span> </label>
      <label class="email">
      <input type="text" name="email" placeholder="Type your e-mail:">
      <br class="clear">
      <span class="error error-empty">*This is not a valid email address.</span><span class="empty error-empty">*This field is required.</span> </label>
      <label class="phone">
      <input type="tel" name="phone" placeholder="Type your Phone:">
      <br class="clear">
      <span class="error error-empty">*This is not a valid phone number.</span><span class="empty error-empty">*This field is required.</span> </label>
      <label class="message">
      <textarea placeholder="Type your Message" name="message"></textarea>
      <br class="clear">
      <span class="error">*The message is too short.</span> <span class="empty">*This field is required.</span> </label>
      <div class="clear"></div>
      <div class="btns"><a data-type="reset" class="btn" onclick="resetForm()">clear</a><a href="#"  data-type="submit" class="btn">send</a>
      <div class="clear"></div>
      </div></fieldset></form>
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
                   <li><a href="porfolio.jsp">Portfolio</a></li>
                   <li><a href="news.jsp">News </a></li>
                   <li class="current"><a href="contact.jsp">Contacts</a></li>
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
     Odered&Delivered © 2018 &nbsp;&nbsp; |&nbsp;&nbsp;   <a href="#">Privacy Policy</a>    &nbsp;&nbsp;|&nbsp;&nbsp;  Designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster</a> - <a href="https://www.zerotheme.com/" title="free website templates">ZEROTHEME</a>
	 	</div>
    </div>
  </div>
</footer>
</body>
</html>