package com.enchere.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.tomcat.util.codec.binary.Base64;

import com.enchere.dao.ArticleDao;
import com.enchere.entities.Article;
import com.enchere.entities.ArticleEnchereAnglaise;
import com.enchere.entities.ArticleEnchereHollandaise;
/**
 * Servlet implementation class Add
 */
@WebServlet("/AddArticle")
@MultipartConfig(maxFileSize = 1000*1024*1024,maxRequestSize = 2000*1024*1024,fileSizeThreshold = 20*1024*1024)
public class AddArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticle() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();

		//*********************************read data*************************************************
		String descrption = request.getParameter("description");

		String dateDebutString = request.getParameter("dateDebut");
		String dateFinString = request.getParameter("dateFin");
		
		String[] dateDebutTimeArray = dateDebutString.split("T");
		String[] dateFinTimeArray = dateFinString.split("T");
		
		String[] dateDebutArray = dateDebutTimeArray[0].split("-");
		String[] dateFinArray = dateFinTimeArray[0].split("-");
		String[] timteDateDebut = dateDebutTimeArray[1].split(":");
		String[] timteDateFin = dateFinTimeArray[1].split(":");
		
		int yearDateDebut = Integer.parseInt(dateDebutArray[0]);
		int monthDateDebut = Integer.parseInt(dateDebutArray[1]);
		int dayDateDebut = Integer.parseInt(dateDebutArray[2]);
		int heureDebut = Integer.parseInt(timteDateDebut[0]);
		int minuteDebut = Integer.parseInt(timteDateDebut[1]);
		
		int yearDateFin = Integer.parseInt(dateFinArray[0]);
		int monthDateFin = Integer.parseInt(dateFinArray[1]);
		int dayDateFin = Integer.parseInt(dateFinArray[2]);
		int heureFin = Integer.parseInt(timteDateFin[0]);
		int minuteFin = Integer.parseInt(timteDateFin[1]);
		
		Date dateDebut = new Date(yearDateDebut,monthDateDebut,dayDateDebut,heureDebut,minuteDebut);
		Date dateFin = new Date(yearDateFin,monthDateFin,dayDateFin,heureFin,minuteFin);
		
		double prixInit = Double.valueOf(request.getParameter("prixInit"));
		String lieu = request.getParameter("lieu");
		String pays = request.getParameter("pays");
		String region = request.getParameter("region");
		double prixReserve = Double.valueOf(request.getParameter("prixInit"));
		String img = request.getParameter("photo");
		byte[] photo64 = Base64.encodeBase64(img.getBytes());
		Blob photo = null;
		try {
			 photo = new SerialBlob(photo64);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		boolean visibiliteReserve = Boolean.parseBoolean(request.getParameter("visibiliteReserve"));
		String definitionArt = request.getParameter("definitionArt");
		String typeEnchere = request.getParameter("typeEnchere");
		//*******************************************************************************************
				
		if (typeEnchere.equals("anglaise")) {
			double incrementValue = Double.valueOf(request.getParameter("incrementValue"));
			ArticleEnchereAnglaise newArticleEnchereAnglaise = new ArticleEnchereAnglaise(descrption, dateDebut, dateFin, prixInit, lieu, pays, region, prixReserve, photo, visibiliteReserve, definitionArt, typeEnchere, incrementValue);
			ArticleDao.insertArticleEnchereAnglaise(newArticleEnchereAnglaise);
			List<ArticleEnchereAnglaise> listArticleEnchereAnglaise = (List<ArticleEnchereAnglaise>)session.getAttribute("listArticleEnchereAnglaise");
			
			if (listArticleEnchereAnglaise == null) {
				listArticleEnchereAnglaise = new  ArrayList<ArticleEnchereAnglaise>();
			}
			
			listArticleEnchereAnglaise.add(newArticleEnchereAnglaise);
			session.setAttribute("listArticleEnchereAnglaise", ArticleDao.getAllArticlesEnchereAnglaise());
		}
		else if (typeEnchere.equals("hollandaise")) {
			int qteArticle = Integer.valueOf(request.getParameter("qteArticle"));
			ArticleEnchereHollandaise newArticleEnchereHollandaise = new ArticleEnchereHollandaise(descrption, dateDebut, dateFin, prixInit, lieu, pays, region, prixReserve, photo, visibiliteReserve, definitionArt, typeEnchere, qteArticle);
			ArticleDao.insertArticleEnchereHollandaise(newArticleEnchereHollandaise);
			session.setAttribute("listArticleEnchereHollandaise", ArticleDao.getAllArticlesEnchereHollandaise());
		}
		
		response.sendRedirect("JSP/Vendre.jsp");
	}

}
