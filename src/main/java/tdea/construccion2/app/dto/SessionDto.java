package tdea.construccion2.app.dto;

import tdea.construccion2.app.models.Session;

public class SessionDto {
	private long id;
	private String username;
	private int userRoll;

	public SessionDto(long id, String username, int userRoll) {
		this.id = id;
		this.username = username;
		this.userRoll = userRoll;
	}
	public SessionDto(Session session) {
		this.id = session.getId();
		this.username = session.getUserName();
		this.userRoll = session.getUserRoll();
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public int getUserRoll() {
		return userRoll;
	}

	public void setUserRoll(int userRoll) {
		this.userRoll = userRoll;
	}
}
