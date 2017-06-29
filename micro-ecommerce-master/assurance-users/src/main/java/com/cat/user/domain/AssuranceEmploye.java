package com.cat.user.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Employe")
public class AssuranceEmploye extends AssuranceUsers {
	private String matricule;
	private Date date_piece_identite;
	private String nationalite;
	private int nbr_personne_charge;
	private Date date_affiliation_caisse;

	@ManyToOne
	@JoinColumn(name = "CODE_Soc")
	private Societe societe;

	@ManyToOne
	@JoinColumn(name = "CODE_Car")
	private Caracteristique caracteristique;

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Date getDate_piece_identite() {
		return date_piece_identite;
	}

	public void setDate_piece_identite(Date date_piece_identite) {
		this.date_piece_identite = date_piece_identite;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public int getNbr_personne_charge() {
		return nbr_personne_charge;
	}

	public void setNbr_personne_charge(int nbr_personne_charge) {
		this.nbr_personne_charge = nbr_personne_charge;
	}

	public Date getDate_affiliation_caisse() {
		return date_affiliation_caisse;
	}

	public void setDate_affiliation_caisse(Date date_affiliation_caisse) {
		this.date_affiliation_caisse = date_affiliation_caisse;
	}

	public Caracteristique getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}



	public AssuranceEmploye(Long user_id, String login, String password, String nom, String prenom, int tel,
			Date date_naissance, char sexe, String email, AssuranceEtatCivil assuranceEtatCivil, String matricule,
			Date date_piece_identite, String nationalite, int nbr_personne_charge, Date date_affiliation_caisse,
			Societe societe, Caracteristique caracteristique) {
		super(user_id, login, password, nom, prenom, tel, date_naissance, sexe, email, assuranceEtatCivil);
		this.matricule = matricule;
		this.date_piece_identite = date_piece_identite;
		this.nationalite = nationalite;
		this.nbr_personne_charge = nbr_personne_charge;
		this.date_affiliation_caisse = date_affiliation_caisse;
		this.societe = societe;
		this.caracteristique = caracteristique;
	}

	public AssuranceEmploye(Long user_id, String login, String password, String nom, String prenom, int tel,
			Date date_naissance, char sexe, String email, AssuranceEtatCivil assuranceEtatCivil) {
		super(user_id, login, password, nom, prenom, tel, date_naissance, sexe, email, assuranceEtatCivil);
		// TODO Auto-generated constructor stub
	}

	public AssuranceEmploye() {
		super();
		// TODO Auto-generated constructor stub
	}

}
