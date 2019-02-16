package com.enchere.entities;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idArticleEnchereAnglaise")
public class ArticleEnchereHollandaise extends Article{
	
	private int qteArticle;
	
	public ArticleEnchereHollandaise()
	{
		super();
	}
	
	public ArticleEnchereHollandaise(String descrption, Date dateDebut, Date dateFin, double prixInit, String lieu,
			String pays, String region, double prixReserve, Blob photo, boolean visibiliteReserve,
			String definitionArt, String typeEnchere, int qteArticle) {
		super(descrption, dateDebut, dateFin, prixInit, lieu, pays, region, prixReserve, photo, visibiliteReserve,
				definitionArt, typeEnchere);
		this.qteArticle = qteArticle;
	}
	
	public int getQteArticle() {
		return qteArticle;
	}
	public void setQteArticle(int qteArticle) {
		this.qteArticle = qteArticle;
	}
	
	
}
