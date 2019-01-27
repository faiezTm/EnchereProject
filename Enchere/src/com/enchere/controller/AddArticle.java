package com.enchere.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enchere.dao.ArticleDao;
import com.enchere.entities.Article;
import com.enchere.entities.ArticleEnchereAnglaise;
import com.enchere.entities.ArticleEnchereHollandaise;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class AddArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		
		//*********************************read data*************************************************
		/*String descrption = request.getParameter("descrption");

		String dateDebutString = request.getParameter("dateDebut");
		String dateFinString = request.getParameter("dateFin");
		
		String[] dateDebutArray = dateDebutString.split("-");
		String[] dateFinArray = dateFinString.split("-");
		
		int yearDateDebut = Integer.parseInt(dateDebutArray[2]);
		int monthDateDebut = Integer.parseInt(dateDebutArray[1]);
		int dayDateDebut = Integer.parseInt(dateDebutArray[0]);
		
		int yearDateFin = Integer.parseInt(dateFinArray[2]);
		int monthDateFin = Integer.parseInt(dateFinArray[1]);
		int dayDateFin = Integer.parseInt(dateFinArray[0]);
		
		Date dateDebut = new Date(yearDateDebut,monthDateDebut,dayDateDebut,0,0);
		Date dateFin = new Date(yearDateFin,monthDateFin,dayDateFin,0,0);
		double prixInit = Double.valueOf(request.getParameter("prixInit"));
		String lieu = request.getParameter("lieu");
		String pays = request.getParameter("pays");
		String region = request.getParameter("region");
		double prixReserve = Double.valueOf(request.getParameter("prixInit"));
		byte[] photo = request.getParameter("photo").getBytes();
		boolean visibiliteReserve = Boolean.parseBoolean(request.getParameter("visibiliteReserve"));
		String definitionArt = request.getParameter("definitionArt");
		String typeEnchere = request.getParameter("typeEnchere");*/
		//*******************************************************************************************
		String descrption = "rrrrr";
		String dateDebutString = "25-01-2019";
		String dateFinString = "25-01-2019";
		
		String[] dateDebutArray = dateDebutString.split("-");
		String[] dateFinArray = dateFinString.split("-");
		
		int yearDateDebut = Integer.parseInt(dateDebutArray[2]);
		int monthDateDebut = Integer.parseInt(dateDebutArray[1]);
		int dayDateDebut = Integer.parseInt(dateDebutArray[0]);
		
		int yearDateFin = Integer.parseInt(dateFinArray[2]);
		int monthDateFin = Integer.parseInt(dateFinArray[1]);
		int dayDateFin = Integer.parseInt(dateFinArray[0]);
		
		Date dateDebut = new Date(yearDateDebut,monthDateDebut,dayDateDebut,0,0);
		Date dateFin = new Date(yearDateFin,monthDateFin,dayDateFin,0,0);

		double prixInit = Double.valueOf("10.5");
		String lieu = "rtrtrt";
		String pays = "rrrr";
		String region = "ttttt";
		double prixReserve = Double.valueOf("25.6");
		byte[] photo = null;
		boolean visibiliteReserve = Boolean.parseBoolean("true");
		String definitionArt = "tttttt";
		String typeEnchere = "hollandaise";
		
		if (typeEnchere.equals("anglaise")) {
			double incrementValue = Double.valueOf("12.3");
			ArticleEnchereAnglaise newArticleEnchereAnglaise = new ArticleEnchereAnglaise(descrption, dateDebut, dateFin, prixInit, lieu, pays, region, prixReserve, photo, visibiliteReserve, definitionArt, typeEnchere, incrementValue);
			ArticleDao.insertArticleEnchereAnglaise(newArticleEnchereAnglaise);
		}
		else if (typeEnchere.equals("hollandaise")) {
			int qteArticle = Integer.valueOf("888");
			ArticleEnchereHollandaise newArticleEnchereHollandaise = new ArticleEnchereHollandaise(descrption, dateDebut, dateFin, prixInit, lieu, pays, region, prixReserve, photo, visibiliteReserve, definitionArt, typeEnchere, qteArticle);
			ArticleDao.insertArticleEnchereHollandaise(newArticleEnchereHollandaise);
		}
		/*
		if (typeEnchere.equals("anglaise")) {
			double incrementValue = Double.valueOf(request.getParameter("incrementValue"));
			ArticleEnchereAnglaise newArticleEnchereAnglaise = new ArticleEnchereAnglaise(descrption, dateDebut, dateFin, prixInit, lieu, pays, region, prixReserve, photo, visibiliteReserve, definitionArt, typeEnchere, incrementValue);
			ArticleDao.insertArticleEnchereAnglaise(newArticleEnchereAnglaise);
		}
		else if (typeEnchere.equals("hollandaise")) {
			int qteArticle = Integer.valueOf(request.getParameter("qteArticle"));
			ArticleEnchereHollandaise newArticleEnchereHollandaise = new ArticleEnchereHollandaise(descrption, dateDebut, dateFin, prixInit, lieu, pays, region, prixReserve, photo, visibiliteReserve, definitionArt, typeEnchere, qteArticle);
			ArticleDao.insertArticleEnchereHollandaise(newArticleEnchereHollandaise);
		}*/
	}

}
