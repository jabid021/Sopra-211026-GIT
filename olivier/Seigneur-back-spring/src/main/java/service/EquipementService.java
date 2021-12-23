package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.EquipementException;
import model.Arme;
import model.Armure;
import model.Equipement;
import model.Monture;
import repository.ArmeRepository;
import repository.ArmureRepository;
import repository.EquipementRepository;
import repository.MontureRepository;

@Service
public class EquipementService {

	@Autowired
	private EquipementRepository equipementRepo;
	@Autowired
	private ArmeRepository armeRepo;
	@Autowired
	private ArmureRepository armureRepo;
	@Autowired
	private MontureRepository montureRepo;

	public List<Arme> getAllArme() {
		return armeRepo.findAll();
	}

	public List<Armure> getAllArmure() {
		return armureRepo.findAll();
	}

	public List<Monture> getAllMonture() {
		return montureRepo.findAll();
	}

	public void create(Equipement equipement) {
		equipementRepo.save(equipement);
	}

	public Equipement getById(Long id) {
		return equipementRepo.findById(id).orElseThrow(EquipementException::new);
	}

	public Equipement update(Equipement equipement) {
		if (equipement.getId() == null) {
			throw new EquipementException();
		}
		Equipement equipementEnBase = equipementRepo.findById(equipement.getId()).orElseThrow(EquipementException::new);
		equipement.setCreation(equipementEnBase.getCreation());
		return equipementRepo.save(equipement);

	}

	public void delete(Equipement equipement) {
		equipementRepo.delete(equipement);
	}

	public void delete(Long id) {
		delete(getById(id));
	}

	public List<Equipement> getAll() {
		return equipementRepo.findAll();
	}
}
