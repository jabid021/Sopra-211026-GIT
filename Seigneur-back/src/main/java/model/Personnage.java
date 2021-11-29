package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity //Obligatoire
@Table(name="player")
public class Personnage {

	//Null ?
	//default ?
	
	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Obligatoire*
	private int id;
	
	@Column(name="name",nullable = false,columnDefinition = "VARCHAR(25)")
	private String nom;
	
	@Column(name="hp",nullable = false)
	private int pv;
	
	@Enumerated(EnumType.STRING)
	private Race race;
	
	@Column(name="alive",nullable = false)
	private boolean vivant;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)//Obligatoire
	@JoinColumn(name="monture_equipee") //Seulement si l'on veut rename le col de jointure
	private Monture monture;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="arme_equipee")
	private Arme arme;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="armure_equipee")
	private Armure armure;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name="inventaire", //Rename la table
			joinColumns = @JoinColumn(name="id_du_personnage"), //rename la clé principale (Personnage car on est dans la classe Personnage)
			inverseJoinColumns = @JoinColumn(name="id_equipement") //rename l'autre clé, celle de l'attribut donc Equipement ici
			
			)
	private List<Equipement> inventaire;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Equipe team;
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private Compagnon familier;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="challenge_accepted")
	private List<Quete> quetes;
	//Obligatoire
	public Personnage() {
	}
	
	
	public Personnage(String nom, int pv, Race race, boolean vivant) {
		this.nom = nom;
		this.pv = pv;
		this.race = race;
		this.vivant = vivant;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getPv() {
		return pv;
	}


	public void setPv(int pv) {
		this.pv = pv;
	}


	public Race getRace() {
		return race;
	}


	public void setRace(Race race) {
		this.race = race;
	}


	public boolean isVivant() {
		return vivant;
	}


	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	
	public Monture getMonture() {
		return monture;
	}


	public void setMonture(Monture monture) {
		this.monture = monture;
	}

	

	public Arme getArme() {
		return arme;
	}


	public void setArme(Arme arme) {
		this.arme = arme;
	}


	public Armure getArmure() {
		return armure;
	}


	public void setArmure(Armure armure) {
		this.armure = armure;
	}

	

	public List<Equipement> getInventaire() {
		return inventaire;
	}


	public void setInventaire(List<Equipement> inventaire) {
		this.inventaire = inventaire;
	}
	
	


	public Equipe getTeam() {
		return team;
	}


	public void setTeam(Equipe team) {
		this.team = team;
	}


	public Compagnon getFamilier() {
		return familier;
	}


	public void setFamilier(Compagnon familier) {
		this.familier = familier;
	}

	

	public List<Quete> getQuetes() {
		return quetes;
	}


	public void setQuetes(List<Quete> quetes) {
		this.quetes = quetes;
	}


	@Override
	public String toString() {
		return "Personnage [id=" + id + ", nom=" + nom + ", pv=" + pv + ", race=" + race + ", vivant=" + vivant
				+ ", monture=" + monture + ", arme=" + arme + ", armure=" + armure + ", inventaire=" + inventaire
				+ ", team=" + team + ", familier=" + familier + "]";
	}


	
	
	
	


	
	
	
	
	
	
	
	
	
}
