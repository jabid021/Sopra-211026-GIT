package model;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte",columnDefinition = "ENUM{'client','admin'}")
public abstract class Compte implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )

	protected int id;
	protected String login;
	protected String password;
	
	public Compte () {
		
		
	}
	
	public Compte(int id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
		
	}
	
	public Compte(String login, String password) {
		this.login = login;
		this.password = password;
	
	}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", login=" + login + ", password=" + password + "]";
	}


	
	
}
