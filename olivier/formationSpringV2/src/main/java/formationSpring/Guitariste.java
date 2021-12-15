package formationSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "hendrix")
public class Guitariste implements Musicien {

	@Autowired
	@Qualifier("yamaha") // ne sert que si on a plusieurs candidats
	private Instrument instrument;

	public Guitariste() {

	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public void jouer() {
		throw new IllegalArgumentException("une erreur)");
		//System.out.println("le guitariste joue :" + this.instrument);

	}
}
