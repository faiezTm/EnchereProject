<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
	 <%@ page import="java.util.*, java.net.*"%>
	 <%@ page import="com.enchere.dao.ConfigDao"%>
	 <%@ page import="com.enchere.entities.ConfigurationSite"%>
	 <%@ page import="com.enchere.entities.Rubrique"%>
	 <%@ page import="com.enchere.dao.RubriqueDao"%>
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

<form class="form-login" action="../Authentification" method="post">
					<fieldset>

						<p>Please enter your name and password to log in.</p>
						<div class="form-group">
							<span class="input-icon"> <input type="text"
								class="form-control" name="login" placeholder="Username">
								<i class="fa fa-user"></i>
							</span>
						</div>
						<div class="form-group form-actions">
						
							<span class="input-icon"> <input type="password"
								class="form-control password" name="password"
								placeholder="Password"> <i class="fa fa-lock"></i> <a
								class="forgot" href="login_forgot.html"> I forgot my
									password </a>
							</span>
						</div>
						<div class="form-actions">

							<button type="submit" class="btn btn-primary pull-right">
								Login <i class="fa fa-arrow-circle-right"></i>
							</button>
							<p Style="color:red"> ${ message } </p>
						</div>
						<br>
						<br>
						<div class="new-account">
							Don't have an account yet? <a href="login_registration.html">
								Create an account </a>
						</div>
					</fieldset>
				</form>
				<ul class="main-navigation-menu">
					<div class="navbar-title item-media ">
						<span style="color: #007AFF;"><b style="font-size: 15px">Categorie</b></span>
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
			<div class="main-content" style="margin-left:300px; " >
				<h1 class="mainTitle" >Inscription</h1>
	<form action="../AjoutUtilisateur" method="post" role="form" id="idPage" >
		<div class="row">
			<div class="col-md-12">
				<div class="errorHandler alert alert-danger no-display">
					<i class="fa fa-times-sign"></i> You have some form errors. Please
					check below.
				</div>
				<div class="successHandler alert alert-success no-display">
					<i class="fa fa-ok"></i> Your form validation is successful!
				</div>
			</div>
			<div class="col-md-6" id="idPage">
				<div class="form-group">
					<label class="control-label"> Nom <span
						class="symbol required"></span>
					</label> <input type="text" placeholder="ecrire votre nom "
						class="form-control" id="firstname" name="nom" value="${ listParam[0]}" >
				</div>
				<div class="form-group">
					<label class="control-label">Prenom <span class="symbol required"></span>
					</label> <input type="text" placeholder="ecrire votre prenom "
						class="form-control" id="firstname" name="prenom" value="${ listParam[1]}"  >
				</div>
				<div class="form-group">
					<label class="control-label"> Email <span
						class="symbol required"></span>
					</label> <input type="email" placeholder="ecrire votre Email" class="form-control"
						id="tarifALaUne" name="email" value="${ listParam[2]}"  >
				</div>
				<div class="form-group">
					<label class="control-label"> Adresse<span class="symbol required"></span>
					</label> <input type="text" placeholder="delai confirmation  inscription"
						class="form-control" id="lastname" name="adresse" value="${ listParam[3]}"  >
				</div>
				<div class="form-group">
					<label class="control-label"> Code Postal <span class="symbol required"></span>
					</label> <input type="number" placeholder="Taux de commission "
						class="form-control" id="lastname" name="codePostal"  value="${ listParam[4]}" >
				</div>

				<div class="form-group">
					<label class="control-label">Num Carte Credit<span class="symbol required"></span>
					</label> <input type="number"
						placeholder="Reglements destinés aux vendeurs "
						class="form-control" id="reglementsDestVendeurs"
						name="numCarteCredit" value="${ listParam[5]}"  >
				</div>

				<div class="form-group">
					<label class="control-label"> Login<span class="symbol required"></span>
					</label> <input type="text"
						placeholder="Reglements destinés aux acheteurs "
						class="form-control" id="reglementDestAcheteurs"
						name="login"  value="${ listParam[6]}" >
				</div>
					<div class="form-group">
					<label class="control-label"> Mot De Passe<span class="symbol required"></span>
					</label> <input type="text"
						placeholder="Reglements destinés aux acheteurs "
						class="form-control" id="reglementDestAcheteurs"
						name="motDePasse"  value="${ listParam[7]}" >
				</div>
					<div class="form-group">
					<label class="control-label"> Confirmer Votre Mot De Passe<span class="symbol required"></span>
					</label> <input type="text"
						placeholder="Reglements destinés aux acheteurs "
						class="form-control" id="reglementDestAcheteurs"
						name="motDePasse2" value="${ listParam[8]}" >
				</div>
					<div class="form-group">
					<label class="control-label"> choisir une image<span class="symbol required"></span>
					</label> <input type="file"
						placeholder="Reglements destinés aux acheteurs "
						class="form-control" 
						name="photo"  accept="image/*"   >
				</div>

			
<p style="color:red; style="margin-left:300px; ">${ errorMotDePasse }</p>
			

			</div>
		</div>
		</div>
		</div>
		
		</div>
		<br>
	
		<div class="row" style="margin-left:300px; " >

			<div class="col-md-4">
				<button class="btn btn-primary btn-wide pull-right" type="submit">
					Enregister <i class="fa fa-arrow-circle-right"></i>
				</button>
			</div>
				
					
				</div>
				
			
	</form>
	
	
			
	

	

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
