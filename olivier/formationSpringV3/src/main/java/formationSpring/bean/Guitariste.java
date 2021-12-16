package formationSpring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Guitariste implements Musicien {

	@Autowired
	@Qualifier("guitare") //ne sert que si on a plusieurs candidats
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
		System.out.println("le guitariste joue :" + this.instrument);
		//throw new IllegalArgumentException();
	}
	
	public String getInfo() {
		return "olivier";
	}
}
