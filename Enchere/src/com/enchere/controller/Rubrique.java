package com.enchere.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enchere.dao.RubriqueDao;
import com.enchere.entities.ArticleEnchereAnglaise;
import com.enchere.utils.JsonConverter;

/**
 * Servlet implementation class Rubrique
 */
@WebServlet("/Rubrique")
public class Rubrique extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rubrique() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("application/json;charset=UTF-8");

        ServletOutputStream out = response.getOutputStream();

        List<com.enchere.entities.Rubrique> listRubriques = RubriqueDao.getRubriques();
        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(listRubriques);

        out.print(output);
    }
}
