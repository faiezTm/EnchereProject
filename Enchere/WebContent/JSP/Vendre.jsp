<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.tomcat.util.codec.binary.Base64" %>
<%@ page import="com.enchere.dao.ArticleDao" %>
<%@ page import="com.enchere.entities.ArticleEnchereHollandaise" %>
<%@ page import="java.sql.SQLException" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- end: META -->
<!-- start: GOOGLE FONTS -->
<link
	href="http://fonts.googleapis.com/css?family=Lato:300,400,400italic,600,700|Raleway:300,400,500,600,700|Crete+Round:400italic"
	rel="stylesheet" type="text/css" />
<!-- end: GOOGLE FONTS -->
<!-- start: MAIN CSS-->
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="vendor/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="vendor/themify-icons/themify-icons.min.css">
<link href="vendor/animate.css/animate.min.css" rel="stylesheet"
	media="screen">
<link href="vendor/perfect-scrollbar/perfect-scrollbar.min.css"
	rel="stylesheet" media="screen">
<link href="vendor/switchery/switchery.min.css" rel="stylesheet"
	media="screen">

<!-- end: MAIN CSS -->
<!-- start: CLIP-TWO CSS-->
<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/plugins.css">
<link rel="stylesheet" href="assets/css/themes/theme-1.css"
	id="skin_color" />

<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="screen">
<link href="vendor/DataTables/css/DT_bootstrap.css" rel="stylesheet" media="screen">

		<link href="vendor/bootstrap-touchspin/jquery.bootstrap-touchspin.min.css" rel="stylesheet" media="screen">
		<link href="vendor/select2/select2.min.css" rel="stylesheet" media="screen">
		<link href="vendor/bootstrap-datepicker/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" media="screen">
		<link href="vendor/bootstrap-timepicker/bootstrap-timepicker.min.css" rel="stylesheet" media="screen">

		<link href="vendor/fullcalendar/fullcalendar.min.css" rel="stylesheet" media="screen">
		<link href="vendor/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
				
<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
</head>
<body>
	<div id="app">
		<!-- sidebar -->
		<div class="sidebar app-aside" id="sidebar">
			<div class="sidebar-container perfect-scrollbar">
				<nav> <!-- start: SEARCH FORM -->
				<div class="search-form">
					<a class="s-open" href="#"> <i class="ti-search"></i>
					</a>
					<form class="navbar-form" role="search">
						<a class="s-remove" href="#" target=".navbar-form"> <i
							class="ti-close"></i>
						</a>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search...">
							<button class="btn search-button" type="submit">
								<i class="ti-search"></i>
							</button>
						</div>
					</form>
				</div>
				<!-- end: SEARCH FORM --> <!-- start: MAIN NAVIGATION MENU -->
				<div class="navbar-title">
					<span>Main Navigation</span>
				</div>

				
				<ul class="main-navigation-menu">
					<div class="navbar-title item-media ">
						<span style="color: #007AFF;"><b style="font-size: 15px">Catégorie</b></span>
					</div>
					<li><a href="javascript:void(0)">
							<div class="item-content">
								<div class="item-media">
									<i class="ti-menu-alt"></i>
								</div>
								<div class="item-inner">
									<span class="title"> Categorie_1 </span><i class="icon-arrow"></i>
								</div>
							</div>
					</a>
						<ul class="sub-menu">
							<li><a href="javascript:;"> <span>Item 1</span> <i
									class="icon-arrow"></i>
							</a>
								<ul class="sub-menu">
									<li><a href="javascript:;"> <span>Sample Link 1</span>
											<i class="icon-arrow"></i>
									</a>
										<ul class="sub-menu">
											<li><a href="#"> Sample Link 1 </a></li>
											<li><a href="#"> Sample Link 2 </a></li>
											<li><a href="#"> Sample Link 3 </a></li>
										</ul></li>
									<li><a href="javascript:;"> <span>Sample Link 2</span>
											<i class="icon-arrow"></i>
									</a>
										<ul class="sub-menu">
											<li><a href="#"> Sample Link 1 </a></li>
											<li><a href="#"> Sample Link 2 </a></li>
											<li><a href="#"> Sample Link 3 </a></li>
										</ul></li>
									<li><a href="javascript:;"> <span>Sample Link 3</span>
											<i class="icon-arrow"></i>
									</a>
										<ul class="sub-menu">
											<li><a href="#"> Sample Link 1 </a></li>
											<li><a href="#"> Sample Link 2 </a></li>
											<li><a href="#"> Sample Link 3 </a></li>
										</ul></li>
								</ul></li>
							<li><a href="javascript:;"> <span>Item 2</span> <i
									class="icon-arrow"></i>
							</a>
								<ul class="sub-menu">
									<li><a href="javascript:;"> <span>Sample Link 1</span>
											<i class="icon-arrow"></i>
									</a>
										<ul class="sub-menu">
											<li><a href="#"> Sample Link 1 </a></li>
											<li><a href="#"> Sample Link 2 </a></li>
											<li><a href="#"> Sample Link 3 </a></li>
										</ul></li>
									<li><a href="javascript:;"> <span>Sample Link 2</span>
											<i class="icon-arrow"></i>
									</a>
										<ul class="sub-menu">
											<li><a href="#"> Sample Link 1 </a></li>
											<li><a href="#"> Sample Link 2 </a></li>
											<li><a href="#"> Sample Link 3 </a></li>
										</ul></li>
									<li><a href="javascript:;"> <span>Sample Link 3</span>
											<i class="icon-arrow"></i>
									</a>
										<ul class="sub-menu">
											<li><a href="#"> Sample Link 1 </a></li>
											<li><a href="#"> Sample Link 2 </a></li>
											<li><a href="#"> Sample Link 3 </a></li>
										</ul></li>
								</ul></li>
							<li><a href="javascript:;"> <span>Item 3</span> <i
									class="icon-arrow"></i>
							</a>
								<ul class="sub-menu">
									<li><a href="javascript:;"> <span>Sample Link 1</span>
											<i class="icon-arrow"></i>
									</a>
										<ul class="sub-menu">
											<li><a href="#"> Sample Link 1 </a></li>
											<li><a href="#"> Sample Link 2 </a></li>
											<li><a href="#"> Sample Link 3 </a></li>
										</ul></li>
									<li><a href="javascript:;"> <span>Sample Link 2</span>
											<i class="icon-arrow"></i>
									</a>
										<ul class="sub-menu">
											<li><a href="#"> Sample Link 1 </a></li>
											<li><a href="#"> Sample Link 2 </a></li>
											<li><a href="#"> Sample Link 3 </a></li>
										</ul></li>
									<li><a href="javascript:;"> <span>Sample Link 3</span>
											<i class="icon-arrow"></i>
									</a>
										<ul class="sub-menu">
											<li><a href="#"> Sample Link 1 </a></li>
											<li><a href="#"> Sample Link 2 </a></li>
											<li><a href="#"> Sample Link 3 </a></li>
										</ul></li>
								</ul></li>
						</ul></li>


				</ul>
				</nav>
			</div>
		</div>
		<!-- / sidebar -->
		<div class="app-content">
			<!-- start: TOP NAVBAR -->
			<header class="navbar navbar-default navbar-static-top"> <!-- start: NAVBAR HEADER -->
			<div class="navbar-header">
				<a href="#"
					class="sidebar-mobile-toggler pull-left hidden-md hidden-lg"
					class="btn btn-navbar sidebar-toggle"
					data-toggle-class="app-slide-off" data-toggle-target="#app"
					data-toggle-click-outside="#sidebar"> <i
					class="ti-align-justify"></i>
				</a> <a class="navbar-brand" href="#">

					<h3 style="margin-top: 15px;">Tunisie Enchere</h3>
				</a> <a class="pull-right menu-toggler visible-xs-block"
					id="menu-toggler" data-toggle="collapse" href=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <i
					class="ti-view-grid"></i>
				</a>
			</div>
			<!-- end: NAVBAR HEADER --> <!-- start: NAVBAR COLLAPSE -->
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-right">
					<li class="dropdown"><a href class="dropdown-toggle"
						data-toggle="dropdown"> <i class="ti-home"></i> <span>ACCUEIl</span>
					</a></li>

					<li class="dropdown"><a href class="dropdown-toggle"
						data-toggle="dropdown"> <i class="ti-package"></i> <span>VENDRE</span>
					</a></li>


					<li class="dropdown"><a href class="dropdown-toggle"
						data-toggle="dropdown"> <i class="ti-key"></i> <span>S'INSCRIRE</span>
					</a></li>
					<!-- start: MESSAGES DROPDOWN -->
					<li class="dropdown"><a href class="dropdown-toggle"
						data-toggle="dropdown"> <i class="ti-user"></i> <span>CONNEXION</span>
					</a></li>
					<!-- end: MESSAGES DROPDOWN -->
					<!-- start: ACTIVITIES DROPDOWN -->

					<li class="dropdown"><a href class="dropdown-toggle"
						data-toggle="dropdown"> <i class="ti-shopping-cart"></i> <span>BOUTIQUE</span>
					</a></li>

					<li class="dropdown"><a href class="dropdown-toggle"
						data-toggle="dropdown"> <i class="ti-help"></i> Aide
					</a></li>
			</header>
			<!-- end: TOP NAVBAR -->
			<div class="main-content">
						
			<input id="demo4" type="text" value="0" name="demo4" touchspin data-verticalbuttons="true" data-verticalupclass="ti-angle-up" data-verticaldownclass="ti-angle-down">			
						<!-- start: DYNAMIC TABLE -->
						<div class="container-fluid container-fullw">
							<div class="row">
								<div class="col-md-12">
									<h5 class="over-title margin-bottom-15"><span class="text-bold">Article suivant l'enchere Anglaise</span></h5>
									<div class="row">
										<div class="col-md-12 space20">
											<button class="btn btn-green add-articleEnchereAnglaise">
												Add New <i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
									<div class="table-responsive">
										<table class="table table-striped table-hover" id="articleEnchereAnglaise">
											<thead>
												<tr>
													<th style="margin: 0px; width: 40px; height: 40px;">Description</th>
													<th>Definition Article</th>
													<th>Prix initiale</th>
													<th>Prix reserve</th>
													<th>Pays</th>
													<th>Lieu</th>
													<th>Region</th>
													<th>Photo</th>
													<th>Visibilité reserve</th>
													<th>increment value</th>
													<th>Date Debut</th>
													<th>Date Fin</th>
													<th>Edit</th>
													<th>Delete</th>
											</tr>
											</thead>
											<tbody>
												<c:forEach var="article" items="${listArticleEnchereAnglaise}">
													<c:url var="loadUserLink" value="">
														<c:param name = "id" value="0"/>
													</c:url>
													<tr>
														<td>${article.description} </td>
														
														<td>${article.definitionArt} </td>
														<td>${article.prixInit}</td>
														<td>${article.prixReserve}</td>
														<td>${article.pays}</td>
														<td>${article.lieu}</td>
														<td>${article.region}</td>
														<td>${article.photo}</td>
														<c:if test="${article.visibiliteReserve== true}">
														<td>Visible</td>
														</c:if>
														<c:if test="${article.visibiliteReserve == false}">
														<td>Non Visible</td>
														</c:if>
														
														<td>${article.incrementValue}</td>
														<td>${article.dateDebut}</td>
														<td>${article.dateFin}</td>
														<td> <a href="#" class="edit-row">Edit</a> </td>
														<td> <a href="#" class="delete-row">Delete</a> </td>
													</tr>
													
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						
						<div class="container-fluid container-fullw">
							<div class="row">
								<div class="col-md-12">
									<h5 class="over-title margin-bottom-15"><span class="text-bold">Article suivant l'enchere Hollandaise</span></h5>
									<div class="row">
										<div class="col-md-12 space20">
											<button class="btn btn-green add-articleEnchereHollandaise">
												Add New <i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
									
									<div class="table-responsive">
										<table class="table table-striped table-hover" id="articleEnchereHollandaise">
											<thead>
												<tr>
													<th style="margin: 0px; width: 40px; height: 40px;">Description</th>
													<th>Definition Article</th>
													<th>Prix initiale</th>
													<th>Prix reserve</th>
													<th>Pays</th>
													<th>Lieu</th>
													<th>Region</th>
													<th>Photo</th>
													<th>Visibilité reserve</th>
													<th>Quantité</th>
													<th>Date Debut</th>
													<th>Date Fin</th>
													<th>Edit</th>
													<th>Delete</th>
											</tr>
											</thead>
											<tbody>
											<%
											byte[] img = null;
											Blob b = null;
											List<ArticleEnchereHollandaise> listArticleEnchereHollandaise = ArticleDao.getAllArticlesEnchereHollandaise();
											for (ArticleEnchereHollandaise articleEnchereHollandaise : listArticleEnchereHollandaise) {
												try {
													b = articleEnchereHollandaise.getPhoto();
													int blobLength = (int) b.length();
													img = b.getBytes(1,blobLength);
										            String base64Encoded = new String(Base64.decodeBase64(img));
										            out.println("<tr><td>"+articleEnchereHollandaise.getDescription()+"</td>"+"<td>"+articleEnchereHollandaise.getDefinitionArt()+"</td>"+"<td>"+articleEnchereHollandaise.getPrixInit()+"</td>"+"<td>"+articleEnchereHollandaise.getPrixReserve()+"</td>"+"<td>"+articleEnchereHollandaise.getPays()+"</td>"+"<td>"+articleEnchereHollandaise.getLieu()+"</td>"+"<td>"+articleEnchereHollandaise.getRegion()+"</td>"+"<td><img src='"+base64Encoded+"' style= 'width:200px;height:200px;'/></td>");
													if(articleEnchereHollandaise.isVisibiliteReserve() == true){
														out.println("<td>Visible</td>");
													}
													else
														out.println("<td>Non Visible</td>");
													out.println("<td>"+articleEnchereHollandaise.getQteArticle()+"</td>"+"<td>"+articleEnchereHollandaise.getDateDebut()+"</td>"+"<td>"+articleEnchereHollandaise.getDateFin()+"</td><td> <a href='#' class='editArticleEnchereHollandaise'>Edit</a> </td><td> <a href='#' class='delete-row'>Delete</a> </td></tr>");
												} catch (SQLException e) {
													
													e.printStackTrace();
												}
											}
											%>
										
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
				</div>
			</div>
		</div>

	</div>



	<!-- start: MAIN JAVASCRIPTS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/modernizr/modernizr.js"></script>
	<script src="vendor/jquery-cookie/jquery.cookie.js"></script>
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="vendor/switchery/switchery.min.js"></script>
	<!-- end: MAIN JAVASCRIPTS -->
	<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<script src="vendor/Chart.js/Chart.min.js"></script>
	<script src="vendor/jquery.sparkline/jquery.sparkline.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/DataTables/jquery.dataTables.min.js"></script>
	
	<script src="vendor/maskedinput/jquery.maskedinput.min.js"></script>
	<script src="vendor/bootstrap-touchspin/jquery.bootstrap-touchspin.min.js"></script>
	<script src="vendor/autosize/autosize.min.js"></script>
	<script src="vendor/selectFx/classie.js"></script>
	<script src="vendor/selectFx/selectFx.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
	<script src="vendor/bootstrap-timepicker/bootstrap-timepicker.min.js"></script>
	
			<script src="vendor/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>
		<script src="vendor/moment/moment.min.js"></script>
		<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
		<script src="vendor/fullcalendar/fullcalendar.min.js"></script>
		<script src="vendor/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
		
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<!-- start: CLIP-TWO JAVASCRIPTS -->
	<script src="assets/js/main.js"></script>
	<!-- start: JavaScript Event Handlers for this page -->
	<script src="assets/js/table-data.js"></script>
	<script src="assets/js/form-elements.js"></script>
	
	<script src="assets/js/pages-calendar.js"></script>
		<script>
			$(document).ready(function(){
				Main.init();
				TableData.init();
				FormElements.init();
			});
		</script>
	<!-- end: JavaScript Event Handlers for this page -->
	<!-- end: CLIP-TWO JAVASCRIPTS -->
</body>
</html>
