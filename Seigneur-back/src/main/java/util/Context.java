package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetJpa");
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
	
	
	
	
	
	
	
	
}
