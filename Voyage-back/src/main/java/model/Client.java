package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("client")
public class Client extends Compte {

	
	private String nom;
	private String prenom;
	
	
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations;
	
	
	public Client () {
		
	}
	
	
	public Client(int id,String login, String password, String nom, String prenom) {
		super(id, login, password);
		this.nom = nom;
		this.prenom = prenom;
	}

	public Client(String login, String password, String nom, String prenom/*, List<Reservation> reservations*/) {
		super(login, password);
		this.nom = nom;
		this.prenom = prenom;
		/*this.reservations = reservations;*/
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
