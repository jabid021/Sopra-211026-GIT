package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Voyageur {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="reservation")
	private Reservation reservation;
	
	@OneToOne
	@JoinColumn(name="reservation")
	private Passager passager;
	
	
	public Voyageur(Reservation reservation, Passager passager) {
		this.reservation = reservation;
		this.passager = passager;
	}


	public Voyageur(int id, Reservation reservation, Passager passager) {
		this.id = id;
		this.reservation = reservation;
		this.passager = passager;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public Passager getPassager() {
		return passager;
	}


	public void setPassager(Passager passager) {
		this.passager = passager;
	}


	@Override
	public String toString() {
		return "Voyageur [id=" + id + ", reservation=" + reservation + ", passager=" + passager + "]";
	}




	
	
	
	
}
