package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Client;
import model.Fournisseur;
import model.Produit;

public class App {

	public static void main(String[] args) {
		
		
		Client c1 = new Client("John", "Doe",42,LocalDate.parse("1979-10-05"),new Adresse("12 rue de paris,75009, Paris")) ;
		Client c2 = new Client("Jane","Doe",42,LocalDate.parse("1979-04-30"),new Adresse("12 rue de paris,75009, Paris"));
		
		Fournisseur f = new Fournisseur("Abid","Jordan","AJC");
		f.setAdresse(new Adresse("6 rue rougemon,75009, Paris"));
		
		Fournisseur f2 = new Fournisseur("Toto","Titi","Toto.Co");
		
		
		Produit p = new Produit("Formation Java", 1500, f);
		Produit p2 = new Produit("Formation C", 1.5, f);
		Produit p3 = new Produit("Formation mecha", 15000, f);
		
		List<Produit> achats = new ArrayList();
		
		achats.add(p);
		achats.add(p2);
		achats.add(p3);
		
		c1.setAchats(achats);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop-model");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		em.persist(f);
		em.persist(f2);
		
		em.persist(p);
		em.persist(p2);
		em.persist(p3);
		
		
		em.persist(c1);
		em.persist(c2);
	
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
