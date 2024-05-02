package tdea.construccion2.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import tdea.construccion2.app.dto.SessionDto;

@Entity
@Table(name="session")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name="username")
	private String userName;
	@Column(name="role_id")
	private int userRoll;
	
	public Session(SessionDto sessionDto) {
		this.id=sessionDto.getId();
		this.userName=sessionDto.getUserName();
		this.userRoll=sessionDto.getUserRoll();
	}
	

	public Session() {
		
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(int userRoll) {
		this.userRoll = userRoll;
	}
}
