package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reservation implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	private LocalDate dateReservation;
	
	@Column(name="trajet_aller")
	@ManyToOne
	private Trajet aller;
	
	@Column(name="trajet_retour")
	@ManyToOne
	private Trajet retour;
	@ManyToOne
	private Client client;
	
	public Reservation () {
		
	}
	public Reservation(Trajet aller, Client client) {
		this.aller = aller;
		this.client = client;
		this.dateReservation=LocalDate.now();
	}

	
	public Reservation(Trajet aller, Client client,LocalDate dateReservation) {
		this.aller = aller;
		this.client = client;
		this.dateReservation=dateReservation;
	}

	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public LocalDate getDateReservation() {
		return dateReservation;
	}


	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}


	public Trajet getAller() {
		return aller;
	}


	public void setAller(Trajet aller) {
		this.aller = aller;
	}

	
	public Trajet getRetour() {
		return retour;
	}


	public void setRetour(Trajet retour) {
		this.retour = retour;
	}

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Reservation [numero=" + numero + ", dateReservation=" + dateReservation + ", aller=" + aller + ", retour=" + retour + ", client=" + client + "]";
	}


	
	
	
	
	
}
