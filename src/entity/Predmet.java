package entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Predmet {
	@Id
	@Column(name = "PREDMET_ID")
	private Long id;
	private String naziv;
	private int ESPB;

	@Enumerated(EnumType.STRING)
	@Column(name = "SEMESTAR")
	private Semestar semestar;

	@OneToMany(mappedBy = "predmet", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<ProfesorPredmet> profesorPredmeti;

	@OneToMany(mappedBy = "predmet", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<PredmetStudProgram> predmetStudProgrami;

	public Predmet() {

	}

	public Predmet(String naziv, int eSPB, Semestar semestar, List<PredmetStudProgram> predmetStudProgrami) {
		super();
		this.naziv = naziv;
		ESPB = eSPB;
		this.semestar = semestar;
		this.predmetStudProgrami = predmetStudProgrami;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getESPB() {
		return ESPB;
	}

	public void setESPB(int eSPB) {
		ESPB = eSPB;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public Set<ProfesorPredmet> getProfesorPredmeti() {
		return profesorPredmeti;
	}

	public void setProfesorPredmeti(Set<ProfesorPredmet> profesorPredmeti) {
		this.profesorPredmeti = profesorPredmeti;
	}

	public List<PredmetStudProgram> getPredmetStudProgrami() {
		return predmetStudProgrami;
	}

	public void setPredmetStudProgrami(List<PredmetStudProgram> predmetStudProgrami) {
		this.predmetStudProgrami = predmetStudProgrami;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ESPB;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((semestar == null) ? 0 : semestar.hashCode());
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
		Predmet other = (Predmet) obj;
		if (ESPB != other.ESPB)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (semestar != other.semestar)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Predmet [id=" + id + ", naziv=" + naziv + ", ESPB=" + ESPB + ", semestar=" + semestar + "]";
	}

}
