package com.enchere.controller;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
		/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();*/
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		while ((line = reader.readLine()) != null) {
		    System.out.println(line);

		}
		
		/*
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		session.removeAttribute("errorMotDePasse");
		String motDePasse=request.getParameter("motDePasse");
		String motDePasse2=request.getParameter("motDePasse2");
		String login=request.getParameter("login");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		String adresse=request.getParameter("adresse");
		String photo=request.getParameter("photo");
		File f=new File(photo);
		ByteArrayOutputStream byteOut= new ByteArrayOutputStream();
		//ByteArrayOutputStream byteOut=request.getParameter("photo").;
		//byte[] tabByte=request.getParameter("photo").getBytes();
		//System.out.println(tabByte);
	
	
	
		
	
	if(!motDePasse.equals(motDePasse2)) {
		List <String> list= new ArrayList<String>();
		list.add(nom);
		list.add(prenom);
		list.add(email);
		list.add(adresse);
		list.add(request.getParameter("codePostal"));
		list.add(request.getParameter("numCarteCredit"));
		list.add(login);
		list.add(motDePasse);
		list.add(motDePasse2);
		
		session.setAttribute("listParam", list);
		
		session.setAttribute("errorMotDePasse", " les 2 mots de passes ne sont pas identiques");
		response.sendRedirect("JSP/Inscription.jsp");
		
          
	}else {
	
		try {
			
			int codePostal=Integer.parseInt(request.getParameter("codePostal"));
			int numCarteCredit=Integer.parseInt(request.getParameter("numCarteCredit"));
			
			
		Membre m=new Membre(nom, prenom, email, adresse, codePostal, numCarteCredit, login, motDePasse2, null, null);
		UtilisateurDao.insertMembre(m);
		response.sendRedirect("JSP/BienvenueMembre.jsp");
		}catch(Exception e){response.sendRedirect("JSP/Inscription.jsp");}
		
	}*/
		
/*
		Membre membre=new Membre( "faiez", null, null, null, 0, 0, "faiez", "ff", null, null);
		
		UtilisateurDao.insertMembre(membre);
		*/
	}

}
