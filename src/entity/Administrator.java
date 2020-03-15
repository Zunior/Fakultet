package entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "ADMINISTRATOR_ID"))
})
public class Administrator extends Korisnik{

	public Administrator() {
		super();
	}

	public Administrator(String ime, String prezime) {
		super(ime, prezime);
		// TODO Auto-generated constructor stub
	}
		
	
}
