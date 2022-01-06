package formation.sopra.formationSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.formationSpringBoot.exception.EquipementException;
import formation.sopra.formationSpringBoot.model.Arme;
import formation.sopra.formationSpringBoot.model.Armure;
import formation.sopra.formationSpringBoot.model.Equipement;
import formation.sopra.formationSpringBoot.model.Monture;
import formation.sopra.formationSpringBoot.repository.ArmeRepository;
import formation.sopra.formationSpringBoot.repository.ArmureRepository;
import formation.sopra.formationSpringBoot.repository.EquipementRepository;
import formation.sopra.formationSpringBoot.repository.MontureRepository;

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
