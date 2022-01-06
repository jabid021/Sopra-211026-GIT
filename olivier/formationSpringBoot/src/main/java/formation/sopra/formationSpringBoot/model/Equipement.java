package formation.sopra.formationSpringBoot.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@SequenceGenerator(name = "equipement_sequence") Pour du table per class !
@SequenceGenerator(name = "seqEquip", sequenceName = "seq_equipe", initialValue = 100, allocationSize = 1)
@DiscriminatorColumn(name = "type_equipement")
public abstract class Equipement {
	@JsonView(JsonViews.Common.class)
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEquip")
	protected Long id;
	@JsonView(JsonViews.Common.class)
	@NotEmpty
	protected String nom;
	@JsonView(JsonViews.Common.class)
	protected LocalDateTime creation = LocalDateTime.now();
	@JsonView(JsonViews.Common.class)
	@Embedded
	@Valid
	protected Stats stats;

	// C'est ceux qui ont recup des equipements
	@ManyToMany(mappedBy = "inventaire")
	private List<Personnage> looteurs;

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public List<Personnage> getLooteurs() {
		return looteurs;
	}

	public void setLooteurs(List<Personnage> looteurs) {
		this.looteurs = looteurs;
	}

	public Equipement() {
	}

	public Equipement(String nom, LocalDateTime creation) {
		this.nom = nom;
		this.creation = creation;
	}

	public Equipement(String nom, LocalDateTime creation, Stats stats) {
		this.nom = nom;
		this.creation = creation;
		this.stats = stats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipement other = (Equipement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
