package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;
import model.Fournisseur;

public class App {

	public static void main(String[] args) {
		Client c1 = new Client("John", "Doe",42,LocalDate.parse("1979-10-05")) ;
		Client c2 = new Client("Jane","Doe",42,LocalDate.parse("1979-04-30"));
		
		Fournisseur f = new Fournisseur("Abid","Jordan","AJC");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop-model");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(c2);
		
		em.persist(f);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
