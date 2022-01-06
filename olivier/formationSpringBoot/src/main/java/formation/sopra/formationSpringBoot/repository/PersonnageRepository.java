package formation.sopra.formationSpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.formationSpringBoot.model.Personnage;

public interface PersonnageRepository extends JpaRepository<Personnage, Long> {

	Optional<Personnage> findByNom(String nom);

	List<Personnage> findByNomContaining(String nom);

	List<Personnage> findByVivant(boolean vivant);

	List<Personnage> findByVivantTrue();

	List<Personnage> findByVivantFalse();

	@Query("select distinct personnage from Personnage personnage left join fetch personnage.quetes as quete where personnage.id=:id")
	Optional<Personnage> findByIdWithQuetes(@Param("id") Long id);

	@Query("select distinct personnage from Personnage personnage left join fetch personnage.inventaire where personnage.id=:id")
	Optional<Personnage> findByIdWithInventaire(@Param("id") Long id);

	@Query("select distinct personnage from Personnage personnage left join fetch personnage.inventaire left join fetch personnage.quetes where personnage.id=:id")
	Optional<Personnage> findByIdWithInventaireAndQuetes(@Param("id") Long id);
	
	

}
