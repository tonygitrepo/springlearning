<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<c:url value="/mimes/css/style.css" />" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="<c:url value="/mimes/js/modernizr-1.5.min.js"/>"></script>
<style>
.error {
	color: #ff0000;
	font-size: 0.9em;
	font-weight: bold;
}
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

li {list-style-type: none;}
</style>
<title>Success</title>
</head>
<body>
  <div id="main">
    <header>
	  <div id="banner">
	  		<div class="navbar-header">
			<ul class="nav navbar-nav navbar-right">
				<li><a href='<c:url value="/socialmedia.html"/>'><img src='<c:url value="/mimes/images/logo.jpg" />' width="175px" hight="125px"/></a></li>
			</ul>
		</div>
    </header>

		<nav>
	  <div id="menubar">
        <ul id="nav">
          <li><a href="<c:url value="/socialmedia.html"/>">Marketing</a></li>
          <li><a href="<c:url value="/fetchtweets/service.html"/>">Service</a></li>
          <li><a href="<c:url value="/fetchtweets/analytics.html"/>">Analytics</a></li>
          <li><a href="projects.html"></a></li>
          <li><a href="contact.html"></a></li>
        </ul>
      </div><!--close menubar-->	
    </nav>
    
	<div id="site_content">		

          <div class="slideshow">
	    <ul class="slideshow">
        <%--   <li class="show"><img width="900" height="250" src=<c:url value="/mimes/images/home_4.jpg" /> alt="&quot;Enter your caption here&quot;" /></li>--%>
          <li><img width="900" height="150" src=<c:url value="/mimes/images/home_4.jpg"/> alt="&quot;Enter your caption here&quot;" /></li>
        </ul> 
	  </div>
	
	  <div id="content">
        <div class="content_item">
          <h1 style="text-align:center;padding:50px">Social Feed has been successfully posted !!</h1>			
	    </div><!--close content_item-->
      </div><!--close content-->   
	</div><!--close site_content-->  	
  </div><!--close main-->
  
    <footer>
	  <a href="index.html">Home</a> | <a href="ourwork.html">Our Work</a> | <a href="testimonials.html">Testimonials</a> | <a href="projects.html">Projects</a> | <a href="contact.html">Contact</a><br/><br/>
	 <%--  <a href="http://fotogrph.com">Images</a> | Heart Internet <a href="http://www.heartinternet.co.uk/web-hosting/">web hosting</a> | website template by <a href="http://www.freehtml5templates.co.uk">Free HTML5 Templates</a>--%>
    </footer>

  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.js"></script>	
  <script type="text/javascript" src="js/image_slide.js"></script>
  
</body>
</html>