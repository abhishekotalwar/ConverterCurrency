package com.currencyconverter.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author abhishek.kotalwar
 *
 */
public class EmailValidator implements ConstraintValidator<IsValidEmail, String> {

	private boolean notEmpty;
	private String messageNotEmpty;
	private String messageWrongEmail;
	private String inputValue = null;

	public void initialize(IsValidEmail field) {
		notEmpty = field.notEmpty();
		messageNotEmpty = field.messageNotEmpty();
		messageWrongEmail = field.messageWrongEmail();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		inputValue = value;
		context.disableDefaultConstraintViolation();
		if (null == inputValue) {
			context.buildConstraintViolationWithTemplate(messageNotEmpty).addConstraintViolation();
			return false;
		} else if (notEmpty && inputValue.isEmpty()) {
			context.buildConstraintViolationWithTemplate(messageNotEmpty).addConstraintViolation();
			return false;
		} else if (!inputValue.matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			context.buildConstraintViolationWithTemplate(messageWrongEmail).addConstraintViolation();
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @return the inputValue
	 */
	public String getInputValue() {
		return inputValue;
	}

	/**
	 * @param inputValue
	 *            the inputValue to set
	 */
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}
}
