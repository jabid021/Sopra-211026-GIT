package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //Obligatoire
@Table(name="player")
public class Personnage {

	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Obligatoire*
	private int id;
	private String nom;
	private int pv;
	private String race;
	private boolean vivant;

	//Obligatoire
	public Personnage() {
	}
	
	
	public Personnage(String nom, int pv, String race, boolean vivant) {
		this.nom = nom;
		this.pv = pv;
		this.race = race;
		this.vivant = vivant;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getPv() {
		return pv;
	}


	public void setPv(int pv) {
		this.pv = pv;
	}


	public String getRace() {
		return race;
	}


	public void setRace(String race) {
		this.race = race;
	}


	public boolean isVivant() {
		return vivant;
	}


	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Personnage [id=" + id + ", nom=" + nom + ", pv=" + pv + ", race=" + race + ", vivant=" + vivant + "]";
	}


	
	
	
	
	
	
	
	
	
}
