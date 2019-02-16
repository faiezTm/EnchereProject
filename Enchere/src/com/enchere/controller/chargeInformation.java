package com.enchere.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enchere.dao.RubriqueDao;
import com.enchere.entities.Rubrique;

/**
 * Servlet implementation class chargeInformation
 */
@WebServlet("/chargeInformation")
public class chargeInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chargeInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
	List <Rubrique> listRubrique=	RubriqueDao.getRubriques();
	List <Rubrique> listFils= new ArrayList<Rubrique>();
	session.setAttribute("listRubrique", listRubrique);
	for (Rubrique rubrique : listRubrique) {
		if (rubrique.getMasterRubrique()!=null)
			listFils.add(rubrique);
		
	}
	session.setAttribute("listFils", listFils);
	
	/*for (Rubrique r : listRubrique) {
		if((r.getMasterRubrique())==null) {
		  System.out.println(r.getNomRubrique()+"master");	
		}
		else
		{
			  System.out.println(r.getNomRubrique()+"fils de"+(r.getMasterRubrique()).getNomRubrique());
		}
	}*/
	response.sendRedirect("JSP/index.jsp");
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
