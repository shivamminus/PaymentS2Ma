package com.payment.main.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {

	// validating credit card number
	public boolean validateCreditCard(String cardNumber) {

		// RegEx got credit card number
		String regex = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cardNumber);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

}
