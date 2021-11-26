package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.IDAOCompagnon;
import model.Compagnon;
import util.Context;

public class DAOCompagnon implements IDAOCompagnon{

	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Compagnon findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Compagnon objet = em.find(Compagnon.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Compagnon> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Compagnon> objets = em.createQuery("from Compagnon").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Compagnon save(Compagnon objet) {
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
		Compagnon objet = em.find(Compagnon.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

}
