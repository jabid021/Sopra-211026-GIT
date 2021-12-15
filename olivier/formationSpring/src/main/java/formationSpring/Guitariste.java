package formationSpring;

public class Guitariste implements Musicien {

	private Instrument guitare;

	public Guitariste() {

	}

	public Instrument getGuitare() {
		return guitare;
	}

	public void setGuitare(Instrument guitare) {
		this.guitare = guitare;
	}

	public void jouer() {
		System.out.println("le guitariste joue :" + this.guitare);
	}
}
