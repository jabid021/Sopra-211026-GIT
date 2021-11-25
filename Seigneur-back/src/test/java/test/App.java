package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personnage;

public class App {

	public static void main(String[] args) {
		Personnage p = new Personnage("Gimli", 10,"nain", true);
		Personnage p2 = new Personnage("Legolas", 4,"elfe", false);
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetJpa");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		em.persist(p);
		em.persist(p2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
