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

<title>Social Media Hub</title>
</head>
<body>
	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>

	<div class="navbar navbar-default">

	<div id="main">
    <header>
	  <div id="banner">
	  		<div class="navbar-header">
			<ul class="nav navbar-nav navbar-right">
				<li><a href='<c:url value="/socialmedia.html"/>'><img src='<c:url value="/mimes/images/logo.jpg" />' width="175px" hight="125px"/></a></li>
			</ul>
		</div>
		<%--
	    <div id="welcome">
	      <h3>Social Media Hub</span></h3>
	    </div><!--close welcome-->
	    <div id="welcome_slogan">
	      <h3></h3>
	    </div><!--close welcome_slogan-->
	    --%>		
	  </div><!--close banner-->
    </header>

	<nav>
	  <div id="menubar">
        <ul id="nav">
          <li class="current"><a href="<c:url value="/socialmedia.html"/>">Marketing</a></li>
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
        <div class="content_item" >
		  

	
			<div class="container" style="margin-top:30px" >
						<form:form id="myForm" method="post" commandName="smHub">
							<fieldset style="width:900px">
								<!-- <legend>Social Media Hub</legend> -->
									 
								<table id="postStatus">
									<tr><td style="width:200px">
										<label for="programIdSelect" class="col-lg-3 control-label">Program</label>
										</td>
										<td>
									   <form:select id="programIdSelect" path="programId" items="${programList}">  
        								</form:select>
        								</td>
        								</tr><tr><td></td>
        								<td colspan=2>										
										<form:errors path="programId" cssClass="error" />
										</td>							
									</tr>				
							
									<tr><td>
										<label for="targetRadio" class="col-lg-3 control-label">Post Target</label>
										</td><td>
										<form:checkbox id="targetRadio" path="target" value="Twitter"/>Twitter&nbsp; 
										<form:checkbox id="targetRadio" path="target" value="Facebook"/>Facebook
										</td>
										</tr><tr><td></td>
        								<td colspan=2>	
										<form:errors path="target" cssClass="error" />
										</td>
									</tr>
									<tr><td>
										<label for="statusInput" class="col-lg-3 control-label">Social Feed</label>
										</td><td>
											<form:textarea class="form-control" path="socialFeed"
												id="statusInput" placeholder="Status" maxlength="140" cols="75" rows="5"/>
										</td></tr><tr><td></td>
        								<td colspan=2>		
											<form:errors path="socialFeed" cssClass="error" />
											</td>
									</tr>
<%--
								<div class="form-group">
									<label for="passwordInput" class="col-lg-3 control-label">Product ID</label>
									<div class="col-lg-9">
										<form:input type="text" class="form-control"
											path="prodId" id="passwordInput" placeholder="Password" />
										<form:errors path="prodId" cssClass="error" />
									</div>
								</div>
--%>
								<tr><td  colspan=1>
									<!--  <button class="btn btn-default">Cancel</button>-->
									</td><td>
									<div >
									<button class="button_small">Post</button>
									</div>
									</td>
								</tr>
								</table>
							</fieldset>
						</form:form>
			</div>


        
		  
		  <%--  
		  <div class="content_imagetext">
		    <div class="content_image">
		      <img src="images/image1.jpg" alt="image1"/>
	        </div>
		    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi elit sapien, tempus sit amet hendrerit volutpat, euismod vitae risus. Etiam consequat, sem et vulputate dapibus, diam enim tristique est, vitae porta eros mauris ut orci. Praesent sed velit odio. Ut massa arcu, suscipit viverra molestie at, aliquet a metus. Nullam sit amet tellus dui, ut tincidunt justo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec iaculis egestas laoreet. Nunc non ipsum metus, non laoreet urna. Vestibulum quis risus quis diam mattis tempus. Vestibulum suscipit pretium tempor. </p>
		  </div><!--close content_imagetext-->
	
		  <div class="content_container">
		    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim. Aliquam facilisis neque non nunc posuere eget volutpat metus tincidunt.</p>
		  	<div class="button_small">
		      <a href="#">Read more</a>
		    </div><!--close button_small-->
		  </div><!--close content_container-->
          <div class="content_container">
		    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim. Aliquam facilisis neque non nunc posuere eget volutpat metus tincidunt.</p>          
		  	<div class="button_small">
		      <a href="#">Read more</a>
		    </div><!--close button_small-->		  
		  </div><!--close content_container-->		
          <div class="content_container">
		    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque cursus tempor enim. Aliquam facilisis neque non nunc posuere eget volutpat metus tincidunt.</p>          
		  	<div class="button_small">
		      <a href="#">Read more</a>
		    </div><!--close button_small-->		  
		  </div><!--close content_container-->	
		  	  --%>
		</div><!--close content_item-->
      </div><!--close content-->   
	</div><!--close site_content-->  	
  </div><!--close main-->
  
    <footer>
	  <a href="index.html">Home</a> | <a href="ourwork.html">Our Work</a> | <a href="testimonials.html">Testimonials</a> | <a href="projects.html">Projects</a> | <a href="contact.html">Contact</a><br/><br/>
	 <%-- <a href="http://fotogrph.com">Images</a> | Heart Internet <a href="http://www.heartinternet.co.uk/web-hosting/">web hosting</a> | website template by <a href="http://www.freehtml5templates.co.uk">Free HTML5 Templates</a> --%> 
    </footer>

  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
</body>
</html>