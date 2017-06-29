package org.cat.europe.bulletin.domain;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ArticleMedicale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long article_id;

	private String libelle;
	private Blob description;
	private double prix;
	private double quantite;
/*
	@ManyToOne
	@JoinColumn(name = "Code_ar")
	protected ActeMedicale acteMedicale;
*/
	@ManyToMany(mappedBy = "articleMedicale")
	private Collection<ActeMedicale> acteMedicales;
	public Long getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Long article_id) {
		this.article_id = article_id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Blob getDescription() {
		return description;
	}
	public void setDescription(Blob description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	@JsonIgnore
	public Collection<ActeMedicale> getActeMedicales() {
		return acteMedicales;
	}
	public void setActeMedicales(Collection<ActeMedicale> acteMedicales) {
		this.acteMedicales = acteMedicales;
	}
	public ArticleMedicale(Long article_id, String libelle, Blob description, double prix, double quantite,
			Collection<ActeMedicale> acteMedicales) {
		super();
		this.article_id = article_id;
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.acteMedicales = acteMedicales;
	}
	public ArticleMedicale() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
