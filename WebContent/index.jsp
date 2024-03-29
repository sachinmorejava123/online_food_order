<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
     <head>
     <title>Home</title>
     <meta charset="utf-8">
	 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
     <link rel="icon" href="images/favicon.ico">
     <link rel="shortcut icon" href="images/favicon.ico" />
     <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="css/slider.css">
	 <link rel="stylesheet" href="css/zerogrid.css" type="text/css" media="screen">
	 <link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen"> 
     <script src="js/jquery.js"></script>
     <script src="js/jquery-migrate-1.1.1.js"></script>
     <script src="js/superfish.js"></script>
     <script src="js/jquery.easing.1.3.js"></script>
     <script src="js/sForm.js"></script>
     <script src="js/jquery.carouFredSel-6.1.0-packed.js"></script>
     <script src="js/tms-0.4.1.js"></script>
	 <script src="js/css3-mediaqueries.js"></script>
     <script>
      $(window).load(function(){
      $('.slider')._TMS({
              show:0,
              pauseOnHover:false,
              prevBu:'.prev',
              nextBu:'.next',
              playBu:false,
              duration:800,
              preset:'fade', 
              pagination:true,//'.pagination',true,'<ul></ul>'
              pagNums:false,
              slideshow:8000,
              numStatus:false,
              banners:false,
          waitBannerAnimation:false,
        progressBar:false
      })  
      });
      
     $(window).load (
    function(){$('.carousel1').carouFredSel({auto: false,prev: '.prev',next: '.next', width: 960, items: {
      visible : {min: 1,
       max: 4
},
height: 'auto',
 width: 240,

    }, responsive: false, 
    
    scroll: 1, 
    
    mousewheel: false,
    
    swipe: {onMouse: false, onTouch: false}});
    
    
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
    <a href="index.jsp"><img src="images/logo.png" width="180" height="100" alt="EXTERIOR"></a>
    
         <div class="menu_block">
           <nav>
            <ul class="sf-menu">
                   <li class="current"><a href="index.jsp">Home</a></li>
                   <li ><a href="about.jsp">About Us</a> </li>
                   <li><a href="./MenuItemsController">Menu</a></li>
                   <li><a href="offersHome.jsp">Offers</a></li>                   
                   <li><a href="contactHome.jsp">Contacts</a></li>
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


 <div class="slider-relative">
    <div class="slider-block">
      <div class="slider">
        <ul class="items">
          <li><img src="images/slide.jpg" alt=""></li>
          <li><img src="images/slide1.jpg" alt=""></li>
          <li class="mb0"><img src="images/slide2.jpg" alt=""></li>
        </ul>
      </div>
    </div>
 </div>
<!--=======content================================-->

<div class="content page1">
  <div class="zerogrid">
      <div class="row">
      <div class="col-3-5">
	  	<div class="wrap-col">
	        <h2>Welcome</h2>
	        <div class="page1_block col1">
				<div class="col-1-3"><img src="images/welcome_img.png" alt=""></div>
				<div class="col-2-3">
		          <div class="extra_wrapper">
		            <p><span class="col2"><a href="http://blog.templatemonster.com/free-website-templates/" rel="nofollow">Click here</a></span> for more info about this free website template created by TemplateMonster.com </p>
		            Aenean nonummy hendrerit mau rellus porta. Fusce suscipit varius m sociis natoque penaibet magni parturient montes nasetur ridiculumula dui. <br>
		            <a href="#" class="btn">more</a>
		          </div>
			  </div>
	          <div class="clear"></div>
	        </div>
		</div>
      </div>
      <div class="col-2-5">
	  	<div class="wrap-col">
	        <h2>Features</h2>
	        <ul class="list">
	          <li><a href="#">Unlimited consultations and/or planning</a></li>
	          <li><a href="#">Expert advice on traditions, customs, aetiquette</a></li>
	          <li><a href="#">Determine and stay within budget</a></li>
	          <li><a href="#">Choosing the right Wedding Venue</a></li>
	          <li><a href="#">Provide preferred vendor's list</a></li>
	          <li><a href="#">Assist with wedding scheme and design</a></li>
	        </ul>
		</div>
      </div>
      </div>
      <div class="col-full">
        <div class="hor_separator"></div>
      </div>
	  <div class="row">
      <div class="col-full">
	  	<div class="wrap-col">
        <div class="car_wrap">
        <h2>Best Choice</h2>
        <a href="#" class="prev"></a><a href="#" class="next"></a>
        <ul class="carousel1">
          <li><div><img src="images/page1_img1.jpg" alt="">
          <div class="col1 upp"> <a href="#">kim Lorem ipsum doamet consectet</a></div>
          <span> Dorem ipsum dolor amet consectetur</span>
          <div class="price">45$</div></div>
          </li>
          <li><div><img src="images/page1_img2.jpg" alt="">
          <div class="col1 upp"> <a href="#">Lorem ipsum doamet consectet</a></div>
          <span> Dorem ipsum dolor amet consectetur</span>
          <div class="price">45$</div></div>
          </li>
          <li><div><img src="images/page1_img3.jpg" alt="">
          <div class="col1 upp"> <a href="#">Lorem ipsum doamet consectet</a></div>
          <span> Dorem ipsum dolor amet consectetur</span>
          <div class="price">45$</div></div>
          </li>
          <li><div><img src="images/page1_img4.jpg" alt="">
          <div class="col1 upp"> <a href="#">Lorem ipsum doamet consectet</a></div>
          <span> Dorem ipsum dolor amet consectetur</span>
          <div class="price">45$</div></div>
          </li>
          <li><div><img src="images/page1_img3.jpg" alt="">
          <div class="col1 upp"> <a href="#">Lorem ipsum doamet consectet kim</a></div>
          <span> Dorem ipsum dolor amet consectetur</span>
          <div class="price">45$</div></div>
          </li>
        </ul>
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
                   <li class="current"><a href="index.jsp">Home</a></li>
                   <li ><a href="about.jsp">About Us</a></li>
                   <li><a href="menu.jsp">Menu</a></li>
                   <li><a href="portfolio.jsp">Offers</a></li>
                   <li><a href="news.jsp">News </a></li>
                   <li><a href="contact.jsp">Contacts</a></li>
                 </ul></nav>
      </div>
      <div class="col-1-2">
        <h3>Update your email</h3>
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
     Odered&Delivered � 2018  &nbsp;&nbsp; |&nbsp;&nbsp;   <a href="#">Privacy Policy</a>    &nbsp;&nbsp;|&nbsp;&nbsp;  Designed by <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster</a> - <a href="https://www.zerotheme.com/" title="free website templates">ZEROTHEME</a>
	 	</div>
    </div>
  </div>
</footer>
</body>
</html>