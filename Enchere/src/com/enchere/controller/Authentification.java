package com.enchere.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enchere.dao.UtilisateurDao;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		String login=request.getParameter("login");
		String MotDePasse=request.getParameter("password");
		
	boolean authentification=UtilisateurDao.authentification(login, MotDePasse);
	System.out.println(authentification);
	if(authentification) {
		session.removeAttribute("message");
	response.sendRedirect("JSP/Bienvenue.jsp");
	}
	else
	{ String message ="login ou pwd incorrect";
	session.setAttribute("message", message);
		response.sendRedirect("JSP/index.jsp");
	}
		
	}

}
