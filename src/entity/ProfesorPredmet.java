package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ProfesorPredmet", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "PROFESOR_ID", "PREDMET_ID" }) })
public class ProfesorPredmet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PROFESOR_ID", referencedColumnName = "PROFESOR_ID")
	private Profesor profesor;

	@ManyToOne
	@JoinColumn(name = "PREDMET_ID", referencedColumnName = "PREDMET_ID")
	private Predmet predmet;

	@OneToMany(mappedBy = "profesorPredmet", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<UpisaniPredmet> ispiti;

	public ProfesorPredmet() {

	}

	public ProfesorPredmet(Profesor profesor, Predmet predmet) {
		this.profesor = profesor;
		this.predmet = predmet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
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
		ProfesorPredmet other = (ProfesorPredmet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		return true;
	}

}
