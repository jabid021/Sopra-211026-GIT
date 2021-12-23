package restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloRestController {

	@GetMapping("")
	public String sayHello() {
		return "hello world";
	}

	@GetMapping("/personne")
	public Personne getOlivier() {
		return new Personne("olivier", "gozlan", new Adresse("rue xxxxx", "11111 ville"));
	}

	@GetMapping("/manypersonne")
	public List<Personne> getManyPersonne() {
		return Arrays.asList(new Personne("olivier", "gozlan"),
				new Personne("jordan", "abid", new Adresse("chez jordan", "chez jordan")));
	}

	@PostMapping("/personne")
	public void addPersonne(@RequestBody Personne personne) {
		System.out.println(personne);
		System.out.println(personne.getPrenom());
		System.out.println(personne.getNom());
		System.out.println(personne.getAdresse());
		if (personne.getAdresse() != null) {
			System.out.println(personne.getAdresse().getRue());
		}
	}
}
