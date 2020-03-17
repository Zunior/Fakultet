package dto;

public class KorisnikDTO {
	private Long korisnickiNalogId;
	private String username;
	private String password;
	private Long administratorId;
	private Long profesor_id;
	private Long student_id;

	public KorisnikDTO() {

	}

	public KorisnikDTO(Long korisnickiNalogId, String username, String password, Long administratorId, Long profesor_id,
			Long student_id) {
		super();
		this.korisnickiNalogId = korisnickiNalogId;
		this.username = username;
		this.password = password;
		this.administratorId = administratorId;
		this.profesor_id = profesor_id;
		this.student_id = student_id;
	}

	public Long getKorisnickiNalogId() {
		return korisnickiNalogId;
	}

	public void setKorisnickiNalogId(Long korisnickiNalogId) {
		this.korisnickiNalogId = korisnickiNalogId;
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

	public Long getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(Long administratorId) {
		this.administratorId = administratorId;
	}

	public Long getProfesor_id() {
		return profesor_id;
	}

	public void setProfesor_id(Long profesor_id) {
		this.profesor_id = profesor_id;
	}

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	@Override
	public String toString() {
		return "KorisnikDTO [korisnickiNalogId=" + korisnickiNalogId + ", username=" + username + ", password="
				+ password + ", administratorId=" + administratorId + ", profesor_id=" + profesor_id + ", student_id="
				+ student_id + "]";
	}
	
	

}
