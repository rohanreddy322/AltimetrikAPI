package com.travel.dto;

public class RestException extends Exception {

	private int errorCode;
	private String body;

	public RestException() {
		super();
	}

	public RestException(int errorCode, String body) {
		super(errorCode + ":" + body);
		this.errorCode = errorCode;
		this.body = body;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
