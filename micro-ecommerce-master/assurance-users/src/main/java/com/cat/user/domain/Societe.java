package com.cat.user.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Societe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id_societe;
	private String nom;
	private String adresse;
	private String pays;
	private int tel;
	private int fax;
	private Date date_creation;

	@OneToMany(mappedBy = "societe")
	private Collection<AssuranceEmploye> assuranceEmploye;

	public Societe(Collection<AssuranceEmploye> assuranceEmploye) {
		super();
		this.assuranceEmploye = assuranceEmploye;
	}

	public Collection<AssuranceEmploye> getAssuranceEmploye() {
		return assuranceEmploye;
	}

	public void setAssuranceEmploye(Collection<AssuranceEmploye> assuranceEmploye) {
		this.assuranceEmploye = assuranceEmploye;
	}

	public Long getId_societe() {
		return id_societe;
	}

	public void setId_societe(Long id_societe) {
		this.id_societe = id_societe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getFax() {
		return fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Societe(Long id_societe, String nom, String adresse, String pays, int tel, int fax, Date date_creation) {
		super();
		this.id_societe = id_societe;
		this.nom = nom;
		this.adresse = adresse;
		this.pays = pays;
		this.tel = tel;
		this.fax = fax;
		this.date_creation = date_creation;

	}

	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}

}
