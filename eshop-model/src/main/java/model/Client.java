package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("client")
public class Client extends Personne {
	
	private int age;
	@Column(name="date_de_naissance")
	private LocalDate naissance;
	 
	
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


	@Override
	public String toString() {
		return "Client [numero=" + numero + ", prenom=" + prenom + ", nom=" + nom + ", age=" + age + ", naissance="
				+ naissance + "]";
	}


	

	
}
