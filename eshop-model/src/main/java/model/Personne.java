package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Personne {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int numero;
	@Column(name="firstname",length = 25)
	protected String prenom;
	@Column(name="lastname",length = 45)
	protected String nom;
	
	
	public Personne() {
	}

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
	
	
	
	
}
