<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
     <head>
     <title>Sign Up</title>
          
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
    <a href="welcome.jsp"><img src="images/logo.png" width="180" height="100" alt="EXTERIOR"></a>
    
         <div class="menu_block">
           <nav>
            <ul class="sf-menu">
                   <li><a href="index.jsp">Home</a></li>
                   <li><a href="about.jsp">About Us</a> </li>
                   <li><a href="./MenuItemsController">Menu</a></li>
                   <li><a href="offersHome.jsp">Offers</a></li>                   
                   <li><a href="contactHome.jsp">Contacts</a></li>
				   <li><a href="signin.jsp">SignIn </a></li>
				   <li class="current"><a href="signup.jsp">Sign Up</a></li>
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
			
				<% String ss=(String)request.getAttribute("error") ;
					if(ss==null)
						out.print(" ");
					else
						out.print("<h3 style='color:red;text-align:center;'>Username must be unique.</h3>");	
				%>
				<form id="myform" action="RegisterController">
					<span class="login100-form-title p-b-49">
						Sign Up
					</span>

					<div class="wrap-input100 validate-input m-b-23" id="fname">
						<span class="label-input100">Full Name</span>
						<input class="input100" type="text" name="fullname" placeholder="Type your full name">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23" id="dob">
						<span class="label-input100">Date of Birth</span>
						<input class="input100" type="date" name="dob" placeholder="Type your date of birth">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-23" id="fname">
						<span class="label-input100">Gender</span>
							<select class="input100" name="gender">
                                            <option disabled="disabled" selected="selected">Gender</option>
                                            <option>Male</option>
                                            <option>Female</option>
                                            <option>Other</option>
                                        </select>
                                        <div class="select-dropdown"></div>
							<span class="focus-input100" data-symbol="&#xf206;"></span>						
					</div>
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Mobile number is reauired">
						<span class="label-input100">Mobile Number</span>
						<input class="input100" name="mobile" placeholder="Type your mobile number">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Email is reauired">
						<span class="label-input100">Email</span>
						<input class="input100" type="email" name="email" placeholder="Valid email is required: ex@abc.xyz">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Country is reauired">
						<span class="label-input100">Country</span>
							<select class="input100" name="country" id="conid">
                                            
                                        </select>
                                        <div class="select-dropdown"></div>
							<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-23" data-validate = "State is reauired">
						<span class="label-input100">State</span>
							<select class="input100" name="state" id="sid">
                                            
                                        </select>
                                        <div class="select-dropdown"></div>
							<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-23" data-validate = "City is reauired">
						<span class="label-input100">City</span>
							<select class="input100" name="city" id="cityid">
							
                                        </select>
                                        <div class="select-dropdown"></div>
							<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Address is reauired">
						<span class="label-input100">Address</span>
						<textarea class="input100" name="address" id="address" placeholder="Type your address"></textarea>
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Pincode is reauired">
						<span class="label-input100">Pincode</span>
						<input class="input100" name="pincode" placeholder="Type Address pincode">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">Username</span>
						<input class="input100" type="text" name="username" placeholder="Type your username">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password</span>
						<input class="input100" type="password" name="password" id="pass" placeholder="Type your password">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Re-Password is required">
						<span class="label-input100">Re-Password</span>
						<input class="input100" type="password" name="re_pass" placeholder="Type your re-password">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<!--<div class="text-right p-t-8 p-b-31">I agree with
						<a href="#">
							Terms & condition.
						</a>
					</div>-->

					<div class="text-right p-t-8 p-b-31">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								<span class="txt1">
									I agree to the
									<a href="#" class="txt2 hov1">
										Terms of User
									</a>
								</span>
							</label>
						</div>

						
					</div>

					
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">
								Sign Up
							</button>
						</div><br>
					
					<div style="text-align:center">
						<h4><a href="signin.jsp" class="txt2">
							Sign In
						</a></h4>
					</div>
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

<!-- 
	
===============================================================================================
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
===============================================================================================
	<script src="vendor/animsition/js/animsition.min.js"></script>
===============================================================================================
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
===============================================================================================
	<script src="vendor/select2/select2.min.js"></script>-->
<!-- =============================================================================================== -->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!-- =============================================================================================== -->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!-- =============================================================================================== -->
	<script src="js/main.js"></script>
 

</body>
</html>