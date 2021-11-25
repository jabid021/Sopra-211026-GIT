package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne")
public abstract class Personne {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int numero;
	@Column(name="firstname",length = 25)
	protected String prenom;
	@Column(name="lastname",length = 45)
	protected String nom;
	
	@Embedded
	protected Adresse adresse;
	
	public Personne() {
	}

	//Constructeur pour le client (adresse obligatoire)
	public Personne(String prenom, String nom,Adresse adresse) {
		this.prenom = prenom;
		this.nom = nom;
		this.adresse=adresse;
	}
	
	//Pour le fournisseur(adresse en option)
	public Personne(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
	
	
	
}
