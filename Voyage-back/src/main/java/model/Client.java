package model;

import java.util.List;

public class Client extends Compte {

	private String nom;
	private String prenom;
	private List<Reservation> reservations;
	
	
	public Client(String login, String password, String nom, String prenom) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
	}

	
	public Client(int id,String login, String password, String nom, String prenom) {
		super(id,login, password);
		this.nom = nom;
		this.prenom = prenom;
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

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", id=" + id + ", login=" + login + ", password="
				+ password + "]";
	}


	
	

	
	
	
}
