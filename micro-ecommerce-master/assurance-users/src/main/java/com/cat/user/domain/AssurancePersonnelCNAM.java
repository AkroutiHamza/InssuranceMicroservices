package com.cat.user.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Cnam")
public class AssurancePersonnelCNAM extends AssuranceUsers {

	private Date date_execution;

	public Date getDate_execution() {
		return date_execution;
	}

	public void setDate_execution(Date date_execution) {
		this.date_execution = date_execution;
	}

	public AssurancePersonnelCNAM() {
		super();
	}

	public AssurancePersonnelCNAM(Long user_id, String login, String password, String nom, String prenom, int tel,
			Date date_naissance, char sexe, String email, AssuranceEtatCivil assuranceEtatCivil) {
		super(user_id, login, password, nom, prenom, tel, date_naissance, sexe, email, assuranceEtatCivil);
		// TODO Auto-generated constructor stub
	}

	public AssurancePersonnelCNAM(Long user_id, String login, String password, String nom, String prenom, int tel,
			Date date_naissance, char sexe, String email, AssuranceEtatCivil assuranceEtatCivil, Date date_execution) {
		super(user_id, login, password, nom, prenom, tel, date_naissance, sexe, email, assuranceEtatCivil);
		this.date_execution = date_execution;
	}

	

}
