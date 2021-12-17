package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="team")
@SequenceGenerator(name = "seqEquipe",sequenceName = "seq_equipe",initialValue = 100,allocationSize = 1)
public class Equipe {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqEquipe")
	private int id;
	
	
	
	@OneToMany(mappedBy = "team")
	private List<Personnage> membres;
	
	public Equipe() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Personnage> getMembres() {
		return membres;
	}

	public void setMembres(List<Personnage> membres) {
		this.membres = membres;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Equipe other = (Equipe) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
