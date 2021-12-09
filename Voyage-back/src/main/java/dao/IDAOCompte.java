package dao;

import java.util.List;

import model.Client;
import model.Compte;

public interface IDAOCompte extends IDAO<Compte,Integer> {

	public Compte connect(String login,String password);
	public List<Client> findAllClient();
}
