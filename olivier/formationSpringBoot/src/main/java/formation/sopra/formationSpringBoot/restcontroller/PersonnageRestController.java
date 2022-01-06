package formation.sopra.formationSpringBoot.restcontroller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.formationSpringBoot.exception.PersonnageException;
import formation.sopra.formationSpringBoot.model.JsonViews;
import formation.sopra.formationSpringBoot.model.Personnage;
import formation.sopra.formationSpringBoot.model.Race;
import formation.sopra.formationSpringBoot.services.PersonnageService;

@RestController
@RequestMapping("/api/personnage")
public class PersonnageRestController {

	@Autowired
	private PersonnageService personnageService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Personnage> getAll() {
		return personnageService.getAll();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Personnage.class)
	private Personnage getByIdBase(@PathVariable Long id) {
		return personnageService.getBy(id);
	}

	public Personnage getById(Long id) {
		return getByIdBase(id);
	}

	@GetMapping("/{id}/quetes")
	@JsonView(JsonViews.PersonnageWithQuetes.class)
	private Personnage getByIdWithQuetes(@PathVariable Long id) {
		return personnageService.getByIdWithQuetes(id);
	}

	@GetMapping("/{id}/inventaire")
	@JsonView(JsonViews.PersonnageWithInventaire.class)
	private Personnage getByIdWithInventaire(@PathVariable Long id) {
		return personnageService.getByIdWithInventaire(id);
	}

	@GetMapping({ "/{id}/quete/inventaire", "/{id}/inventaire/quete" })
	@JsonView(JsonViews.PersonnageWithInventaire.class)
	private Personnage getByIdWithQuetesAndInventaire(@PathVariable Long id) {
		return personnageService.getByIdWithInventaireAndQuetes(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Personnage.class)
	public Personnage create(@Valid @RequestBody Personnage personnage, BindingResult br) {
		if (br.hasErrors()) {
			throw new PersonnageException();
		}
		personnageService.creation(personnage);
		return personnage;

	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Personnage.class)
	public Personnage put(@Valid @RequestBody Personnage personnage, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new PersonnageException();
		}
		if (personnage.getId() == null) {
			personnage.setId(id);
		}
		personnageService.update(personnage);
		return personnage;
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Personnage.class)
	public Personnage patch(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Personnage personnage = personnageService.getBy(id);
		fields.forEach((k, v) -> {
			Field field = ReflectionUtils.findField(Personnage.class, k);
			ReflectionUtils.makeAccessible(field);
			if (k.equals("race")) {
				personnage.setRace(Race.valueOf(v.toString()));
			} else {
				ReflectionUtils.setField(field, personnage, v);
			}
		});
		personnageService.update(personnage);
		return personnage;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		personnageService.suppression(id);
	}

}
