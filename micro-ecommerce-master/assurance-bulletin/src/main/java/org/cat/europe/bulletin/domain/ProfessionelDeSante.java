package org.cat.europe.bulletin.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProfessionelDeSante implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long professionnel_id;
	private String nom;
	private String adresse;
	private String email;
	private double montant;
	private int tel;

	Specialite specialite;
/*
	@ManyToOne
	@JoinColumn(name = "Code_Pro")
	protected ActeMedicale acteMedicale;

	@JsonIgnore
	public ActeMedicale getActeMedicale() {
		return acteMedicale;
	}

	public void setActeMedicale(ActeMedicale acteMedicale) {
		this.acteMedicale = acteMedicale;
	}
*/
	
	@ManyToMany(mappedBy = "professionelDeSantes")
	private Collection<ActeMedicale> acteMedicales;

	public Long getProfessionnel_id() {
		return professionnel_id;
	}

	public void setProfessionnel_id(Long professionnel_id) {
		this.professionnel_id = professionnel_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
@JsonIgnore
	public Collection<ActeMedicale> getActeMedicales() {
		return acteMedicales;
	}

	public void setActeMedicales(Collection<ActeMedicale> acteMedicales) {
		this.acteMedicales = acteMedicales;
	}

	public ProfessionelDeSante(Long professionnel_id, String nom, String adresse, String email, double montant, int tel,
			Specialite specialite, Collection<ActeMedicale> acteMedicales) {
		super();
		this.professionnel_id = professionnel_id;
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.montant = montant;
		this.tel = tel;
		this.specialite = specialite;
		this.acteMedicales = acteMedicales;
	}

	public ProfessionelDeSante() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProfessionelDeSante [professionnel_id=" + professionnel_id + ", nom=" + nom + ", adresse=" + adresse
				+ ", email=" + email + ", montant=" + montant + ", tel=" + tel + ", specialite=" + specialite
				+ ", acteMedicales=" + acteMedicales + "]";
	}

	
	
	
	
	

	

}
