package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	@Column(nullable=true)
	private String adresse;
	
	public Adresse() {
	}

	public Adresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Adresse [adresse=" + adresse + "]";
	}
	
	
	
}
