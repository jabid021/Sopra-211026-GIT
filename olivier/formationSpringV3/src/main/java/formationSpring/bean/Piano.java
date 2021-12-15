package formationSpring.bean;

import org.springframework.stereotype.Component;

@Component("yamaha")
public class Piano implements Instrument {
	@Override
	public String toString() {
		return "piano";
	}
}
