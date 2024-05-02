package tdea.construccion2.app.dto;

import java.sql.Date;

import tdea.construccion2.app.models.Order;

public class OrderDto {
	
	private int id;
	private int petId;
	private long veterinarianID;
	private long ownerId;
	private String medicine;
	private Date generationDate;
	private boolean is_canceled;

	public OrderDto(int petId, long veterinarianID, long ownerId, String medicine, boolean is_canceled) {
		super();
		this.petId = petId;
		this.veterinarianID = veterinarianID;
		this.ownerId = ownerId;
		this.medicine = medicine;
		this.generationDate = new Date(System.currentTimeMillis());
		this.is_canceled =  is_canceled;
	}
	public OrderDto(Order order) {
		super();
		this.id = order.getId();
		this.petId = order.getPetId();
		this.veterinarianID = order.getVeterinarianID();
		this.ownerId = order.getOwnerId();
		this.medicine = order.getMedicine();
		this.generationDate = new Date(System.currentTimeMillis());
		this.is_canceled = order.getIs_canceled();
	}
	
	public boolean getIs_canceled() {
		return is_canceled;
	}
	public void setIs_canceled(boolean is_canceled) {
		this.is_canceled = is_canceled;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	public void setOrderId(int orderId) {
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
