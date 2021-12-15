package formationSpring;

import org.springframework.stereotype.Component;

@Component
public class Guitare implements Instrument {

	private String modele;

	public Guitare() {
	}

	@Override
	public String toString() {
		return "je suis une guitare";
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

}
