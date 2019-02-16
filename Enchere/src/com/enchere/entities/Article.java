package com.enchere.entities;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="id_seq")
	@SequenceGenerator(name="id_seq",sequenceName="id_seq", allocationSize=1)
	protected int idArticle;
	protected String description;
	protected Date dateDebut;
	protected Date dateFin;
	protected double prixInit;
	protected String lieu;
	protected String pays;
	protected String region;
	protected double prixReserve;
	@Lob
	protected Blob photo;
	
	protected boolean visibiliteReserve;
	protected String definitionArt;
	protected String typeEnchere;
	
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescrption(String descrption) {
		this.description = descrption;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public double getPrixInit() {
		return prixInit;
	}
	public void setPrixInit(double prixInit) {
		this.prixInit = prixInit;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public double getPrixReserve() {
		return prixReserve;
	}
	public void setPrixReserve(double prixReserve) {
		this.prixReserve = prixReserve;
	}
	
	
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public boolean isVisibiliteReserve() {
		return visibiliteReserve;
	}
	public void setVisibiliteReserve(boolean visibiliteReserve) {
		this.visibiliteReserve = visibiliteReserve;
	}
	public String getDefinitionArt() {
		return definitionArt;
	}
	public void setDefinitionArt(String definitionArt) {
		this.definitionArt = definitionArt;
	}
	public String getTypeEnchere() {
		return typeEnchere;
	}
	public void setTypeEnchere(String typeEnchere) {
		this.typeEnchere = typeEnchere;
	}
	public Article(String descrption, Date dateDebut, Date dateFin, double prixInit, String lieu,
			String pays, String region, double prixReserve, Blob photo, boolean visibiliteReserve,
			String definitionArt, String typeEnchere) {
		super();
		this.idArticle = idArticle;
		this.description = descrption;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixInit = prixInit;
		this.lieu = lieu;
		this.pays = pays;
		this.region = region;
		this.prixReserve = prixReserve;
		this.photo = photo;
		this.visibiliteReserve = visibiliteReserve;
		this.definitionArt = definitionArt;
		this.typeEnchere = typeEnchere;
	}
	
	public Article() {
		
	}
}
