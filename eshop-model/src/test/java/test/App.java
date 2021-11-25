package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Client;
import model.Fournisseur;

public class App {

	public static void main(String[] args) {
		
		
		Client c1 = new Client("John", "Doe",42,LocalDate.parse("1979-10-05"),new Adresse("12 rue de paris,75009, Paris")) ;
		Client c2 = new Client("Jane","Doe",42,LocalDate.parse("1979-04-30"),new Adresse("12 rue de paris,75009, Paris"));
		
		Fournisseur f = new Fournisseur("Abid","Jordan","AJC");
		f.setAdresse(new Adresse("6 rue rougemon,75009, Paris"));
		
		Fournisseur f2 = new Fournisseur("Toto","Titi","Toto.Co");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop-model");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(c2);
		
		em.persist(f);
		em.persist(f2);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
