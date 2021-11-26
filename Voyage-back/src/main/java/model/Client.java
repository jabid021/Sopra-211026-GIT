package model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Entity;

@Entity
public class Client extends Compte {

	
	private String nom;
	private String prenom;
	@OneToMany
	@JoinTable(name="Achat")
	private List<Reservation> reservations;
	
	
	public Client () {
		
	}
	
	public Client(String login, String password, String nom, String prenom) {
		super(login, password);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", reservations=" + reservations + "]";
	}

	

	
	

	
	
	
}
