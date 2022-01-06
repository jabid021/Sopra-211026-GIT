package formation.sopra.formationSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.sopra.formationSpringBoot.model.Arme;
import formation.sopra.formationSpringBoot.model.Armure;
import formation.sopra.formationSpringBoot.model.Monture;
import formation.sopra.formationSpringBoot.model.Personnage;
import formation.sopra.formationSpringBoot.services.EquipementService;
import formation.sopra.formationSpringBoot.services.PersonnageService;

@Controller
@RequestMapping("/personnage")
public class PersonnageController {

	@Autowired
	private PersonnageService personnageService;
	@Autowired
	private EquipementService equipementService;

	@GetMapping("")
	public String getAll(Model model) {
		model.addAttribute("personnages", personnageService.getAll());
		return "personnage/list";
	}

	@GetMapping("/add")
	public String create(Model model) {
		return goEdit(new Personnage(), model);
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		return goEdit(personnageService.getBy(id), model);
	}

	private String goEdit(Personnage personnage, Model model) {
		model.addAttribute("personnage", personnage);
		model.addAttribute("armes", equipementService.getAllArme());
		model.addAttribute("armures", equipementService.getAllArmure());
		model.addAttribute("montures", equipementService.getAllMonture());
		return "personnage/edit";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		personnageService.suppression(personnageService.getBy(id));
		return "redirect:/personnage";
	}

	@GetMapping("/save")
	public String save(@Valid @ModelAttribute("personnage") Personnage personnage, BindingResult br, Model model) {

		if (br.hasErrors()) {
			return goEdit(personnage, model);
		}

		if (personnage.getArme() != null) {
			if (personnage.getArme().getId() != null) {
				personnage.setArme((Arme) equipementService.getById(personnage.getArme().getId()));
			} else {
				personnage.setArme(null);
			}
		}

		if (personnage.getArmure() != null) {
			if (personnage.getArmure().getId() != null) {
				personnage.setArmure((Armure) equipementService.getById(personnage.getArmure().getId()));
			} else {
				personnage.setArmure(null);
			}

		}
		if (personnage.getMonture() != null) {
			if (personnage.getMonture().getId() != null) {
				personnage.setMonture((Monture) equipementService.getById(personnage.getMonture().getId()));
			} else {
				personnage.setMonture(null);
			}
		}
		if (personnage.getId() != null) {
			personnageService.update(personnage);
		} else {
			personnageService.creation(personnage);
		}
		return "redirect:/personnage";
	}
}
