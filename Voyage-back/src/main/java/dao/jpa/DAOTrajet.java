package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.IDAOTrajet;
import model.Trajet;
import util.Context;

public class DAOTrajet implements IDAOTrajet{

	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Trajet findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Trajet objet = em.find(Trajet.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Trajet> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Trajet> objets = em.createQuery("from Trajet").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Trajet save(Trajet objet) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		objet=em.merge(objet);

		em.getTransaction().commit();
		em.close();

		return objet;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		Trajet objet = em.find(Trajet.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

}
