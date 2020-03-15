package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PREDMET_STUD_PROGRAM", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "PREDMET_ID", "STUDIJSKIPROGRAM_ID" }) })
public class PredmetStudProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "PREDMET_ID", referencedColumnName = "PREDMET_ID")
	private Predmet predmet;
	
	@ManyToOne
	@JoinColumn(name = "STUDIJSKIPROGRAM_ID", referencedColumnName = "STUDIJSKIPROGRAM_ID")
	private StudijskiProgram studijskiProgram;
}
