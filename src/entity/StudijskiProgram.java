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
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class StudijskiProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDIJSKIPROGRAM_ID")
	private Long id;
	
	@Column(name = "NAZIV", unique = true)
	private String naziv;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studijskiProgram", orphanRemoval = true)
	@MapKey(name = "STUDENT_ID")
	@JoinColumn(name = "STUDENT_ID")
	private List<Student> studenti;
	
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	@OneToMany(mappedBy = "studijskiProgram", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<PredmetStudProgram> predmetStudProgrami;
	
	
	public StudijskiProgram() {

	}

	public StudijskiProgram(String naziv) {
		this.naziv = naziv;
	}

	public StudijskiProgram(Long id, String naziv) {
		this.id = id;
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

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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
		result = prime * result + ((department == null) ? 0 : department.hashCode());
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
		StudijskiProgram other = (StudijskiProgram) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
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
		return true;
	}

	@Override
	public String toString() {
		return "StudijskiProgram [id=" + id + ", naziv=" + naziv + ", department=" + department + "]";
	}
	
	
	
	
	
}
