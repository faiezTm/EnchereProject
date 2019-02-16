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

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.enchere.dao.ConfigDao;
import com.enchere.dao.RubriqueDao;
import com.enchere.entities.ConfigurationSite;
import com.enchere.entities.Rubrique;

/**
 * Servlet implementation class TestRubrique
 */
@WebServlet("/TestRubrique")
public class Config extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int comptRubrique = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Config() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		 * ServletContext application = getServletContext(); HttpSession session =
		 * request.getSession(); Rubrique masterRubrique=new Rubrique("véhicule");
		 * Rubrique rubrique=new Rubrique("moto");
		 * rubrique.setMasterRubrique(masterRubrique);
		 * RubriqueDao.insertRubrqiue(rubrique);
		 */

		/*
		 * ServletContext application = getServletContext(); HttpSession session =
		 * request.getSession(); List <Rubrique> listRubrique=
		 * RubriqueDao.getRubriques();
		 * System.out.println("aaaaaaaaaaaaaaaaaaaaaaa"+listRubrique.get(0));
		 * 
		 * 
		 * session.setAttribute("listRubrique", listRubrique);
		 * response.sendRedirect("JSP/Configuration.jsp");
		 */

		/*
		 * Rubrique rubrique=new Rubrique("chaussure");
		 * RubriqueDao.insertRubrqiue(rubrique,31);
		 */

		/*
		 * Rubrique rubrique=new Rubrique("moto"); RubriqueDao.insertRubrqiue(rubrique);
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		session.removeAttribute("errorChamp");
 		
		if (request.getParameter("nomSite").equals("")||request.getParameter("nbrArticleApparaitALaUne").equals("") || request.getParameter("tarifAffichALaune").equals("") || request.getParameter("delaiConfirmInscrit").equals("")||request.getParameter("tauxCommission").equals("")||request.getParameter("reglementsDestVendeurs").equals("")||request.getParameter("reglementsAcheteurs").equals(""))
		{
			 session.setAttribute("nomSite", request.getParameter("nomSite"));
			 session.setAttribute("nbrArticleApparaitALaUne", request.getParameter("nbrArticleApparaitALaUne"));
			 session.setAttribute("tarifAffichALaune", request.getParameter("tarifAffichALaune"));
			 session.setAttribute("delaiConfirmInscrit",request.getParameter("delaiConfirmInscrit"));
			 session.setAttribute("tauxCommission", request.getParameter("tauxCommission"));
			 session.setAttribute("reglementsDestVendeurs", request.getParameter("reglementsDestVendeurs"));
			 session.setAttribute("reglementsAcheteurs",request.getParameter("reglementsAcheteurs"));
			 session.setAttribute("errorChamp","il aux saisir tous les champs");
			 response.sendRedirect("JSP/ConfigFile.jsp");
		}
		else
		{
			
				String nomSite=request.getParameter("nomSite");
				int nbrArticleApparaitALaUne=Integer.parseInt( request.getParameter("nbrArticleApparaitALaUne"));
				float tarifAffichALaune=Float.parseFloat(request.getParameter("tarifAffichALaune")) ;
				int delaiConfirmInscrit=Integer.parseInt(request.getParameter("delaiConfirmInscrit"));
				float tauxCommission=Float.parseFloat( request.getParameter("tauxCommission"));
				float reglementsDestVendeurs=Float.parseFloat(request.getParameter("reglementsDestVendeurs"));
				float reglementsAcheteurs=Float.parseFloat(request.getParameter("reglementsAcheteurs"));
		 		
			ConfigurationSite config= new ConfigurationSite(nomSite, nbrArticleApparaitALaUne, tarifAffichALaune, delaiConfirmInscrit, tauxCommission, reglementsDestVendeurs, reglementsAcheteurs);
			ConfigDao.insertConfig(config);
		}
		int idMaster = 0;
		for (int i = 0; i < 30; i++) {


			if (request.getParameter("nomRubrique" + i) == null || request.getParameter("nomRubrique" + i).equals(""))
				break;

			String master = request.getParameter("selectMaster" + i);
			String nomRubrique = request.getParameter("nomRubrique" + i);
			Rubrique nouvRubrqiue = new Rubrique(nomRubrique);
			if (master.equals("aucune")) {

				RubriqueDao.insertRubrqiue(nouvRubrqiue, -1);
			} else {
				List<Rubrique> listRubrique = (List<Rubrique>) session.getAttribute("listRubrique");
				for (Rubrique r : listRubrique) {
					if (r.getNomRubrique().equals(master)) {
						idMaster = r.getIdRubrique();
						break;
					}
				}
				
				 RubriqueDao.insertRubrqiue(nouvRubrqiue, idMaster);

			}
		

		}

	}

}
