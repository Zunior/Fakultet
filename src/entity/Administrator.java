package entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "ADMINISTRATOR_ID"))
})
@NamedQueries(
		{
			@NamedQuery(name="Administrator.findAll", query="SELECT a FROM Administrator a"),
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
