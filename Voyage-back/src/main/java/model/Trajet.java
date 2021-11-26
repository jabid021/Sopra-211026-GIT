package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trajet implements Serializable {

	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Obligatoire*
	private int id;
	private LocalDate dateDepart;
	private LocalTime heureDepart;
	@Column(name="planete_aller")
	@ManyToOne
	private Planete depart;
	
	@JoinColumn(name="planete_arrivee")
	@ManyToOne
	private Planete arrivee;
	
	@ManyToOne
	private Vaisseau vaisseau;
	
	public Trajet () {
		
	}
	public Trajet(LocalDate dateDepart,LocalTime heureDepart, Planete depart, Planete arrivee, Vaisseau vaisseau) {
		this.dateDepart = dateDepart;
		this.heureDepart=heureDepart;
		this.depart = depart;
		this.arrivee = arrivee;
		this.vaisseau = vaisseau;
	}

	public Trajet(int id,LocalDate dateDepart,LocalTime heureDepart, Planete depart, Planete arrivee, Vaisseau vaisseau) {
		this.id=id;
		this.dateDepart = dateDepart;
		this.heureDepart=heureDepart;
		this.depart = depart;
		this.arrivee = arrivee;
		this.vaisseau = vaisseau;
	}


	
	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalTime getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Planete getDepart() {
		return depart;
	}


	public void setDepart(Planete depart) {
		this.depart = depart;
	}


	public Planete getArrivee() {
		return arrivee;
	}


	public void setArrivee(Planete arrivee) {
		this.arrivee = arrivee;
	}


	public Vaisseau getVaisseau() {
		return vaisseau;
	}


	public void setVaisseau(Vaisseau vaisseau) {
		this.vaisseau = vaisseau;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double calculDistance() 
	{
		int x1=depart.getCoordonnees().getX();
		int x2=arrivee.getCoordonnees().getX();
		int y1=depart.getCoordonnees().getY();
		int y2=arrivee.getCoordonnees().getY();
		int z1=depart.getCoordonnees().getZ();
		int z2=arrivee.getCoordonnees().getZ();
		
		return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)+Math.pow(z2-z1, 2));
		
	}

	@Override
	public String toString() {
		return "Trajet [id=" + id + ", dateDepart=" + dateDepart + ", heureDepart=" + heureDepart + ", depart=" + depart
				+ ", arrivee=" + arrivee + ", vaisseau=" + vaisseau + "]";
	}

	
	
	
}
