package com.enchere.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="Rubrique")
public class Rubrique {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="id_seq")
	@SequenceGenerator(name="id_seq",sequenceName="id_seq", allocationSize=1)
	private int idRubrique;
	
	public int getIdRubrique() {
		return idRubrique;
	}

	public void setIdRubrique(int idRubrique) {
		this.idRubrique = idRubrique;
	}

	@Column(name="nomRubrique")
	private String nomRubrique;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="masterRubrique_id")
	private Rubrique masterRubrique;
	
	
	@OneToMany(mappedBy="masterRubrique")
	private Set<Rubrique> subordinates = new HashSet<Rubrique>();
	
	public Rubrique() {
	}

	public Rubrique(String nomRubrique) {
		this.nomRubrique=nomRubrique;
	}
	
	

	
	public String getNomRubrique() {
		return nomRubrique;
	}

	public void setNomRubrique(String nomRubrique) {
		this.nomRubrique = nomRubrique;
	}

	public Rubrique getMasterRubrique() {
		return masterRubrique;
	}

	public void setMasterRubrique(Rubrique masterRubrique) {
		this.masterRubrique = masterRubrique;
	}


	
	

}
