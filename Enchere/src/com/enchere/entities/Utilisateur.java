package com.enchere.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="id_seq")
	@SequenceGenerator(name="id_seq",sequenceName="id_seq", allocationSize=1)
	protected int idUtilisateur;
	
	protected String nom;
	protected String prenom;
	protected String email;
	protected String adresse;
	protected int codePostal;
	protected int numCatreCredit;
	protected String login;
	protected String motDePasse;
	protected byte[] photo;
	protected String role;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public int getNumCatreCredit() {
		return numCatreCredit;
	}
	public void setNumCatreCredit(int numCatreCredit) {
		this.numCatreCredit = numCatreCredit;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public Utilisateur( String nom, String prenom, String email, String adresse, int codePostal,
			int numCatreCredit, String login, String motDePasse, byte[] photo) {
		super();
	
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.numCatreCredit = numCatreCredit;
		this.login = login;
		this.motDePasse = motDePasse;
		this.photo = photo;
		this.role="membre";
	}
	public Utilisateur() {
		super();
	}
	

}
