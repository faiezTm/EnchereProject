package com.enchere.webServices;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("restservices")
public class ApplicationInitializer extends ResourceConfig{
	public ApplicationInitializer() {
        packages("com.enchere.webServices");
    }
}
