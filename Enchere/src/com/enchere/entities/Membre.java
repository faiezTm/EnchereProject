package com.enchere.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idMembre")
public class Membre extends Utilisateur {

	public Membre( String nom, String prenom, String email, String adresse, int codePostal,
			int numCatreCredit, String login, String motDePasse, byte[] photo,Date dateInscription) {
		super( nom, prenom, email, adresse, codePostal, numCatreCredit, login, motDePasse, photo);
		// TODO Auto-generated constructor stub
		this.dateInscription=dateInscription;
	}
	private Date dateInscription;
	
	public Date getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	public Membre() {
		
	}
	


	

}
