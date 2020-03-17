package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(
		{
			@NamedQuery(name="KorisnickiNalog.findAll", query="SELECT kn FROM KorisnickiNalog kn")
//			@NamedQuery(name="Profesor.findImePrezime", 
//								query="SELECT p FROM Profesor p WHERE p.ime = :ime AND p.prezime = :prezime")
		})
@Table(name = "KORISNICKI_NALOG")
public class KorisnickiNalog {
	@Id
	@Column(name = "KORISNICKI_NALOG_ID")
	private Long id;
	private String username;
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "KORISNICKA_ULOGA")
	private KorisnickaUloga korisnickaUloga;

	public KorisnickiNalog() {

	}

	public KorisnickiNalog(String username, String password, KorisnickaUloga korisnickaUloga) {
		this.username = username;
		this.password = password;
		this.korisnickaUloga = korisnickaUloga;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public KorisnickaUloga getKorisnickaUloga() {
		return korisnickaUloga;
	}

	public void setKorisnickaUloga(KorisnickaUloga korisnickaUloga) {
		this.korisnickaUloga = korisnickaUloga;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		KorisnickiNalog other = (KorisnickiNalog) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
