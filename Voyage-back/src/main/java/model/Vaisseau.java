package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Vaisseau implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double vitesse;
	private int capacite;
	private double distance;
	private String nom;

	public Vaisseau() {
	}
	public Vaisseau(String nom,double vitesse, int capacite, double distance) {
		this.nom=nom;
		this.vitesse = vitesse;
		this.capacite = capacite;
		this.distance = distance;
	}

	public Vaisseau(int id, String nom,double vitesse, int capacite, double distance) {
		this.id = id;
		this.nom=nom;
		this.vitesse = vitesse;
		this.capacite = capacite;
		this.distance = distance;
	}


	public double getVitesse() {
		return vitesse;
	}


	public void setVitesse(double vitesse) {
		this.vitesse = vitesse;
	}


	public int getCapacite() {
		return capacite;
	}


	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Vaisseau [id=" + id + ", vitesse=" + vitesse + ", capacite=" + capacite + ", distance=" + distance
				+ ", nom=" + nom + "]";
	}

	






}
