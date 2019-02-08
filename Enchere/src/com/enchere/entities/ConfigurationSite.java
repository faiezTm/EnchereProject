package com.enchere.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ConfigurationSite")
public class ConfigurationSite {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="id_seq")
	@SequenceGenerator(name="id_seq",sequenceName="id_seq", allocationSize=1)
	private int idConfig;
	
	@Column(name="nomSite")
	private String nomSite;
	
	@Column(name="nbrArticleApparaitALaUne")
	private int nbrArticleApparaitALaUne;
	
	@Column(name="tarifAffichALaune")
	private float tarifAffichALaune;
	
	@Column(name="delaiConfirmInscrit")
	private int delaiConfirmInscrit;
	
	@Column(name="tauxCommission")
	private float tauxCommission;
	
	@Column(name="reglementsDestVendeurs")
	private float reglementsDestVendeurs;
	
	@Column(name="reglementsAcheteurs")
	private float reglementsAcheteurs;

	public int getIdConfig() {
		return idConfig;
	}

	public void setIdConfig(int idConfig) {
		this.idConfig = idConfig;
	}

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public int getNbrArticleApparaitALaUne() {
		return nbrArticleApparaitALaUne;
	}

	public void setNbrArticleApparaitALaUne(int nbrArticleApparaitALaUne) {
		this.nbrArticleApparaitALaUne = nbrArticleApparaitALaUne;
	}

	public float getTarifAffichALaune() {
		return tarifAffichALaune;
	}

	public void setTarifAffichALaune(float tarifAffichALaune) {
		this.tarifAffichALaune = tarifAffichALaune;
	}

	public float getTauxCommission() {
		return tauxCommission;
	}

	public void setTauxCommission(float tauxCommission) {
		this.tauxCommission = tauxCommission;
	}

	public float getReglementsDestVendeurs() {
		return reglementsDestVendeurs;
	}

	public void setReglementsDestVendeurs(float reglementsDestVendeurs) {
		this.reglementsDestVendeurs = reglementsDestVendeurs;
	}

	public float getReglementsAcheteurs() {
		return reglementsAcheteurs;
	}

	public void setReglementsAcheteurs(float reglementsAcheteurs) {
		this.reglementsAcheteurs = reglementsAcheteurs;
	}

	public ConfigurationSite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConfigurationSite(String nomSite, int nbrArticleApparaitALaUne, float tarifAffichALaune,
			int delaiConfirmInscrit, float tauxCommission, float reglementsDestVendeurs, float reglementsAcheteurs) {
		super();
		this.nomSite = nomSite;
		this.nbrArticleApparaitALaUne = nbrArticleApparaitALaUne;
		this.tarifAffichALaune = tarifAffichALaune;
		this.delaiConfirmInscrit = delaiConfirmInscrit;
		this.tauxCommission = tauxCommission;
		this.reglementsDestVendeurs = reglementsDestVendeurs;
		this.reglementsAcheteurs = reglementsAcheteurs;
	}
	
	

}
