package formationSpring.bean;

import org.springframework.stereotype.Component;

//@Component
public class Pianiste implements Musicien {

	@Override
	public void jouer() {
		System.out.println("pianiste");
	}

}
