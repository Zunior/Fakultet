package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "UPISANI_PREDMET", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"PROFESOR_ID","PREDMET_ID"})
		})
public class UpisaniPredmet {
	@Id
	@Column(name = "UPISANI_PREDMET_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "GEN_UPISANI_PREDMET")
	@TableGenerator(name = "GEN_UPISANI_PREDMET", table = "GEN_UPR_ID", pkColumnName = "PK_UPR", valueColumnName = "UPISANI_PREDMET", initialValue = 0, allocationSize = 1)
	
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "PROFESOR_PREDMET_ID", referencedColumnName = "ID")
	private ProfesorPredmet profesorPredmet;
}
