package com.enchere.webServices;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.enchere.dao.RubriqueDao;
import com.enchere.utils.JsonConverter;
@Path("/rubriques")
public class RubriqueServices {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getRubriques() {
		
		List<com.enchere.entities.Rubrique> listRubriques = RubriqueDao.getRubriques();
        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(listRubriques);
        
	   return output;  
	}
}
