package org.cat.europe.bulletin.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class ActeMedicale implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long acte_id;
	@Transient
	private String ref_professionel;
	@Transient
	private String ref_article;
	private double montant_totale;
/*
	@OneToMany(mappedBy = "acteMedicale")
	protected Collection<ArticleMedicale> articleMedicales;
*/
	@ManyToMany
	@JoinTable(name="Act_Arti",joinColumns=
	@JoinColumn(name="Code_ActeMe"),
	inverseJoinColumns = @JoinColumn(name="Code_Article"))
	private Collection<ArticleMedicale> articleMedicale; 

	
	@ManyToMany
	@JoinTable(name="Act_Pro",joinColumns=
	@JoinColumn(name="Code_ActeMed"),
	inverseJoinColumns = @JoinColumn(name="Code_Professionel"))
	private Collection<ProfessionelDeSante> professionelDeSantes; 
	
	
	@ManyToOne
	@JoinColumn(name = "Code_Bul")
	private BulletinDeSoin bulletinDeSoin;


	public Long getActe_id() {
		return acte_id;
	}


	public void setActe_id(Long acte_id) {
		this.acte_id = acte_id;
	}


	public String getRef_professionel() {
		return ref_professionel;
	}


	public void setRef_professionel(String ref_professionel) {
		this.ref_professionel = ref_professionel;
	}


	public String getRef_article() {
		return ref_article;
	}


	public void setRef_article(String ref_article) {
		this.ref_article = ref_article;
	}


	public double getMontant_totale() {
		return montant_totale;
	}


	public void setMontant_totale(double montant_totale) {
		this.montant_totale = montant_totale;
	}


	public Collection<ArticleMedicale> getArticleMedicale() {
		return articleMedicale;
	}


	public void setArticleMedicale(Collection<ArticleMedicale> articleMedicale) {
		this.articleMedicale = articleMedicale;
	}


	public Collection<ProfessionelDeSante> getProfessionelDeSantes() {
		return professionelDeSantes;
	}


	public void setProfessionelDeSantes(Collection<ProfessionelDeSante> professionelDeSantes) {
		this.professionelDeSantes = professionelDeSantes;
	}


	public BulletinDeSoin getBulletinDeSoin() {
		return bulletinDeSoin;
	}


	public void setBulletinDeSoin(BulletinDeSoin bulletinDeSoin) {
		this.bulletinDeSoin = bulletinDeSoin;
	}


	public ActeMedicale(Long acte_id, String ref_professionel, String ref_article, double montant_totale,
			Collection<ArticleMedicale> articleMedicale, Collection<ProfessionelDeSante> professionelDeSantes,
			BulletinDeSoin bulletinDeSoin) {
		super();
		this.acte_id = acte_id;
		this.ref_professionel = ref_professionel;
		this.ref_article = ref_article;
		this.montant_totale = montant_totale;
		this.articleMedicale = articleMedicale;
		this.professionelDeSantes = professionelDeSantes;
		this.bulletinDeSoin = bulletinDeSoin;
	}


	public ActeMedicale() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}