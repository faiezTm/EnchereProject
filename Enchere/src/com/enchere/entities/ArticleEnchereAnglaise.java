package com.enchere.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;

@Entity
@PrimaryKeyJoinColumn(name = "idArticleEnchereAnglaise")
public class ArticleEnchereAnglaise extends Article{
	
	
	public ArticleEnchereAnglaise(String descrption, Date dateDebut, Date dateFin, double prixInit, String lieu,
			String pays, String region, double prixReserve, byte[] photo, boolean visibiliteReserve,
			String definitionArt, String typeEnchere, double incrementValue) {
		super(descrption, dateDebut, dateFin, prixInit, lieu, pays, region, prixReserve, photo, visibiliteReserve,
				definitionArt, typeEnchere);
		this.incrementValue = incrementValue;
	}
	
	private double incrementValue;
	
	
	public double getIncrementValue() {
		return incrementValue;
	}

	public void setIncrementValue(double incrementValue) {
		this.incrementValue = incrementValue;
	}
}