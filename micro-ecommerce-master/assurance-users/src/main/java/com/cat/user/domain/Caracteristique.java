package com.cat.user.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

@Entity
public class Caracteristique implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id_caracteristique;
	Poste poste;
	private double plafond;

	@OneToMany(mappedBy = "caracteristique")
	private Collection<AssuranceEmploye> assuranceEmployes;

	public Long getId_caracteristique() {
		return id_caracteristique;
	}

	public void setId_caracteristique(Long id_caracteristique) {
		this.id_caracteristique = id_caracteristique;
	}

	

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public double getPlafond() {
		return plafond;
	}

	public void setPlafond(double plafond) {
		this.plafond = plafond;
	}

	public Collection<AssuranceEmploye> getAssuranceEmployes() {
		return assuranceEmployes;
	}

	public void setAssuranceEmployes(Collection<AssuranceEmploye> assuranceEmployes) {
		this.assuranceEmployes = assuranceEmployes;
	}

	

	public Caracteristique(Long id_caracteristique, Poste poste, double plafond,
			Collection<AssuranceEmploye> assuranceEmployes) {
		super();
		this.id_caracteristique = id_caracteristique;
		this.poste = poste;
		this.plafond = plafond;
		this.assuranceEmployes = assuranceEmployes;
	}

	public Caracteristique() {
		super();
	}

}
