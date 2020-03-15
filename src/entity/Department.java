package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import exceptions.DataAlreadyPresent;

@Entity
@NamedQueries(
		{
			@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d"),
			@NamedQuery(name="Department.findNaziv", 
								query="SELECT d FROM Department d WHERE d.naziv = :naziv")
		})
@Table(name = "DEPARTMENT")
public class Department{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NAZIV", unique = true)
	private String naziv;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department", orphanRemoval = true)
	@MapKey(name = "STUDIJSKIPROGRAM_ID")
	@JoinColumn(name = "STUDIJSKIPROGRAM_ID")
	private List<StudijskiProgram> studijskiProgrami;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department", orphanRemoval = true)
	@MapKey(name = "PROFESOR_ID")
	@JoinColumn(name = "PROFESOR_ID")
	private List<Profesor> profesori;

	public Department() {

	}

	public Department(String naziv) {
		this.naziv = naziv;
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

	public List<StudijskiProgram> getStudijskiProgrami() {
		return studijskiProgrami;
	}

	public void setStudijskiProgrami(List<StudijskiProgram> studijskiProgrami) {
		this.studijskiProgrami = studijskiProgrami;
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
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
		Department other = (Department) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", naziv=" + naziv + ", profesori=" + profesori + "]";
	}
	
	public void dodajProfesora(Profesor dbProfesor) {
		dbProfesor.setDepartment(this);
		getProfesori().add(dbProfesor);
	}
	
	public void dodajStudProgram(StudijskiProgram studProgram) throws DataAlreadyPresent {
//		try {
//			StudProgramKontroler.getInstance().dodajStudProgram(studProgram);
//			studProgram.setDepartment(this);
//			getStudijskiProgrami().add(studProgram);
//		} catch (DataAlreadyPresent e) {
//			throw new DataAlreadyPresent(e.getMessage());
//		}
	}
	
}
