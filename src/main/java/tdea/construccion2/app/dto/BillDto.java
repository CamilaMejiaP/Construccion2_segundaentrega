package tdea.construccion2.app.dto;

import java.sql.Date;

import tdea.construccion2.app.models.Bill;

public class BillDto {
	private int id;
	private int petId;
	private long ownerId;
	private int orderId;
	private String productName;
	private double value;
	private int amount;
	private Date date;

	public BillDto(int petId, long ownerId, int orderId, String productName, double value, int amount) {
		super();
		this.petId = petId;
		this.ownerId = ownerId;
		this.orderId = orderId;
		this.productName = productName;
		this.value = value;
		this.amount = amount;
		this.date = new Date(System.currentTimeMillis());;
	}
	public BillDto(Bill  bill) {
		super();
		this.id = bill.getId();
		this.petId = bill.getPetId();
		this.ownerId = bill.getOwnerId();
		this.orderId = bill.getOrderId();
		this.productName = bill.getProductName();
		this.value = bill.getValue();
		this.amount = bill.getAmount();
		this.date = new Date(System.currentTimeMillis());;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
