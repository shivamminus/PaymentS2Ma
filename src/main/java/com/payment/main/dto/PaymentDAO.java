package com.payment.main.dto;

public class PaymentDAO {

	private Double charge;

	public PaymentDAO(Double charge) {
		this.charge = charge;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

}
