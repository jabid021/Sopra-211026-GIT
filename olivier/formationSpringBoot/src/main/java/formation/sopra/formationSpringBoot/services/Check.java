package formation.sopra.formationSpringBoot.services;

import formation.sopra.formationSpringBoot.exception.CheckLongException;

public class Check {
	public static void checkLong(Long id) {
		if (id == null || id < 0) {
			throw new CheckLongException();
		}
	}
}
