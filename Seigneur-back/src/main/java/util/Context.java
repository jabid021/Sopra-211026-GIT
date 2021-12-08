package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOPersonnage;
import dao.jpa.DAOPersonnage;

public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetJpa");
	private IDAOPersonnage daoP = new DAOPersonnage();
	private static Context singleton=null;

	private Context() {}
	
	public static Context getInstance() 
	{
		if(singleton==null) 
		{
			singleton=new Context();
		}
		return singleton;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public IDAOPersonnage getDaoP() {
		return daoP;
	}

	public void setDaoP(IDAOPersonnage daoP) {
		this.daoP = daoP;
	}
	
	
	
	
	
	
	
	
	
}
