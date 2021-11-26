package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.IDAOReservation;
import model.Reservation;
import util.Context;

public class DAOReservation implements IDAOReservation{

	static EntityManagerFactory emf = Context.getInstance().getEmf();

	@Override
	public Reservation findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		Reservation objet = em.find(Reservation.class, id);
		em.close();
		return objet;
	}

	@Override
	public List<Reservation> findAll() {


		EntityManager em = emf.createEntityManager();
	
		List<Reservation> objets = em.createQuery("from Reservation").getResultList();
		em.close();
		return objets;
		
	}

	@Override
	public Reservation save(Reservation objet) {
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
		Reservation objet = em.find(Reservation.class, id);

		em.getTransaction().begin();
		
		em.remove(objet);
		
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<Reservation> findAllByClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
