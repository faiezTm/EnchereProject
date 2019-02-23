package com.enchere.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Encherir")
public class Encherir {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="id_seq")
	@SequenceGenerator(name="id_seq",sequenceName="id_seq", allocationSize=1)
	protected int idEnchere;
	@ManyToOne
	@JoinColumn(name="idArticle")
	public Article article;
	
	@ManyToOne
	@JoinColumn(name = "idMembre")
	public Membre m;
	
	private Date dateEncherir;
	private double prixActuel;
	private int QteArticle;
	public int getIdEnchere() {
		return idEnchere;
	}
	public void setIdEnchere(int idEnchere) {
		this.idEnchere = idEnchere;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Membre getM() {
		return m;
	}
	public void setM(Membre m) {
		this.m = m;
	}
	public Date getDateEncherir() {
		return dateEncherir;
	}
	public void setDateEncherir(Date dateEncherir) {
		this.dateEncherir = dateEncherir;
	}
	public double getPrixActuel() {
		return prixActuel;
	}
	public void setPrixActuel(double prixActuel) {
		this.prixActuel = prixActuel;
	}
	public int getQteArticle() {
		return QteArticle;
	}
	public void setQteArticle(int qteArticle) {
		QteArticle = qteArticle;
	}
	public Encherir( Article article, Membre m, Date dateEncherir, double prixActuel, int qteArticle) {
		super();
		
		this.article = article;
		this.m = m;
		this.dateEncherir = dateEncherir;
		this.prixActuel = prixActuel;
		QteArticle = qteArticle;
	}
	public Encherir( ) {
	
		
	
	}
	

}
