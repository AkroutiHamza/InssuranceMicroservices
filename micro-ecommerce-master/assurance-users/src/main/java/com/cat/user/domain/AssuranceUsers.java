package com.cat.user.domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_USER", discriminatorType = DiscriminatorType.STRING, length = 4)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(name = "Employe", value = AssuranceEmploye.class),
		@Type(name = "Cnam", value = AssurancePersonnelCNAM.class),
		@Type(name = "Societe", value = AssurancePersonnelSociete.class) })
public class AssuranceUsers  implements Serializable{

	@Id

	private Long user_id;
	private String login;
	private String password;
	private String nom;
	private String prenom;
	private int tel;
	private Date date_naissance;
	
	private Character sexe;
	private String email;

	AssuranceEtatCivil assuranceEtatCivil;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	

	public char getSexe() {
		return sexe;
	}

	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AssuranceEtatCivil getAssuranceEtatCivil() {
		return assuranceEtatCivil;
	}

	public void setAssuranceEtatCivil(AssuranceEtatCivil assuranceEtatCivil) {
		this.assuranceEtatCivil = assuranceEtatCivil;
	}

	

	public AssuranceUsers(Long user_id, String login, String password, String nom, String prenom, int tel,
			Date date_naissance, Character sexe, String email, AssuranceEtatCivil assuranceEtatCivil) {
		super();
		this.user_id = user_id;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.date_naissance = date_naissance;
		this.sexe = sexe;
		this.email = email;
		this.assuranceEtatCivil = assuranceEtatCivil;
	}

	public AssuranceUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

}
