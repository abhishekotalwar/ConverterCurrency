package com.currencyconverter.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author abhishek.kotalwar
 *
 */
public class NameValidator implements ConstraintValidator<IsValidName, String> {

	private Boolean notEmpty;
	private Integer min;
	private Integer max;
	private String messageNotEmpty;
	private String messageLength;
	private String wrongPatternValue;
	private String inputValue = null;

	public void initialize(IsValidName field) {
		notEmpty = field.notEmpty();
		min = field.min();
		max = field.max();
		messageNotEmpty = field.messageNotEmpty();
		messageLength = field.messageLength();
		wrongPatternValue = field.messageWrongPattern();
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
		} else if (!(inputValue.length() > min || inputValue.length() < max)) {
			context.buildConstraintViolationWithTemplate(messageLength).addConstraintViolation();
			return false;
		} else if (!inputValue.matches("^[a-z,A-Z]+")) {
			context.buildConstraintViolationWithTemplate(wrongPatternValue).addConstraintViolation();
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
