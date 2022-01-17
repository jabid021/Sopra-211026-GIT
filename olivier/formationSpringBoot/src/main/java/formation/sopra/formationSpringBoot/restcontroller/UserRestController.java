package formation.sopra.formationSpringBoot.restcontroller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.formationSpringBoot.model.JsonViews;
import formation.sopra.formationSpringBoot.model.Role;
import formation.sopra.formationSpringBoot.model.User;
import formation.sopra.formationSpringBoot.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/inscription")
	@JsonView(JsonViews.Common.class)
	public User inscription(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(Arrays.asList(Role.ROLE_USER));
		user.setEnable(true);
		return userRepo.save(user);
	}
	
	@GetMapping("")
	public boolean login() {
		return true;
	}
}
