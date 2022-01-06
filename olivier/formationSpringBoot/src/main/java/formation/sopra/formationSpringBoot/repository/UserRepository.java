package formation.sopra.formationSpringBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import formation.sopra.formationSpringBoot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByLogin(String login);
}
