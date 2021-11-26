package model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@SequenceGenerator(name = "equipement_sequence") Pour du table per class !
@DiscriminatorColumn(name="type_equipement")
public abstract class Equipement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "equipement_sequence") Pour du table per class !
	protected int id;

	protected String nom;

	protected LocalDateTime creation;

	@Embedded
	protected Stats stats;

	//C'est ceux qui ont recup des equipements
	@ManyToMany(mappedBy = "inventaire" )
	private List<Personnage> looteurs;



	public Stats getStats() {
		return stats;
	}


	public void setStats(Stats stats) {
		this.stats = stats;
	}


	public List<Personnage> getLooteurs() {
		return looteurs;
	}


	public void setLooteurs(List<Personnage> looteurs) {
		this.looteurs = looteurs;
	}



	public Equipement() {
	}


	public Equipement(String nom, LocalDateTime creation) {
		this.nom = nom;
		this.creation = creation;
	}

	public Equipement(String nom, LocalDateTime creation, Stats stats) {
		this.nom = nom;
		this.creation = creation;
		this.stats = stats;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public LocalDateTime getCreation() {
		return creation;
	}


	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}





}
