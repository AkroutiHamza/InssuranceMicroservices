package org.cat.europe.bulletin.domain;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class BulletinDeSoin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long bulletin_id;
	private Date date_bulletin;
	private Date date_prise_charge;
	private Date date_validation;
	private Blob lettre_liaison;
	private double montant;
	@Transient
	private String reference;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "bulletinDeSoin")
	protected Collection<ActeMedicale> acteMedicale;

	public void add(ActeMedicale a) {
		add(a);
	}

	public Long getBulletin_id() {
		return bulletin_id;
	}

	public void setBulletin_id(Long bulletin_id) {
		this.bulletin_id = bulletin_id;
	}

	public Date getDate_bulletin() {
		return date_bulletin;
	}

	public void setDate_bulletin(Date date_bulletin) {
		this.date_bulletin = date_bulletin;
	}

	public Date getDate_prise_charge() {
		return date_prise_charge;
	}

	public void setDate_prise_charge(Date date_prise_charge) {
		this.date_prise_charge = date_prise_charge;
	}

	public Date getDate_validation() {
		return date_validation;
	}

	public void setDate_validation(Date date_validation) {
		this.date_validation = date_validation;
	}

	public Blob getLettre_liaison() {
		return lettre_liaison;
	}

	public void setLettre_liaison(Blob lettre_liaison) {
		this.lettre_liaison = lettre_liaison;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Collection<ActeMedicale> getActeMedicale() {
		return acteMedicale;
	}

	public void setActeMedicale(Collection<ActeMedicale> acteMedicale) {
		this.acteMedicale = acteMedicale;
	}

	public BulletinDeSoin(Long bulletin_id, Date date_bulletin, Date date_prise_charge, Date date_validation,
			Blob lettre_liaison, double montant, String reference, Collection<ActeMedicale> acteMedicale) {
		super();
		this.bulletin_id = bulletin_id;
		this.date_bulletin = date_bulletin;
		this.date_prise_charge = date_prise_charge;
		this.date_validation = date_validation;
		this.lettre_liaison = lettre_liaison;
		this.montant = montant;
		this.reference = reference;
		this.acteMedicale = acteMedicale;
	}

	public BulletinDeSoin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
