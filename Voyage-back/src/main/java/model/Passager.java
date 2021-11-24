package model;

import java.io.Serializable;

public class Passager implements Serializable {

	private int id;
	private String nom;
	private String prenom;
	private Client client;
	
	public Passager(String nom, String prenom,Client client) {
		this.nom = nom;
		this.prenom = prenom;
		this.client=client;
	}
	
	public Passager(int id,String nom, String prenom,Client client) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.client=client;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Passager [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", client=" + client + "]";
	}

	
	
	
	
	
	
}
