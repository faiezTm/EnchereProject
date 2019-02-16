<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*, java.net.*"%>
<%@ page import="com.enchere.entities.Rubrique"%>
<%@ page import="com.enchere.controller.Config"%>
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
<%

HttpSession SS = request.getSession();
List <Rubrique> listRubrique=	RubriqueDao.getRubriques();
System.out.println("aaaaaaaaaaaaaaaaaaaaaaa"+listRubrique.get(0));
session.setAttribute("listRubrique", listRubrique);
%>
	<h1 class="mainTitle">Configuration Site</h1>
	<form action="../TestRubrique" method="post" role="form" id="idPage">
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
					<label class="control-label"> Nom Site <span
						class="symbol required"></span>
					</label> <input type="text" placeholder="Insérer le nom du site "
						class="form-control" id="firstname" name="nomSite" value="${nomSite}">
				</div>
				<div class="form-group">
					<label class="control-label"> Nombre d'article apparaissant
						A la une <span class="symbol required"></span>
					</label> <input type="number" placeholder="nombre d'article à la une"
						class="form-control" id="lastname" name="nbrArticleApparaitALaUne" value="${nbrArticleApparaitALaUne}">
				</div>
				<div class="form-group">
					<label class="control-label"> Tarif d'affichage A la une <span
						class="symbol required"></span>
					</label> <input type="text" placeholder="Tarif" class="form-control"
						id="tarifALaUne" name="tarifAffichALaune" value="${tarifAffichALaune}">
				</div>
				<div class="form-group">
					<label class="control-label"> Delai accordé pour confirmer
						l'inscription en heures <span class="symbol required"></span>
					</label> <input type="number" placeholder="delai confirmation  inscription"
						class="form-control" id="lastname" name="delaiConfirmInscrit" value="${delaiConfirmInscrit} ">
				</div>
				<div class="form-group">
					<label class="control-label"> Taux de commission prélevée
						sur les ventes <span class="symbol required"></span>
					</label> <input type="number" placeholder="Taux de commission "
						class="form-control" id="lastname" name="tauxCommission" value="${tauxCommission}">
				</div>

				<div class="form-group">
					<label class="control-label"> Reglements destinés aux
						vendeurs <span class="symbol required"></span>
					</label> <input type="number"
						placeholder="Reglements destinés aux vendeurs "
						class="form-control" id="reglementsDestVendeurs"
						name="reglementsDestVendeurs" value="${reglementsDestVendeurs}">
				</div>

				<div class="form-group">
					<label class="control-label"> Reglements destinés aux
						acheteurs <span class="symbol required"></span>
					</label> <input type="number"
						placeholder="Reglements destinés aux acheteurs "
						class="form-control" id="reglementDestAcheteurs"
						name="reglementsAcheteurs" value="${reglementsAcheteurs}">
				</div>

				<div class="form-group">
					<label for="sel1">Selectionner une rubrique</label> <select
						class="form-control" id="sel1" name="selectMaster0">
						<option value="aucune">Faites votre choix</option>
						<c:forEach var="Rubrique2" items="${ listRubrique }"
							varStatus="loop">
							<option value="${Rubrique2.getNomRubrique() }">${Rubrique2.getNomRubrique()}</option>
						</c:forEach>
					</select> <label for="sel1">Ajouter une rubrique</label> <input type="texte"
						placeholder="ajouter une rubrique " class="form-control"
						id="ajoutRubrique" name="nomRubrique0">
				</div>


			</div>
		</div>
		</div>
		</div>
		
		</div>
		<br>
		<div class="row" style="margin-left: 70px;">

			<div class="col-md-4">
				<button class="btn btn-primary btn-wide pull-right" type="submit">
					Enregister <i class="fa fa-arrow-circle-right"></i>
				</button>
			</div>
				<div class="form-group">
					
				</div>
			
	</form>
	<p style="color:red;">${errorChamp}</p>
	<div class="row">
			<div class="col-md-12 space20">
				<button class="btn btn-green add-row" onClick="ajout()">
					Ajouter Rubrique <i class="fa fa-plus"></i>
				</button>
			</div>
		</div>
	<% 
		HttpSession s = request.getSession();
   List<Rubrique> l;
       l=(List <Rubrique>)s.getAttribute("listRubrique");
		  int cmt=0;
		%>
	<script>


var compt=0;

function ajout(){
var i=0;
compt++;
var tab= new Array();
tab[0]="Faites votre choix";
<% 
cmt++;
for(Rubrique r:l)
{
	System.out.println("byazhdjazvjdzad"+cmt);%>
	i++;
	tab[i]='<%= r.getNomRubrique()%>';
	<%
}
s.setAttribute("UHU",cmt);

%>


console.log(tab[0]);
console.log("aaaaa"+compt);
var page = document.getElementById("idPage");
var newlab=document.createElement("Label");
newlab.innerText="Selectionner une rubrique";
page.appendChild(newlab);

document.getElementById("idPage").innerHTML+='<br>';

		var elSelect = document.createElement("select");
		elSelect.classList.add("form-control");
		elSelect.style.width="50%";
		elSelect.name = "selectMaster"+compt;
		page.appendChild(elSelect);	
		var elOption = new Array();
		for(i=0;i<tab.length;i++)
		{
			console.log(tab[i]);
          elOption.push(  new Option(tab[i], ""+tab[i], false, false));
		}
		
		for (i=0;i<elOption.length;i++)
        {
          elSelect.appendChild(elOption[i]);
        }
		document.getElementById("idPage").innerHTML+='<br>';
		var newlab=document.createElement("Label");
		newlab.innerText="Ajouter une rubrique";
		page.appendChild(newlab);
		 document.getElementById("idPage").innerHTML+='<br>';
        var Q = document.createElement("input");
        Q.classList.add("form-control");
        Q.style.width="50%";
		Q.name = "nomRubrique"+compt;
		page.appendChild(Q);	

       
} 

</script>

</body>
</html>