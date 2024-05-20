package tdea.construccion2.app.controller.response;

import java.util.Optional;

public class GeneralApiResponse {
	boolean status;
	String message;
	String body;
	
	public GeneralApiResponse() {
		this.body = "";
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
