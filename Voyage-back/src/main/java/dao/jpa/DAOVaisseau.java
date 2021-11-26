package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.IDAOVaisseau;
import model.Vaisseau;
import util.Context;

public class DAOVaisseau implements IDAOVaisseau{

	EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Vaisseau findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Vaisseau objet = em.find(Vaisseau.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Vaisseau> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Vaisseau> objets = em.createQuery("from Vaisseau").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Vaisseau save(Vaisseau objet) {
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
		Vaisseau objet = em.find(Vaisseau.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

}
