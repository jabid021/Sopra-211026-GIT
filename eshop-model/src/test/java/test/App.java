package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personne;

public class App {

	public static void main(String[] args) {
		Personne p1 = new Personne("John", "Doe") ;
		Personne p2 = new Personne("Jane","Doe");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop-model");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		em.persist(p1);
		em.persist(p2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
