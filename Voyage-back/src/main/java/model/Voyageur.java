package model;

public class Voyageur {

	private int id;
	private Reservation reservation;
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
