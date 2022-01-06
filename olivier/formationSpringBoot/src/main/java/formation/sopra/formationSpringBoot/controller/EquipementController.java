package formation.sopra.formationSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.sopra.formationSpringBoot.model.Arme;
import formation.sopra.formationSpringBoot.model.Armure;
import formation.sopra.formationSpringBoot.model.Equipement;
import formation.sopra.formationSpringBoot.model.Monture;
import formation.sopra.formationSpringBoot.model.TypeMonture;
import formation.sopra.formationSpringBoot.services.EquipementService;

@Controller
@RequestMapping("/equipement")
public class EquipementController {

	@Autowired
	private EquipementService equipementService;

	@GetMapping({ "", "/" })
	public String allEquipement(Model model) {
		model.addAttribute("equipements", equipementService.getAll());
		return "equipement/list";
	}

	@GetMapping("/add/arme")
	public String addArme(Model model) {
		return goEdit(new Arme(), model);
	}

	@GetMapping("/add/armure")
	public String addArmure(Model model) {
		return goEdit(new Armure(), model);
	}

	@GetMapping("/add/monture")
	public String addMonture(Model model) {
		return goEdit(new Monture(), model);
	}

	private String goEdit(Equipement equipement, Model model) {
		model.addAttribute("montures", TypeMonture.values());
		model.addAttribute("equipement", equipement);
		return "equipement/editSpring";
	}

	@PostMapping("/save/arme")
	public String saveArme(@Valid @ModelAttribute("equipement") Arme arme,BindingResult br, Model model) {
		return save(arme,br, model);
	}

	@PostMapping("/save/armure")
	public String saveArmure(@Valid @ModelAttribute("equipement") Armure armure,BindingResult br, Model model) {
		return save(armure,br, model);
	}

	@PostMapping("/save/monture")
	public String saveMonture(@Valid @ModelAttribute("equipement") Monture monture,BindingResult br, Model model) {
		return save(monture,br, model);
	}

	private String save(Equipement equipement,BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(equipement, model);
		}
		if (equipement.getId() != null) {
			equipementService.update(equipement);
		} else {
			equipementService.create(equipement);
		}
		return "redirect:/equipement";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		return goEdit(equipementService.getById(id), model);
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		equipementService.delete(id);
		return "redirect:/equipement";
	}
}
