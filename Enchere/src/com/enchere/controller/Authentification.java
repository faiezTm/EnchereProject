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
import com.enchere.entities.Utilisateur;

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
		Utilisateur authentificationUser=UtilisateurDao.authentification(login, MotDePasse);
		session.removeAttribute("message");
	if(authentificationUser!=null) {
		session.removeAttribute("message");
		if(authentificationUser.getRole().equals("membre"))
		{
	 response.sendRedirect("JSP/BienvenueMembre.jsp");
	 System.out.println(authentificationUser.getRole());
		}
		else
		{
			 System.out.println(authentificationUser.getRole());
		//	response.sendRedirect("JSP/BienvenueMembre.jsp");
		response.sendRedirect("JSP/BienvenueCommisseurVue.jsp");
		}
			
	}
	else if(authentificationUser==null)
	{
		String message ="login ou pwd incorrect";
	    session.setAttribute("message", message);
		response.sendRedirect("JSP/index.jsp");
	}
		
		
	}

}
