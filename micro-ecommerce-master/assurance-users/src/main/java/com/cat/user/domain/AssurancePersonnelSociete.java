package com.cat.user.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Societe")
public class AssurancePersonnelSociete extends AssuranceUsers {

	private Date date_envoie;
	private Date date_recuperation;

	public Date getDate_envoie() {
		return date_envoie;
	}

	public void setDate_envoie(Date date_envoie) {
		this.date_envoie = date_envoie;
	}

	public Date getDate_recuperation() {
		return date_recuperation;
	}

	public void setDate_recuperation(Date date_recuperation) {
		this.date_recuperation = date_recuperation;
	}

	public AssurancePersonnelSociete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssurancePersonnelSociete(Long user_id, String login, String password, String nom, String prenom, int tel,
			Date date_naissance, char sexe, String email, AssuranceEtatCivil assuranceEtatCivil) {
		super(user_id, login, password, nom, prenom, tel, date_naissance, sexe, email, assuranceEtatCivil);
		// TODO Auto-generated constructor stub
	}

	public AssurancePersonnelSociete(Long user_id, String login, String password, String nom, String prenom, int tel,
			Date date_naissance, char sexe, String email, AssuranceEtatCivil assuranceEtatCivil, Date date_envoie,
			Date date_recuperation) {
		super(user_id, login, password, nom, prenom, tel, date_naissance, sexe, email, assuranceEtatCivil);
		this.date_envoie = date_envoie;
		this.date_recuperation = date_recuperation;
	}

	

}
