package util;

import dao.IDAOCompte;
import dao.IDAOPassager;
import dao.IDAOPlanete;
import dao.IDAOTrajet;
import dao.IDAOVaisseau;
import dao.jdbc.DAOPassagerJDBC;
import dao.jdbc.DAOPlaneteJDBC;
import dao.jdbc.DAOTrajetJDBC;
import dao.jdbc.DAOVaisseauJDBC;
import dao.jpa.DAOCompte;
import model.Compte;

public class Context {


	//elements liés à NOTRE PROJET//
	private Compte connected;
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOPlanete daoPlanete = new DAOPlaneteJDBC();
	private IDAOTrajet daoTrajet = new DAOTrajetJDBC();
	private IDAOVaisseau daoVaisseau = new DAOVaisseauJDBC();
	private IDAOPassager daoPassager = new DAOPassagerJDBC(); 
	/////
	
	
	
	private static Context singleton=null;

	private Context() {}
	
	//getInstance est la methode permettant de recuper l'objet unique dans l'appi (singleton) 
	public static Context getInstance() 
	{
		if(singleton==null) 
		{
			singleton=new Context();
		}
		return singleton;
	}
	
	
	///
	//Getters / Setters liés à NOTRE PROJET
	public Compte getConnected() {
		return connected;
	}

	public void setConnected(Compte connected) {
		this.connected = connected;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoC) {
		this.daoCompte = daoC;
	}

	public IDAOPlanete getDaoPlanete() {
		return daoPlanete;
	}

	public void setDaoPlanete(IDAOPlanete daoP) {
		this.daoPlanete = daoP;
	}

	public IDAOTrajet getDaoTrajet() {
		return daoTrajet;
	}

	public void setDaoTrajet(IDAOTrajet daoT) {
		this.daoTrajet = daoT;
	}

	public IDAOVaisseau getDaoVaisseau() {
		return daoVaisseau;
	}

	

	public IDAOPassager getDaoPassager() {
		return daoPassager;
	}

	public void setDaoPassager(DAOPassagerJDBC daoPassager) {
		this.daoPassager = daoPassager;
	}
	///
	
	
	
	
	
}
