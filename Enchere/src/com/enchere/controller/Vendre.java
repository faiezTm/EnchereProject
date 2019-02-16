package com.enchere.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;

import com.enchere.dao.ArticleDao;
import com.enchere.entities.ArticleEnchereHollandaise;

/**
 * Servlet implementation class Vendre
 */
@WebServlet("/Vendre")
public class Vendre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Vendre() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		HttpSession session = request.getSession();
		ArrayList<String> imgDataArticleEnchereHollandaise = new ArrayList();
		byte[] img = null;
		Blob b = null;
		List<ArticleEnchereHollandaise> listArticleEnchereHollandaise = ArticleDao.getAllArticlesEnchereHollandaise();
		for (ArticleEnchereHollandaise articleEnchereHollandaise : listArticleEnchereHollandaise) {
			try {
				b = articleEnchereHollandaise.getPhoto();
				int blobLength = (int) b.length();
				img = b.getBytes(1,blobLength);
	            String base64Encoded = new String(Base64.decodeBase64(img));
				imgDataArticleEnchereHollandaise.add(base64Encoded);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		session.setAttribute("listArticleEnchereAnglaise", ArticleDao.getAllArticlesEnchereAnglaise());
		session.setAttribute("listArticleEnchereHollandaise", listArticleEnchereHollandaise);
		session.setAttribute("listImagesArticleEnchereHollandaise", imgDataArticleEnchereHollandaise);
		response.sendRedirect("JSP/Vendre.jsp");
		}
		catch (Exception e) {
			
		}
	}

}
