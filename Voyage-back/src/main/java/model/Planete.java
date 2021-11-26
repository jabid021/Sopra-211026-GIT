package model;

import java.io.Serializable;

import javax.persistence.Entity;

public class Planete implements Serializable {

	private int id;
	private String nom;
	private TypePlanete type;
	private Coordonnees coordonnees;
	
	public Planete(String nom, TypePlanete type, Coordonnees coordonnees) {
		this.nom = nom;
		this.type = type;
		this.coordonnees = coordonnees;
	}
	
	public Planete(int id,String nom, TypePlanete type, Coordonnees coordonnees) {
		this.id=id;
		this.nom = nom;
		this.type = type;
		this.coordonnees = coordonnees;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypePlanete getType() {
		return type;
	}

	public void setType(TypePlanete type) {
		this.type = type;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Planete [id=" + id + ", nom=" + nom + ", type=" + type + ", coordonnees=" + coordonnees + "]";
	}

	
	
	
	
}
