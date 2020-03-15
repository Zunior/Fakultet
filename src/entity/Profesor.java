package entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries(
		{
			@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p"),
			@NamedQuery(name="Profesor.findImePrezime", 
								query="SELECT p FROM Profesor p WHERE p.ime = :ime AND p.prezime = :prezime")
		})
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "PROFESOR_ID")) })
public class Profesor extends Korisnik {

	@Enumerated(EnumType.STRING)
	@Column(name = "ZVANJE")
	private Zvanje zvanje;

	private Date datumRadnogOdnosa;

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;

	@OneToMany(mappedBy = "profesor", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<ProfesorPredmet> profesorPredmeti;

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(String ime, String prezime, Zvanje zvanje, Date datumRadnogOdnosa) {
		super(ime, prezime);
		this.zvanje = zvanje;
		this.datumRadnogOdnosa = datumRadnogOdnosa;
	}

	public Profesor(Long id, String ime, String prezime, Zvanje zvanje, Date datumRadnogOdnosa) {
		super(id, ime, prezime);
		this.zvanje = zvanje;
		this.datumRadnogOdnosa = datumRadnogOdnosa;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void Zvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public Date getDatumRadnogOdnosa() {
		return datumRadnogOdnosa;
	}

	public void setDatumRadnogOdnosa(Date datumRadnogOdnosa) {
		this.datumRadnogOdnosa = datumRadnogOdnosa;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<ProfesorPredmet> getProfesorPredmeti() {
		return profesorPredmeti;
	}

	public void setProfesorPredmeti(Set<ProfesorPredmet> profesorPredmeti) {
		this.profesorPredmeti = profesorPredmeti;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((datumRadnogOdnosa == null) ? 0 : datumRadnogOdnosa.hashCode());
		result = prime * result + ((zvanje == null) ? 0 : zvanje.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (datumRadnogOdnosa == null) {
			if (other.datumRadnogOdnosa != null)
				return false;
		} else if (!datumRadnogOdnosa.equals(other.datumRadnogOdnosa))
			return false;
		if (zvanje != other.zvanje)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profesor [zvanje=" + zvanje + ", datumRadnogOdnosa=" + datumRadnogOdnosa + ", department=" + department
				+ "]";
	}

	public void dodajPredmet(Predmet dbPredmet) {
		ProfesorPredmet dbProfesorPredmet = new ProfesorPredmet(this, dbPredmet);
		getProfesorPredmeti().add(dbProfesorPredmet);
		dbPredmet.getProfesorPredmeti().add(dbProfesorPredmet);
	}

}
