package main;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import model.Arme;
import model.Equipement;
import model.Personnage;
import model.Quete;
import model.Race;
import model.Stats;
import repository.ArmeRepository;
import repository.ArmureRepository;
import repository.EquipementRepository;
import repository.PersonnageRepository;
import repository.QueteRepository;

//c'est un bean
public class AppSpring {

	@Autowired
	private EquipementRepository equipementRepo;
	@Autowired
	private ArmureRepository armureRepo;
	@Autowired
	private ArmeRepository armeRepo;
	@Autowired
	private PersonnageRepository personnageRepo;
	@Autowired
	private QueteRepository queteRepo;

	public void run(String... args) {

		Personnage p1 = new Personnage("tototototo", 10000, Race.Orc, true);
//		Arme arme = new Arme();
//		arme.setId(100L);
//		p1.setArme(arme);
//		personnageRepo.save(p1);
//		System.out.println(p1.getArme().getNom());

		// initDataBase();
//		System.out.println(personnageRepo.findByVivantTrue());
//		System.out.println(personnageRepo.findByVivantFalse());
//		System.out.println(personnageRepo.findByIdWithInventaire(100L).get().getInventaire());
//		System.out.println(personnageRepo.findByIdWithQuetes(100L).get().getQuetes());

		Personnage bob = personnageRepo.findByIdWithInventaireAndQuetes(100L).get();
		System.out.println(bob.getQuetes());
		System.out.println(bob.getInventaire());
	}

	private void initDataBase() {
		Arme epee = new Arme("epee", LocalDateTime.now(), new Stats(100, 100), 0.0, 1);
		Arme arc = new Arme("arc", LocalDateTime.now(), new Stats(100, 100), 100.0, 2);
		armeRepo.save(epee);
		armeRepo.save(arc);

		Quete quete1 = new Quete("initiation");
		Quete quete2 = new Quete("boss1");

		queteRepo.save(quete1);
		queteRepo.save(quete2);

		Personnage fantasin = new Personnage("bob", 1, Race.Humain, true);
		fantasin.setArme(epee);
		fantasin.setInventaire(new HashSet<Equipement>(Arrays.asList(epee, arc)));
		fantasin.setQuetes(Arrays.asList(quete1, quete2).stream().collect(Collectors.toSet()));
		personnageRepo.save(fantasin);
		Personnage archer = new Personnage("archer", 100, Race.Elfe, false);
		personnageRepo.save(archer);

	}
}
