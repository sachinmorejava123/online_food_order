<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
     <head>
     <title>Contacts</title>
     
     
    <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="js/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="js/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
 
     
     
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
	 
	 <script src="js/signup.js"></script>
	 <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
	
	 <link rel="stylesheet" type="text/css" href="css/errorColor.css">
     
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
                   <li ><a href="about.jsp">About Us</a> </li>
                   <li><a href="./MenuItemsController">Menu</a></li>
                   <li><a href="offersHome.jsp">Offers</a></li>                   
                   <li><a href="contactHome.jsp">Contacts</a></li>
				   <li class="current"><a href="signin.jsp">SignIn </a></li>
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

  
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form id="myform" action="ForgetUpdatePasswordController">
					<span class="login100-form-title p-b-49">
						Forget Change Password
					</span>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">New Password</span>
						<input class="input100" type="password" name="password" placeholder="Type your password">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="Re-Password is required">
						<span class="label-input100">New Re-Password</span>
						<input class="input100" type="password" name="re_pass" placeholder="Type your re-password">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="wrap-input100 validate-input" data-validate="OTP is required">
						<span class="label-input100">OTP (One Time Password)</span>
						<input class="input100" type="number" name="otp" placeholder="Type your OTP">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					<br>
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Change Password
							</button>
						</div>
					</div>

				<!-- 	<div class="txt1 text-center p-t-54 p-b-20">
						<span>
							Or Sign Up Using
						</span>
					</div>

					<div class="flex-c-m">
						<a href="https://www.facebook.com/?stype=lo&jlou=AfdrlcFy5LWV0zU3tsHBbnd6IbfQxSos2Zn7SzkNzXTVCWVnL4I0eEv_0rzsD-AfP1QME6px7FQuX075a7a7eHAKt7HHbkwbD1pNVxeIUp6PQg&smuh=46588&lh=Ac86nR-Ubqlu3xMd" class="login100-social-item bg1">
							<i class="fa fa-facebook"></i>
						</a>

						<a href="https://twitter.com/login?lang=en" class="login100-social-item bg2">
							<i class="fa fa-twitter"></i>
						</a>

						<a href="https://accounts.google.com/ServiceLogin/signinchooser?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin" class="login100-social-item bg3">
							<i class="fa fa-google"></i>
						</a>
					</div><br>

					<div style="text-align:center">
						<span class="txt1 p-b-17">
							Or Sign Up Using
						</span><br>

						<a href="signup.jsp" class="txt2">
							Sign Up
						</a>
					</div> -->
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
	
	<div class="content">
  		<div class="zerogrid">
	<div class="col-1-5"><div class="wrap-col"><!--empty--></div></div>	
   
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
     Ordered@Delivered © 2018  &nbsp;&nbsp; |&nbsp;&nbsp;   <a href="#">Privacy Policy</a>    &nbsp;&nbsp;|&nbsp;&nbsp;  Designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster</a> - <a href="https://www.zerotheme.com/" title="free website templates">ZEROTHEME</a>
	 	</div>
    </div>
  </div>
</footer>



</body>
</html>