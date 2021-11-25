package test;

import java.time.LocalDateTime;
import java.util.List;

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
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetJpa");

	public static void findAllEquipement() 
	{
		EntityManager em = emf.createEntityManager();
	
		List<Equipement> equips = em.createQuery("from Equipement").getResultList();
		
		for(Equipement e : equips) 
		{
			System.out.println(e);
		}
		em.close();
	}
	
	
	public static void main(String[] args) {
		Personnage p = new Personnage("Gimli", 10,Race.Nain, true);
		Personnage p2 = new Personnage("Legolas", 4,Race.Elfe, false);
		
		Arme e1 = new Arme("Hache",LocalDateTime.now(),new Stats(8,6),2,2);
		Arme e2 = new Arme("Arc en bois",LocalDateTime.now(),new Stats(5,9),15,2);
		
		Monture m1 = new Monture("Galopa",LocalDateTime.now(),new Stats(2,10),TypeMonture.Licorne);
		Monture m2 = new Monture("Pumba",LocalDateTime.now(),new Stats(5,7),TypeMonture.Sanglier);
		
		Armure a1 = new Armure("Cote epineuse",LocalDateTime.now(),new Stats(2,20),"plaque");
		Armure a2 = new Armure("Cote epineuse",LocalDateTime.now(),new Stats(2,20),"plaque");
		
		p.setMonture(m2);
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		em.persist(p);
		em.persist(p2);
		em.persist(e1);
		em.persist(e2);
		em.persist(m1);
		em.persist(m2);
		em.persist(a1);
		em.persist(a2);
		em.getTransaction().commit();
		
		
		System.out.println(em.find(Equipement.class, 1));
		
		em.close();
		findAllEquipement();
		
		emf.close();
		
	}

}
