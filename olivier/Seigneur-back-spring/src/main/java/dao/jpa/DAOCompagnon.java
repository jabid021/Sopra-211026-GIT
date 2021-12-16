package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.IDAOCompagnon;
import model.Compagnon;

@Repository
public class DAOCompagnon implements IDAOCompagnon {

//	@Autowired
//	private EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Compagnon findById(Long id) {
		return em.find(Compagnon.class, id);

	}

	@Override
	public List<Compagnon> findAll() {
		return em.createQuery("from Compagnon", Compagnon.class).getResultList();

	}

	@Override
	@Transactional
	public Compagnon save(Compagnon objet) {
		return em.merge(objet);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(em.find(Compagnon.class, id));
	}

}
