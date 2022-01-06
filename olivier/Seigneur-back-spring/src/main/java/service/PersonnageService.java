package service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.PersonnageException;
import model.Arme;
import model.Armure;
import model.Monture;
import model.Personnage;
import repository.CompagnonRepository;
import repository.PersonnageRepository;

//traitment
//service=> quelque chose qui fournit des fonctionnalites
@Service
public class PersonnageService {

	@Autowired
	private PersonnageRepository personnageRepo;
	@Autowired
	private CompagnonRepository compagnonRepo;
	@Autowired
	private CompagnonService compagnonService;
	@Autowired
	private EquipementService equipementService;

	public void creation(Personnage personnage) {
		if (personnage.getNom() == null) {
			throw new PersonnageException();
		}
		updateRelation(personnage);
		personnageRepo.save(personnage);
	}

	private void updateRelation(Personnage personnage) {
		if (personnage.getFamilier() != null && personnage.getFamilier().getId() != null) {
			personnage.setFamilier(compagnonService.getById(personnage.getFamilier().getId()));
<<<<<<< Updated upstream
=======
		} else {
			compagnonService.creationOuModification(personnage.getFamilier());
		}
		if (personnage.getArme() != null) {
			if (personnage.getArme().getId() != null) {
				personnage.setArme((Arme) equipementService.getById(personnage.getArme().getId()));
			}
		}
		if (personnage.getArmure() != null) {
			if (personnage.getArmure().getId() != null) {
				personnage.setArmure((Armure) equipementService.getById(personnage.getArmure().getId()));
			}
		}
		if (personnage.getMonture() != null) {
			if (personnage.getMonture().getId() != null) {
				personnage.setMonture((Monture) equipementService.getById(personnage.getMonture().getId()));
			}
		}
	}

	public void update(Personnage personnage) {
		if (personnage.getId() == null) {
			throw new PersonnageException();
		}
		Personnage personnageEnBase = getBy(personnage.getId());
		updateRelation(personnage);
		personnage.setVersion(personnageEnBase.getVersion());

		personnageRepo.save(personnage);
	}

	
	public void suppression(Long id) {
		suppression(getBy(id));
	}
	
	public void suppression(Personnage personnage) {
		// traitement sur le compagnon
		// delete
		// null maitre
		Personnage personnageEnBase = personnageRepo.findById(personnage.getId()).orElseThrow(PersonnageException::new);
		compagnonRepo.deleteByMaitre(personnageEnBase);
		personnageRepo.delete(personnageEnBase);
	}

	// recuperation

	public Personnage getBy(Long id) {
		Check.checkLong(id);
		return personnageRepo.findById(id).orElseThrow(PersonnageException::new);
	}

//	private void checkId(Long id) {
//		if (id == null) {
//			throw new PersonnageException();
//		}
//	}

	public Personnage getByIdWithQuetes(Long id) {
		Check.checkLong(id);
		return personnageRepo.findByIdWithQuetes(id).orElseThrow(PersonnageException::new);
	}

	public Personnage getByIdWithInventaire(Long id) {
		Check.checkLong(id);
		return personnageRepo.findByIdWithInventaire(id).orElseThrow(PersonnageException::new);
	}

	public Personnage getByIdWithInventaireAndQuetes(Long id) {
		Check.checkLong(id);
		return personnageRepo.findByIdWithInventaireAndQuetes(id).orElseThrow(PersonnageException::new);
	}

	public List<Personnage> getAll() {
		return personnageRepo.findAll();
	}
}
