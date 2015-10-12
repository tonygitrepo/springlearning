<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="c"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>

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
.headerstyle{
	background-color : #A9A9A9;
	text-align: center;
}

li {list-style-type: none;}



</style>
<title>Social Media Hub</title>
</head>
<body>
	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>

	<div class="navbar navbar-default">
	<!--  
		<div class="navbar-collapse collapse navbar-responsive-collapse">

			<ul class="nav navbar-nav navbar-right">
				<li><b><a href="/socialmedia">Home</a></b></li>
			</ul>
		</div> -->
		
		<!-- /.nav-collapse -->
	</div>

	<div style="margin-left:30px" class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
				
				</div>
				
							
				
				
			</div>
		</div>
	</div>
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
          <li class="current"><a href="<c:url value="/fetchtweets/service.html"/>">Service</a></li>
          <li><a href="<c:url value="/fetchtweets/analytics.html"/>">Analytics</a></li>
          <li><a href="projects.html"></a></li>
          <li><a href="contact.html"></a></li>
        </ul>
      </div><!--close menubar-->	
    </nav>	
    
	<div id="site_content">		
	  <div id="content">
        <div class="content_item">
		 
		  <div class="content_imagetext">
		   	<div class="col-lg-6">
						<form:form id="myForm" method="post"
							class="bs-example form-horizontal" commandName="readFromTwitter">
							<fieldset style="width:900px">
								<!--  <legend>Social Media Hub</legend> -->
									 
								<table>
								<tr>  
										<td><p class="highlight">Feeds for Services requests / Complaints / Activity Creation </p>  
											<p class="highlight" style="font-size:100%">Mentions Timeline :</br>
											Tweets posted on <b>(corporate) account</b> timeline by other users or tweets with our @screen_name mentioned.</br></p>
											<td>
									<button style="width:100px" class="button_small" name="param1" class="btn btn-primary" value="MENTIONSTIMELINE">Fetch Feeds</button>																
									</td>
								</tr>
								</table>
								</fieldset>
								<%-- 
								<fieldset style="width:900px">
								<table>
								<tr><td  colspan=1>
									<!--  <button class="btn btn-default">Cancel</button>-->
									</td>  <b>User Timeline :</b></br>
											Tweets posted by the <b>(business) User</b> on the timeline as Promotions / Brand survey etc .</br>
											<p class="highlight">Feeds for Analytics / Feedback / Trend Evalution </p> .<td>									
									<button name="param1" class="btn btn-primary" value="USERTIMELINE">Fetch User Timeline</button>									
									</td>
								</tr>
								</table>
							</fieldset>
							--%>
						</form:form>
					</div>
		  </div><!--close content_imagetext-->
		  					<d:if test="${statusList.size()>0}">
							<table style="margin-left:5px" border=1 width="900px">
							<d:choose>
							 <d:when test="${statusType eq 'MENTIONSTIMELINE'}">
							      <tr class="headerstyle"><td colspan="7">MENTIONS TIMELINE</td></tr>							
							  </d:when>
							  <d:when test="${statusType eq 'USERTIMELINE'}">
							      <tr class="headerstyle"><td colspan="7">USER TIMELINE</td></tr>							
							  </d:when>
							 </d:choose>  
							
								<tr class="headerstyle"><td>Tweet ID</td><td>Twitter User</td><td>Status Text</td><td>Status Language</td><td>Favourite Count</td><td>Retweet Count</td><td>Created At</td></tr>
							
							<d:forEach items="${statusList}" var="status">
							  
 								<tr><td>																
									${status.getStatusId()} 
									</td>
									<td>																
									${status.getStatusUser()} 
									</td>
									<td>																
									${status.getStatusText()} 
									</td>									
									<td>																
									${status.getStatusLang()} 
									</td>
									<td>																
									${status.getStatusFavCount()} 
									</td>
									<td>																
									${status.getStatusReplyCount()} 
									</td>
									<td>																
									${status.getStatusCreatedAt()} 
									</td>								
								</tr>
							</d:forEach>	
							</table>
		  				</d:if>
		</div><!--close content_item-->
      </div><!--close content-->   
	</div><!--close site_content-->  	
  </div><!--close main-->
  
    <footer>
	  <a href="index.html">Home</a> | <a href="ourwork.html">Our Work</a> | <a href="testimonials.html">Testimonials</a> | <a href="projects.html">Projects</a> | <a href="contact.html">Contact</a><br/><br/>
	<%--   <a href="http://fotogrph.com">Images</a> | Heart Internet <a href="http://www.heartinternet.co.uk/web-hosting/">web hosting</a> | website template by <a href="http://www.freehtml5templates.co.uk">Free HTML5 Templates</a> --%>
    </footer>

  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
</body>
</html>