package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //Obligatoire
@Table(name="player")
public class Personnage {

	//Null ?
	//default ?
	
	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Obligatoire*
	private int id;
	
	@Column(name="name",nullable = false,columnDefinition = "VARCHAR(25)")
	private String nom;
	
	@Column(name="hp",nullable = false)
	private int pv;
	
	@Enumerated(EnumType.STRING)
	private Race race;
	
	@Column(name="alive",nullable = false)
	private boolean vivant;
	
	
	

	//Obligatoire
	public Personnage() {
	}
	
	
	public Personnage(String nom, int pv, Race race, boolean vivant) {
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


	public Race getRace() {
		return race;
	}


	public void setRace(Race race) {
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
