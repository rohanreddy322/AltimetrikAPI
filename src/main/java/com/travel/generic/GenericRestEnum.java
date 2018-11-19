package com.travel.generic;

/**
 * @author nhibare
 *
 */
public enum GenericRestEnum {
	RESPONSE_STATUS("status"), RESPONSE_BODY("body"), HTTP_HEADER("http_header");

	String value;

	private GenericRestEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
