package com.barclays.designprob.theatreseating.pojos;

public class Patron {
	private String customerName;
	private int requestedSeats;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getRequestedSeats() {
		return requestedSeats;
	}

	public void setRequestedSeats(int requestedSeats) {
		this.requestedSeats = requestedSeats;
	}
}