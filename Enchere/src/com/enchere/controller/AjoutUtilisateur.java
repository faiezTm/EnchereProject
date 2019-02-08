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
import com.enchere.entities.Membre;

/**
 * Servlet implementation class AjoutUtilisateur
 */
@WebServlet("/AjoutUtilisateur")
public class AjoutUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutUtilisateur() {
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
		Membre membre=new Membre( "faiez", null, null, null, 0, 0, "faiez", "ff", null, null);
		
		UtilisateurDao.insertMembre(membre);
	}

}
