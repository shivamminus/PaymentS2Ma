package com.payment.main.dto;

//ValidatingDTO Example
//{
//	validStatus:false
//}
public class ValidatingDAO {

	private boolean validStatus;

	public ValidatingDAO() {
		super();
	}

	public ValidatingDAO(boolean validStatus) {
		super();
		this.validStatus = validStatus;
	}

	public boolean isValidStatus() {
		return validStatus;
	}

	public void setValidStatus(boolean validStatus) {
		this.validStatus = validStatus;
	}

}