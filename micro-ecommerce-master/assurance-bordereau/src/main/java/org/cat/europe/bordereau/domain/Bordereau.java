package org.cat.europe.bordereau.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity

public class Bordereau implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bordereau_id;

	private String reference;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd:mm a z")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",locale = "en-EN" , timezone = "UTC")

	private Date date_bordereau;
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd:mm a z")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "en-EN", timezone = "UTC")

	
	private Date date_creation;
	private int nombre_piece;
	@Transient
	private double montant;

	public Long getBordereau_id() {
		return bordereau_id;
	}

	public void setBordereau_id(Long bordereau_id) {
		this.bordereau_id = bordereau_id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDate_bordereau() {
		return date_bordereau;
	}

	public void setDate_bordereau(Date date_bordereau) {
		this.date_bordereau = date_bordereau;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public int getNombre_piece() {
		return nombre_piece;
	}

	public void setNombre_piece(int nombre_piece) {
		this.nombre_piece = nombre_piece;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Bordereau(Long bordereau_id, String reference, Date date_bordereau, Date date_creation, int nombre_piece,
			double montant) {
		super();
		this.bordereau_id = bordereau_id;
		this.reference = reference;
		this.date_bordereau = date_bordereau;
		this.date_creation = date_creation;
		this.nombre_piece = nombre_piece;
		this.montant = montant;
	}

	public Bordereau() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bordereau [bordereau_id=" + bordereau_id + ", reference=" + reference + ", date_bordereau="
				+ date_bordereau + ", date_creation=" + date_creation + ", nombre_piece=" + nombre_piece + ", montant="
				+ montant + "]";
	}

}
