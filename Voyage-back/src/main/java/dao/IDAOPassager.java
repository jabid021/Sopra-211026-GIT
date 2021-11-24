package dao;

import java.util.List;

import model.Passager;

public interface IDAOPassager extends IDAO<Passager,Integer> {

	public List<Passager> findAllByClient(int id);
}
