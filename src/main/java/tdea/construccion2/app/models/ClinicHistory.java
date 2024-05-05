package tdea.construccion2.app.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="clinichistory")
public class ClinicHistory {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "date")
	private Date registerDate;
	
	@Column(name = "veterinarianid")
	private long veterinarianId;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "symptoms")
	private String symptoms;
	
	@Column(name = "procedure_pet")
	private String procedure;
	
	@Column(name = "diagnostic")
	private String diagnostic;
	
	@Column(name = "medicine")
	private String medicines;
	
	@Column(name = "dosis")
	private String dosis;
	
	@Column(name = "order_id")
	@JoinColumn(name = "order_id", nullable = true)
	private int orderId;
	
	@Column(name = "vaccination_history")
	private String vaccionationHistory;
	
	@Column(name = "detail")
	private String details;
	
	@Column(name = "anulation")
	private int anulation;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDosis() {
		return dosis;
	}


	public void setDosis(String dosis) {
		this.dosis = dosis;
	}


	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public long getVeterinarianId() {
		return veterinarianId;
	}

	public void setVeterinarianId(long veterinarianId) {
		this.veterinarianId = veterinarianId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getMedicines() {
		return medicines;
	}

	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getVaccionationHistory() {
		return vaccionationHistory;
	}

	public void setVaccionationHistory(String vaccionationHistory) {
		this.vaccionationHistory = vaccionationHistory;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getAnulation() {
		return anulation;
	}

	public void setAnulation(int anulation) {
		this.anulation = anulation;
	}
	
	

}
