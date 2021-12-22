package controller;

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

import model.Personnage;
import repository.ArmeRepository;
import service.EquipementService;
import service.PersonnageService;

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
		return "personnage/edit";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		personnageService.suppression(personnageService.getBy(id));
		return "redirect:/personnage";
	}

	@GetMapping("/save")
	public String save(@Valid @ModelAttribute("personnage") Personnage personnage, BindingResult br, Model model) {
		System.out.println(personnage.getArme());
		if (br.hasErrors()) {
			return goEdit(personnage, model);
		}
		if (personnage.getId() != null) {
			personnageService.update(personnage);
		} else {
			personnageService.creation(personnage);
		}
		return "redirect:/personnage";
	}
}
