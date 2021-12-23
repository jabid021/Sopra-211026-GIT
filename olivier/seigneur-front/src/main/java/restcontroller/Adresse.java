package restcontroller;

public class Adresse {
	String rue;
	String codePostal;

	public Adresse() {

	}

	public Adresse(String rue, String codePostal) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

}
