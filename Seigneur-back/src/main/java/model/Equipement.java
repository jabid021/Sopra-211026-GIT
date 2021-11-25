package model;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Equipement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	protected String nom;
	
	protected LocalDateTime creation;
	
	@Embedded
	protected Stats stats;
	
	
	public Equipement() {
	}


	public Equipement(String nom, LocalDateTime creation) {
		this.nom = nom;
		this.creation = creation;
	}

	public Equipement(String nom, LocalDateTime creation, Stats stats) {
		this.nom = nom;
		this.creation = creation;
		this.stats = stats;
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


	public LocalDateTime getCreation() {
		return creation;
	}


	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	
	
	
	
}
