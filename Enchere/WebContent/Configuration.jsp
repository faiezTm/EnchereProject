<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<!-- start: MAIN CSS -->
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
<!-- start: CLIP-TWO CSS -->
<link rel="stylesheet" href="assets/css/styles.css">
<link rel="stylesheet" href="assets/css/plugins.css">
<link rel="stylesheet" href="assets/css/themes/theme-1.css"
	id="skin_color" />
</head>
<body>
	<h1 class="mainTitle">Configuration Site</h1>
	<form action="#" role="form" id="form">
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
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label"> Nom Site <span
						class="symbol required"></span>
					</label> <input type="text" placeholder="Insérer le nom du site "
						class="form-control" id="firstname" name="nomSite">
				</div>
				<div class="form-group">
					<label class="control-label"> Nombre d'article apparaissant
						A la une <span class="symbol required"></span>
					</label> <input type="number" placeholder="nombre d'article à la une"
						class="form-control" id="lastname" name="nbrArticleApparaitALaUne">
				</div>
				<div class="form-group">
					<label class="control-label"> Tarif d'affichage A la une <span
						class="symbol required"></span>
					</label> <input type="text" placeholder="Tarif" class="form-control"
						id="tarifALaUne" name="tarifAffichALaune">
				</div>
				<div class="form-group">
					<label class="control-label"> Delai accordé pour confirmer
						l'inscription en heures <span class="symbol required"></span>
					</label> <input type="number" placeholder="delai confirmation  inscription"
						class="form-control" id="lastname" name="delaiConfirmInscrit">
				</div>
				<div class="form-group">
					<label class="control-label"> Taux de commission prélevée
						sur les ventes <span class="symbol required"></span>
					</label> <input type="number" placeholder="Taux de commission "
						class="form-control" id="lastname" name="tauxCommission">
				</div>

				<div class="form-group">
					<label class="control-label"> Reglements destinés aux
						vendeurs <span class="symbol required"></span>
					</label> <input type="number"
						placeholder="Reglements destinés aux vendeurs "
						class="form-control" id="reglementsDestVendeurs"
						name="reglementsDestVendeurs">
				</div>

				<div class="form-group">
					<label class="control-label"> Reglements destinés aux
						acheteurs <span class="symbol required"></span>
					</label> <input type="number"
						placeholder="Reglements destinés aux acheteurs "
						class="form-control" id="reglementDestAcheteurs"
						name="reglementsAcheteurs">
				</div>
			</div>
		</div>
		</div>
		</div>
		<div class="row">

			<div class="col-md-4">
				<button class="btn btn-primary btn-wide pull-right" type="submit">
					Enregister <i class="fa fa-arrow-circle-right"></i>
				</button>
			</div>
		</div>
	</form>

</body>
</html>