package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.IDAOPassager;
import model.Passager;
import util.Context;

public class DAOPassager implements IDAOPassager{

	@Override
	public Passager findById(Integer id) {
		
		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
		Passager objet = em.find(Passager.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Passager> findAll() {

		EntityManagerFactory emf = Context.getInstance().getEmf();
		EntityManager em = emf.createEntityManager();
	
		List<Passager> objets = em.createQuery("from Passager").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Passager save(Passager objet) {
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
		Passager objet = em.find(Passager.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Passager> findAllByClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
