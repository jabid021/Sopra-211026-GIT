package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Arme;
import model.Armure;
import model.Compagnon;
import model.Equipe;
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
	
	
	public static void init() 
	{
		Personnage p = new Personnage("Gimli", 10,Race.Nain, true);
		Personnage p2 = new Personnage("Legolas", 4,Race.Elfe, true);
		
		Arme e1 = new Arme("Hache",LocalDateTime.now(),new Stats(8,6),2,2);
		Arme e2 = new Arme("Arc en bois",LocalDateTime.now(),new Stats(5,9),15,2);
		
		Monture m1 = new Monture("Galopa",LocalDateTime.now(),new Stats(2,10),TypeMonture.Licorne);
		Monture m2 = new Monture("Pumba",LocalDateTime.now(),new Stats(5,7),TypeMonture.Sanglier);
		
		Armure a1 = new Armure("Cote epineuse",LocalDateTime.now(),new Stats(2,20),"plaque");
		Armure a2 = new Armure("Cote de maille",LocalDateTime.now(),new Stats(2,20),"plaque");
		
		p.setMonture(m2);
		p.setArme(e1);
		p.setArmure(a1);
		
		
		List<Equipement> inventaireGimli = new ArrayList();
		inventaireGimli.add(m2);
		inventaireGimli.add(e1);
		inventaireGimli.add(a1);
		inventaireGimli.add(a2);
		inventaireGimli.add(e2);
		p.setInventaire(inventaireGimli);
		
		
		
		List<Equipement> inventaireLego = new ArrayList();
		inventaireLego.add(m1);
		inventaireLego.add(e1);
		
		p2.setMonture(m1);
		p2.setArme(e1);
		p2.setInventaire(inventaireLego);
		
		Compagnon ecureuil  = new Compagnon("ecureuil");
		p2.setFamilier(ecureuil);
		Equipe team1 = new Equipe();
		p.setTeam(team1);
		p2.setTeam(team1);
		
		
		
		
		
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		
		/*em.persist(team1);
		em.persist(ecureuil);
		*/
		
	
	
	/*	em.persist(e1);
		em.persist(e2);
		em.persist(m1);
		em.persist(m2);
		em.persist(a1);
		em.persist(a2);*/
		
		
		em.persist(p);
		em.persist(p2);
		

		em.getTransaction().commit();
		
		
		System.out.println(em.find(Equipement.class, 1));
		
		em.close();
		
		
		
		em = emf.createEntityManager();
		
		Equipe equipe1 = em.find(Equipe.class, 1);
		for(Personnage perso : equipe1.getMembres()) 
		{
			System.out.println(perso);
		}
		
		em.close();
		//findAllEquipement();
		
		emf.close();
	}
	
	
	public static void insert() 
	{

		EntityManager em = emf.createEntityManager();
		Arme bouclier = new Arme("Bouclier", LocalDateTime.now(), null, 0, 1);
		em.getTransaction().begin();
		
				em.persist(bouclier);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	public static void update() 
	{
		
		
		EntityManager em = emf.createEntityManager();
		
		Arme bouclier = new Arme("TEST", LocalDateTime.now(), null, 0, 1);
	
		
		em.getTransaction().begin();
		
		bouclier=em.merge(bouclier);
		//Arme bouclierManaged=em.merge(bouclier);
		
		em.getTransaction().commit();
		em.close();
		
		System.out.println(bouclier);
		//System.out.println(bouclierManaged);
	}
	
	
	public static void select(int id) 
	{
		EntityManager em = emf.createEntityManager();
		
		Arme p = em.find(Arme.class, id);
		System.out.println(p);
		em.close();
		
	
	}
	
	
	
	public static void delete(int id) 
	{
		EntityManager em = emf.createEntityManager();
		Arme a = em.find(Arme.class,id);
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		/*
		 *persist(o) => o est managed 
		 *find(1) => l'objet recup sera managed
		 *delete(o) => o doit etre managed  
		 *merge(o) => o n'est pas managed
		 *
		 * 
		 
		 */
		
		//insert();
	//	select(7);
	//delete(7);
		update();
		emf.close();
	}

}
