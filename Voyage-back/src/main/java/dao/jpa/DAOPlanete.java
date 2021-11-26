package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.IDAOPlanete;
import model.Planete;
import util.Context;

public class DAOPlanete implements IDAOPlanete{

	EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Planete findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Planete objet = em.find(Planete.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Planete> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Planete> objets = em.createQuery("from Planete").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Planete save(Planete objet) {
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
		Planete objet = em.find(Planete.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

}
