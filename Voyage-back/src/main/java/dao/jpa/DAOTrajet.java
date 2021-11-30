package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.IDAOTrajet;
import model.Trajet;
import util.Context;

public class DAOTrajet implements IDAOTrajet{

	@Override
	public Trajet findById(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Trajet objet = em.find(Trajet.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Trajet> findAll() {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
	
		List<Trajet> objets = em.createQuery("from Trajet").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Trajet save(Trajet objet) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		objet=em.merge(objet);

		em.getTransaction().commit();
		em.close();

		return objet;
	}

	@Override
	public void delete(Integer id) {
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Trajet objet = em.find(Trajet.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

}
