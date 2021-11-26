package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("client")
public class Client extends Personne {
	
	private int age;
	@Column(name="date_de_naissance")
	private LocalDate naissance;
	
	@ManyToMany
	@JoinTable
	(
		name="achat",
		joinColumns = @JoinColumn(name="id_client"),
		inverseJoinColumns = @JoinColumn(name="id_produit")
	)
	
	private List<Produit> achats;
	
	public Client() {
	}


	public Client(String prenom, String nom, int age, LocalDate naissance,Adresse adresse) {
		super(prenom, nom,adresse);
		this.age = age;
		this.naissance = naissance;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public LocalDate getNaissance() {
		return naissance;
	}


	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	

	public List<Produit> getAchats() {
		return achats;
	}


	public void setAchats(List<Produit> achats) {
		this.achats = achats;
	}


	@Override
	public String toString() {
		return "Client [numero=" + numero + ", prenom=" + prenom + ", nom=" + nom + ", age=" + age + ", naissance="
				+ naissance + "]";
	}


	

	
}
