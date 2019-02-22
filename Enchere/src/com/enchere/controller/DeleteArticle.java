package com.enchere.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.tomcat.util.codec.binary.Base64;

import com.enchere.dao.ArticleDao;
import com.enchere.entities.ArticleEnchereAnglaise;
import com.enchere.entities.ArticleEnchereHollandaise;

/**
 * Servlet implementation class DeleteArticle
 */
@WebServlet("/DeleteArticle")
public class DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();

		//*********************************read data*************************************************
		String typeEnchere = request.getParameter("typeEnchere");
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		if (typeEnchere.equals("anglaise")) {
			ArticleDao.deleteArticleEnchereAnglaise(idArticle);
		}
		else if (typeEnchere.equals("hollandaise")) {
			ArticleDao.deleteArticleEnchereHollandaise(idArticle);
		}
		
		response.sendRedirect("JSP/Vendre.jsp");
	}

}
