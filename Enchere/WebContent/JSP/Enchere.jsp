<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
	 <%@ page import="java.util.*, java.net.*"%>
	 <%@ page import="com.enchere.dao.ConfigDao"%>
	 <%@ page import="com.enchere.entities.ConfigurationSite"%>
	 <%@ page import="com.enchere.entities.Rubrique"%>
	 <%@ page import="com.enchere.dao.RubriqueDao"%>
	 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>
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

</head>
<body>
<%

List <Rubrique> listRubrique=	RubriqueDao.getRubriques();
List <Rubrique> listFils= new ArrayList<Rubrique>();
session.setAttribute("listRubrique", listRubrique);
for (Rubrique rubrique : listRubrique) {
	if (rubrique.getMasterRubrique()!=null)
		listFils.add(rubrique);
	
}
session.setAttribute("listFils", listFils);

List <ConfigurationSite> listConfig=ConfigDao.getConfig();
session.setAttribute("listConfig",listConfig);

%>
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
	
					
					<li><c:forEach var="Rubrique" items="${ listRubrique }" varStatus="loop">
					<c:if test="${ Rubrique.getMasterRubrique() == null }">
					<a href="javascript:void(0)">
							<div class="item-content">
								<div class="item-media">
									<i class="ti-menu-alt"></i>
								</div>
												
								<div class="item-inner">
									<span class="title">${ Rubrique.getNomRubrique() } </span><i class="icon-arrow"></i>
								</div>
							</div>
					</a>
					<ul class="sub-menu">
					<c:forEach var="Rubrique2" items="${ listFils }" varStatus="loop">
					<c:if test="${ Rubrique2.getMasterRubrique().getIdRubrique() ==Rubrique.getIdRubrique()  }">
							
						
									<li><a href="javascript:;"> <span>${ Rubrique2.getNomRubrique() } </span> <i
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
							</a>
							
							</c:if>
					</c:forEach>
					</ul>
	
	</c:if>
					
					
					</c:forEach>

						
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

					<h3 style="margin-top: 15px;">${ (listConfig[0]).getNomSite() }</h3>
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


					<li class="dropdown"><a href="Inscription.jsp"  class="dropdown-toggle"
						> <i class="ti-key"></i> <span>S'INSCRIRE</span>
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
				<div class="wrap-content container" id="container"></div>
				<%

				ArticleEnchereHollandaise Art=null;
				byte[] img = null;
				Blob b = null;
				int id = Integer.parseInt(request.getParameter("id"));
				
				HttpSession s=request.getSession();
				Art =(ArticleEnchereHollandaise)s.getAttribute("art");
				DateFormat.getDateInstance(DateFormat.MEDIUM ).format( Art.getDateFin() ) ;
				
				long nbJours = ((Art.getDateFin().getTime() -  new Date().getTime()) /3600000)/24;
				long nbHeures = ((Art.getDateFin().getTime() -  new Date().getTime()) /3600000)%24;
	           
				
				%>
				<div class="col-sm-5 col-md-4" style="width:100%;">
														<div class="user-left" >
														<div class="panel panel-white" style="float:right; width:300x;margin-top:5%;">
												
												<form role="form" class="form-horizontal" style="width:700px;height:600px;" method="POST" action="../TestEncherir" >
												<br>
												<p>Reste :<%=nbJours  %> J <%=nbHeures  %>H </p>
														<div class="form-group">
															<label class="col-sm-2 control-label" for="inputEmail3">
																Quantite
															</label>
															<div class="col-sm-10">
																<input type="number" placeholder="Email" id="inputEmail3" class="form-control" name="quantite">
															</div>
														</div>
														<div class="form-group">
															<label class="col-sm-2 control-label" for="inputPassword3">
																Prix Proposé par l'acheteur
															</label>
															<div class="col-sm-10">
																<input type="number" step="any" placeholder="Prix" id="inputPassword3" style=" width:500px;" name="prix">
															</div>
														</div>
														
														<div class="form-group margin-bottom-0">
															<div class="col-sm-offset-2 col-sm-10">
																<button class="btn btn-o btn-primary" type="submit">
																	Encherir
																</button>
															</div>
														</div>
														
													</form>
												
												
												
												
											</div>
												
															<div class="center"  style="margin-right:30%;" >
														      
																<h4 >${ art.getDefinitionArt() }</h4>
																<div  >
																	<div class="user-image" >
																		
																		<div class="fileinput-new thumbnail" style="width:200px;height:200px;" ><img style="width:180px;height:180px;" src="${image }" alt="">
																		</div>
																		
																		<div class="user-image-buttons">
																			
																			
																		</div>
																	</div>
																</div>
																
															</div>
															<table class="table table-condensed">
																<thead>
																	<tr>
																		<th colspan="3">information sur l'article</th>
																	</tr>
																</thead>
																<tbody>
																	<tr>
																		<td>Offre en Cours</td>
																		<td>
																		<a href="#">
																			www.example.com
																		</a></td>
																		<td><a href="#panel_edit_account" class="show-tab"><i class="fa fa-pencil edit-user-info"></i></a></td>
																	</tr>
																	<tr>
																		<td>Envoyer une offres</td>
																
																		<td><a href="#panel_edit_account" class="show-tab"><i class="fa fa-pencil edit-user-info"></i></a></td>
																	</tr>
																	<tr>
																		<td>Quantite:</td>
																		<td>(641)-734-4763</td>
																		<td><a href="#panel_edit_account" class="show-tab"><i class="fa fa-pencil edit-user-info"></i></a></td>
																	</tr>
																	<tr>
																		<td>Nombre d'enchère</td>
																		<td>
																		<a href="">
																			peterclark82
																		</a></td>
																		<td><a href="#panel_edit_account" class="show-tab"><i class="fa fa-pencil edit-user-info"></i></a></td>
																	</tr>
																	<tr>
																		<td>Liee</td>
																		<td>
																		<a href="">
																			peter@example.com
																		</a></td>
																		<td><a href="#panel_edit_account" class="show-tab"><i class="fa fa-pencil edit-user-info"></i></a></td>
																	</tr>
																	<tr>
																		<td>Pays</td>
																		<td>
																		<a href="">
																			peter@example.com
																		</a></td>
																		<td><a href="#panel_edit_account" class="show-tab"><i class="fa fa-pencil edit-user-info"></i></a></td>
																	</tr>
																	<tr>
																		<td>Fin dans</td>
																		<td>
																		<a href="">
																			peter@example.com
																		</a></td>
																		<td><a href="#panel_edit_account" class="show-tab"><i class="fa fa-pencil edit-user-info"></i></a></td>
																	</tr>
																	<tr>
																		<td>Date de début</td>
																		<td>
																		<a href="">
																			peter@example.com
																		</a></td>
																		<td><a href="#panel_edit_account" class="show-tab"><i class="fa fa-pencil edit-user-info"></i></a></td>
																	</tr>
																	<tr>
																		<td>date de fin</td>
																		<td>
																		<a href="">
																			peter@example.com
																		</a></td>
																		<td><a href="#panel_edit_account" class="show-tab"><i class="fa fa-pencil edit-user-info"></i></a></td>
																	</tr>
																	<tr>
																		<td>statut</td>
																		<td>
																		<a href="">
																			peter@example.com
																		</a></td>
																		<td><a href="#panel_edit_account" class="show-tab"><i class="fa fa-pencil edit-user-info"></i></a></td>
																	</tr>
																</tbody>
															</table>
															<table class="table">
																<thead>
																	<tr>
																		<th colspan="3">Description</th>
																	</tr>
																</thead>
																<tbody>
																	<tr>
																		<td>${art.getDescription()}</td>
																	</tr>
													
																</tbody>
															</table>
															<table class="table">
																<thead>
																	<tr>
																		<th colspan="3">Livraison</th>
																	</tr>
																</thead>
																<tbody>
																	<tr>
																		<td>aaaa</td>
																		
																	</tr>
																	
																		
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
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<!-- start: CLIP-TWO JAVASCRIPTS -->
	<script src="assets/js/main.js"></script>
	<!-- start: JavaScript Event Handlers for this page -->
	<script src="assets/js/index.js"></script>
	<script>
		jQuery(document).ready(function() {
			Main.init();
			Index.init();
		});
	</script>
	<!-- end: JavaScript Event Handlers for this page -->
	<!-- end: CLIP-TWO JAVASCRIPTS -->
</body>
</html>
