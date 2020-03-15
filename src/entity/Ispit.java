package entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@AttributeOverrides({
//    @AttributeOverride(name = "id", column = @Column(name = "ISPIT_ID"))
//})
public class Ispit extends UpisaniPredmet{
	private Date datumPolaganja;
	private Double ocena;
	
	public Ispit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ispit(Date datumPolaganja, Double ocena) {
		super();
		this.datumPolaganja = datumPolaganja;
		this.ocena = ocena;
	}
	
	
	
	
}
