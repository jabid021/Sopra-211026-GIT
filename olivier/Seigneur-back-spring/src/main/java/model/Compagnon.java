package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqCompagnon", sequenceName = "seq_compagnon", allocationSize = 1, initialValue = 100)
public class Compagnon {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompagnon")
	private Long id;
	private String nom;

	@OneToOne(mappedBy = "familier")
	private Personnage maitre;

	public Compagnon() {
	}

	public Compagnon(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Personnage getMaitre() {
		return maitre;
	}

	public void setMaitre(Personnage maitre) {
		this.maitre = maitre;
	}

	@Override
	public String toString() {
		return "Compagnon [id=" + id + ", nom=" + nom + "]";
	}

}