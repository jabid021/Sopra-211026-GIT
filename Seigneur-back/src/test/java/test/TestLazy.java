package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Personnage;
import util.Context;

public class TestLazy {


	//Acces aux quetes AVANT le em.close
	//Impossible de faire des filtres sur les quetes / inventaire 
	public static List<Personnage> showLazy() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("from Personnage");
		List<Personnage> persos =  q.getResultList();
		em.close();
		return persos;
	}


	//Acces aux quetes AVANT le em.close
	//Possible de faire des filtres sur les quetes / inventaire 
	//Uniquement les personnages ayant des quetes
	//Retourne des doublons si le personnage a plusieurs quetes
	public static List<Personnage> showJoin() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("Select p from Personnage p join p.quetes quete where quete.nom like :lib");
		q.setParameter("lib", "%e%");
		List<Personnage> persos =  q.getResultList();
		em.close();
		return persos;
	}




	//Acces aux quetes AVANT le em.close
	//Possible de faire des filtres sur les quetes / inventaire 
	//TOUS LES PERSONNAGES (MEME SANS QUETES)
	//Retourne des doublons si le personnage a plusieurs quetes
	public static List<Personnage> showLeftJoin() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("Select p from Personnage p left join p.quetes quete");
		List<Personnage> persos =  q.getResultList();
		em.close();
		return persos;
	}


	//Acces aux quetes AVANT le em.close
	//Possible de faire des filtres sur les quetes / inventaire 
	//TOUS LES PERSONNAGES (MEME SANS QUETES)
	//Pas de doublons si un personnage a plusieurs quetes
	public static List<Personnage> showJoinNoDoublons() 
	{
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Query q = em.createQuery("Select distinct p from Personnage p left join p.quetes quete");
		List<Personnage> persos =  q.getResultList();
		em.close();
		return persos;
	}

	    //Acces aux quetes APRES le em.close
		//Possible de faire des filtres sur les quetes / inventaire 
		//TOUS LES PERSONNAGES (MEME SANS QUETES)
		//Pas de doublons si un personnage a plusieurs quetes
		public static List<Personnage> showJoinFetchNoDoublons() 
		{
			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			Query q = em.createQuery("Select distinct p from Personnage p left join fetch p.quetes");
			List<Personnage> persos =  q.getResultList();
			em.close();
			return persos;
		}
		
		public static List<Personnage> showJoinFetchNoDoublonsInventaire() 
		{
			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			Query q = em.createQuery("Select distinct p from Personnage p left join fetch p.inventaire");
			List<Personnage> persos =  q.getResultList();
			em.close();
			return persos;
		}
		
		
		//-------------Comment recup un perso avec ses quetes + son inventaire ? ------------------/////
		public static List<Personnage> fullJoinNotWorking() 
		{
			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			Query q = em.createQuery("Select distinct p from Personnage p left join fetch p.inventaire join fetch p.quetes");
			List<Personnage> persos =  q.getResultList();
			em.close();
			return persos;
		}
		
		
		public static List<Personnage> fullJoinWorking() 
		{
			EntityManager em = Context.getInstance().getEmf().createEntityManager();
			Query q = em.createQuery("Select distinct p from Personnage p left join fetch p.inventaire");
			List<Personnage> persos =  q.getResultList();
			q = em.createQuery("Select distinct p from Personnage p left join fetch p.quetes");
			persos =  q.getResultList();
		
			em.close();
			return persos;
		}
		

	public static void main(String[] args) {
		List<Personnage> persos =fullJoinWorking();  
		for(Personnage p :  persos)	
		{
			//System.out.println(p.getNom());
			System.out.println(p);
			System.out.println("Liste de ses quetes : ");
			System.out.println(p.getQuetes());
			System.out.println("Inventaire : ");
			System.out.println(p.getInventaire());
			System.out.println("---------");
		}	
		

		


		Context.getInstance().getEmf().close();
	}

}
