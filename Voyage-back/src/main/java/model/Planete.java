package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="planete")
public class Planete implements Serializable {

	
	@Id//Obligatoire
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name="type_planete",columnDefinition = "ENUM{Gazeuse,Tellurique}") 
	private TypePlanete type;
	private String description;
	private String img;
	
	@Embedded
	private Coordonnees coordonnees;
	
	
	public Planete(String nom, TypePlanete type, Coordonnees coordonnees) {
		this.nom = nom;
		this.type = type;
		this.coordonnees = coordonnees;
	}
	
	public Planete(int id,String nom, TypePlanete type, Coordonnees coordonnees) {
		this.id=id;
		this.nom = nom;
		this.type = type;
		this.coordonnees = coordonnees;
	}
	
	public Planete() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public TypePlanete getType() {
		return type;
	}

	public void setType(TypePlanete type) {
		this.type = type;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Planete [id=" + id + ", nom=" + nom + ", type=" + type + ", coordonnees=" + coordonnees + "]";
	}

	
	
	
	
}
