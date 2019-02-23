package com.enchere.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enchere.dao.EnchereDao;
import com.enchere.entities.Article;
import com.enchere.entities.ArticleEnchereHollandaise;
import com.enchere.entities.Encherir;
import com.enchere.entities.Membre;

/**
 * Servlet implementation class TestEncherir
 */
@WebServlet("/TestEncherir")
public class TestEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestEncherir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg;
		boolean PrixCorrect=true;
		boolean QuantiteCorrect=true;
		
		HttpSession session=request.getSession();
		Membre user= (Membre)session.getAttribute("user");
		ArticleEnchereHollandaise art=(ArticleEnchereHollandaise) session.getAttribute("art");
		//il manque id du vendeur
		int Qt= Integer.parseInt( request.getParameter("quantite"));
		double prix=Double.parseDouble(request.getParameter("prix"));
		Date d =  new java.sql.Date(Calendar.getInstance().getTime().getTime());
		if(art.getPrixInit()>=prix)
		{
			PrixCorrect=false;
		}
		if (art.getQteArticle()<Qt)
		{
			QuantiteCorrect=false;
		}
		Encherir e=EnchereDao.insertRubrqiue(user, art);
		System.out.println(e.getIdEnchere());
		
		/*
		Encherir ench =new Encherir(art, user, d, prix, Qt);
		EnchereDao.insertEnchere(ench);
		*/
		
	//	if(request.getMethod()=="GET")
		/*
		Encherir ench =new Encherir(0, art, user, null, 0, 0);
		EnchereDao.insertEnchere(ench);*/
	}

}
