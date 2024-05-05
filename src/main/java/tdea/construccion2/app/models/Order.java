package tdea.construccion2.app.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order", catalog = "Veterinary")
public class Order {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "pet_id")
	private int petId;
	
	@Column(name = "veterinarian_id")
	private long veterinarianID;
	
	@Column(name = "owner_id")
	private long ownerId;
	
	@Column(name = "medicine")
	private String medicine;
	
	@Column(name = "date")
	private Date generationDate;
	
	@Column(name = "is_canceled")
	private boolean is_canceled;
	
	public Order() {
		this.generationDate=new Date(System.currentTimeMillis());
		this.is_canceled = false;
	}

	public boolean getIs_canceled() {
		return is_canceled;
	}

	public void setIs_canceled(boolean is_canceled) {
		this.is_canceled = is_canceled;
	}

	public int getId() {
		return id;
	}

	public void setId(int orderId) {
		this.id = orderId;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public long getVeterinarianID() {
		return veterinarianID;
	}

	public void setVeterinarianID(long veterinarianID) {
		this.veterinarianID = veterinarianID;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}
	
	

}
