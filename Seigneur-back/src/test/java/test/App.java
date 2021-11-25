package test;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Arme;
import model.Armure;
import model.Equipement;
import model.Monture;
import model.Personnage;
import model.Race;
import model.Stats;
import model.TypeMonture;

public class App {

	public static void main(String[] args) {
		Personnage p = new Personnage("Gimli", 10,Race.Nain, true);
		Personnage p2 = new Personnage("Legolas", 4,Race.Elfe, false);
		
		Stats s = new Stats(8,6);
		Arme e1 = new Arme("Hache",LocalDateTime.now(),s,2,2);
		Arme e2 = new Arme("Arc en bois",LocalDateTime.now(),null,15,2);
		
		Monture m1 = new Monture("poney",LocalDateTime.now(),null,TypeMonture.Licorne);
		Monture m2 = new Monture("pumba",LocalDateTime.now(),null,TypeMonture.Sanglier);
		
		Armure a1 = new Armure("Cote epineuse",LocalDateTime.now(),null,"plaque");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetJpa");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		em.persist(p);
		em.persist(p2);
		em.persist(e1);
		em.persist(e2);
		em.persist(m1);
		em.persist(m2);
		em.persist(a1);
		em.getTransaction().commit();
		
		
		System.out.println(em.find(Equipement.class, 1));
		
		em.close();
		emf.close();
		
	}

}
