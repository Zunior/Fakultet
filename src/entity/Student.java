package entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "STUDENT_ID"))
})
public class Student extends Korisnik{
	private String indeks;
	private Date datumRodjenja;
	private String studProgram;
	
	@ManyToOne
	@JoinColumn(name = "STUDIJSKIPROGRAM_ID")
	private StudijskiProgram studijskiProgram;
	
	@OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<UpisaniPredmet> ispiti;
}
