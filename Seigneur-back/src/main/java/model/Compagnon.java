package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Compagnon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToOne(mappedBy = "familier")
	private Personnage maitre;
	
	
	public Compagnon() {
	}


	public Compagnon(String nom) {
		this.nom = nom;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Personnage getMaitre() {
		return maitre;
	}


	public void setMaitre(Personnage maitre) {
		this.maitre = maitre;
	}


	@Override
	public String toString() {
		return "Compagnon [id=" + id + ", nom=" + nom + "]";
	}



	
	
	
	
}
