package com.service.common.handler;

abstract class ApiSubError {

}

class ApiValidationError extends ApiSubError {
	private final String object;
	private String field;
	private Object rejectedValue;
	private final String message;

	ApiValidationError(final String object, final String message) {
		this.object = object;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(final String field) {
		this.field = field;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(final Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getObject() {
		return object;
	}

	public String getMessage() {
		return message;
	}

}