package formation.sopra.formationSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Stats {
	@JsonView(JsonViews.Common.class)
	@Column(nullable = true)
	@Min(value = 0)
	@Max(10000)
	private int attaque;
	@Column(nullable = true)
	@Min(value = 0)
	@Max(10000)
	@JsonView(JsonViews.Common.class)
	private int defense;

	public Stats() {
	}

	public Stats(int attaque, int defense) {
		this.attaque = attaque;
		this.defense = defense;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	@Override
	public String toString() {
		return "Stats [attaque=" + attaque + ", defense=" + defense + "]";
	}

}
