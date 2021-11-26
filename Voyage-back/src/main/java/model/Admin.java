package model;

import javax.persistence.Entity;

@Entity
public class Admin extends Compte {
	

	public Admin() {
	}
	
	
	public Admin(int id,String login, String password) {
		super(id, login, password);
	}
	
	
	/*public String getLogin() {
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
	}*/
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	
}
